package com.nhnacademy.student.repository;

import com.nhnacademy.student.student.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class MapStudentRepository implements StudentRepository{
    private Map<String, Student> studentMap = new ConcurrentHashMap<>();

    @Override
    public void save(Student student) {
        studentMap.put(student.getId(), student);
    }

    @Override
    public void update(Student student) {
        if (!existById(student.getId())) {
            throw new IllegalArgumentException("MapStudentRepository: 등록된 학생이 아닙니다. 수정할 수 없습니다.");
        }

        studentMap.put(student.getId(), student);
    }

    @Override
    public void deleteById(String id) {
        studentMap.remove(id);
    }

    @Override
    public Student getStudentById(String id) {
        return studentMap.get(id);
    }

    @Override
    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();
        for(Map.Entry<String, Student> entry : studentMap.entrySet()) {
            studentList.add(entry.getValue());
        }

        return studentList;
    }

    @Override
    public boolean existById(String id) {
        return studentMap.containsKey(id);
    }
}
