package com.nhnacademy.student.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nhnacademy.student.student.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonStudentRepository implements StudentRepository {
    private final ObjectMapper objectMapper;
    private static final String JSON_FILE_PATH = "/Users/jangjaehun/Team-03/java-servlet-jsp/jaehun/Day03/Student-Manage/src/main/json/student.json";

    public JsonStudentRepository() {
        objectMapper = new ObjectMapper();
        //LocalDatetime json 직열화/역직렬화 가능하도록 설정
        objectMapper.registerModule(new JavaTimeModule());
        //todo JSON_FILE_PATH 경로에 json 파일이 존재하면 삭제 합니다.
        if (Files.exists(Paths.get(JSON_FILE_PATH))) {
            new File(JSON_FILE_PATH).delete();
        }
    }

    private synchronized List<Student> readJsonFile() {
        //todo json 파일이 존재하지 않다면 비어있는 List<Student> 리턴
        File file = new File(JSON_FILE_PATH);
        List<Student> students = new LinkedList<>();
        if(!file.exists()) {
            return students;
        }

        //json read & 역직렬화 ( json string -> Object )
        try(FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ) {
            students = objectMapper.readValue(bufferedReader, new TypeReference<List<Student>>() {});
            return  students;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void writeJsonFile(List<Student> studentList) {
        // List<Student> 객체를 -> json 파일로 저장 : 직렬화
        File file = new File(JSON_FILE_PATH);

        try(
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            objectMapper.writeValue(bufferedWriter,studentList);
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
        // List<Student> 객체를 -> json String 형태로 저장 (직렬화)
        writeJsonFile(students);
    }

    @Override
    public void update(Student student) {
        List<Student> students = readJsonFile();


        for (Student target : students) {
            if (student.getId().equals(target.getId())) {
                target.setName(student.getName());
                target.setGender(student.getGender());
                target.setAge(student.getAge());
                writeJsonFile(students);
                break;
            }
        }

        throw new IllegalArgumentException("Student not found : " + student.getId());
    }

    @Override
    public void deleteById(String id) {
        List<Student> students = readJsonFile();

        for (Student target : students) {
            if (id.equals(target.getId())) {
                students.remove(target);
                writeJsonFile(students);
                return;
            }
        }

        throw new IllegalArgumentException("Student not found : " + id);
    }

    @Override
    public Student getStudentById(String id) {
        List<Student> students = readJsonFile();

        for (Student target : students) {
            if (id.equals(target.getId())) {
                return target;
            }
        }

        throw new IllegalArgumentException("Student not fount : " + id);
    }

    @Override
    public List<Student> getStudents() {
        return readJsonFile();
    }

    @Override
    public boolean existById(String id) {
        List<Student> students = readJsonFile();

        for (Student student : students) {
            if (id.equals(student.getId())) {
                return true;
            }
        }

        return false;
    }
}

