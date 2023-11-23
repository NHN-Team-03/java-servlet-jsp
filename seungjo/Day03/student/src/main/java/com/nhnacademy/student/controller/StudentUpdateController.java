package com.nhnacademy.student.controller;

import com.nhnacademy.student.Student;
import com.nhnacademy.student.repository.StudentRepository;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentUpdateController implements Command {
    private StudentRepository studentRepository;

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        this.studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");

        String id = Objects.requireNonNull(req.getParameter("id"));
        Student student = studentRepository.getStudentById(id);
        req.setAttribute("student", student);

        return "/student/register.jsp";
    }
}
