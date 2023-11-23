package com.nhnacademy.student.controller;

import com.nhnacademy.student.Gender;
import com.nhnacademy.student.Student;
import com.nhnacademy.student.repository.StudentRepository;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentUpdateFormController implements Command {

    private StudentRepository studentRepository;

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        this.studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");

        String id = Objects.requireNonNull(req.getParameter("id"));
        String name = Objects.requireNonNull(req.getParameter("name"));
        String genderString = Objects.requireNonNull(req.getParameter("gender"));
        String age = Objects.requireNonNull(req.getParameter("age"));

        Gender gender = genderString.equals("M") ? Gender.M : Gender.F;

        Student student = new Student(id, name, gender, Integer.parseInt(age));

        log.info("student: {}", student);
        studentRepository.update(student);

        return "redirect:/student/view.do?id=" + student.getId();
    }
}
