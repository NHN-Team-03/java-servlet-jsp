package com.nhnacademy.student.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nhnacademy.student.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonStudentRepository implements StudentRepository {

    private final ObjectMapper objectMapper;

    private static final String JSON_FILE_PATH =
            "/Users/seungjo/java-servlet-jsp/seungjo/Day03/student/src/main/json/student.json";

    public JsonStudentRepository() {
        objectMapper = new ObjectMapper();

        // LocalDateTime json 직렬화 / 역직렬화 가능하도록 설정
        objectMapper.registerModule(new JavaTimeModule());

        // TODO : JSON_FILE_PATH 경로에 json 파일이 존재하면 삭제

        File file = new File(JSON_FILE_PATH);
        if (file.exists()) {
            file.delete();
            log.info("delete file!");
        } else {
            log.info("not exists file..");
        }
    }

    private synchronized List<Student> readJsonFile() {
        // todo json 파일이 존재하지 않다면 비어있는 List<Student> 리턴
        File file = new File(JSON_FILE_PATH);

        List<Student> students = new LinkedList<>();
        if (!file.exists()) {
            return students;
        }

        // json read & 역직렬화 (json String -> Object)
        try (FileInputStream fileInputStream = new FileInputStream(file);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            students = objectMapper.readValue(bufferedReader, new TypeReference<List<Student>>() {
            });
            return students;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void writeJsonFile(List<Student> studentList) {
        // List<Student> -> json 파일로 저장 (직렬화)

        File file = new File(JSON_FILE_PATH);

        try (FileWriter fileWriter = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fileWriter)) {
            objectMapper.writeValue(bw, studentList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Student student) {
        // json String -> Object 형태로 변화 (직렬화)
        List<Student> students = readJsonFile();

        // List에 student 추가
        students.add(student);

        // List<Student> 객체를 json String 형태로 저장 (직렬화)
        writeJsonFile(students);

    }

    @Override
    public void update(Student student) {

        System.out.println("student = " + student.getName());

        List<Student> students = readJsonFile();

        for (Student findStudent : students) {
            if (findStudent.getId().equals(student.getId())) {

                System.out.println(findStudent.getName());
                findStudent.setId(student.getId());
                findStudent.setName(student.getName());
                findStudent.setGender(student.getGender());
                findStudent.setAge(student.getAge());
                break;
            }
        }

        writeJsonFile(students);
    }

    @Override
    public void deleteById(String id) {

        List<Student> students = readJsonFile();

        for (Student student : students) {
            if (student.getId().equals(id)) {
                students.remove(student);
                break;
            }
        }

        writeJsonFile(students);
    }

    @Override
    public Student getStudentById(String id) {
        List<Student> studentList = readJsonFile();

        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }

        throw new IllegalStateException("존재하지 않는 학생입니다.");
    }

    @Override
    public List<Student> getStudents() {
        return readJsonFile();
    }

    @Override
    public boolean existById(String id) {
        List<Student> students = readJsonFile();

        for (Student student : students) {
            if (student.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
