package com.nhnacademy.student.controller;

import com.nhnacademy.student.command.Command;
import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.student.Gender;
import com.nhnacademy.student.student.Student;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentUpdateController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository =
                (StudentRepository) req.getServletContext().getAttribute("studentRepository");

        String id = req.getParameter("id");
        String name = req.getParameter("name");

        Gender gender = null;
        if (Objects.nonNull(req.getParameter("gender"))) {
            gender = Gender.valueOf(req.getParameter("gender"));
        }

        Integer age = null;
        if (Objects.nonNull(req.getParameter("age"))) {
            age = Integer.valueOf(req.getParameter("age"));
        }

        if (Objects.isNull(id) || Objects.isNull(name) || Objects.isNull(gender) || Objects.isNull(age)) {
            throw new RuntimeException("id, name, gender, age를 확인해주세요.");
        }

        Student student = new Student(id, name, gender, age);
        studentRepository.update(student);

        return "redirect:/student/view.do?id=" + student.getId();
    }
}
