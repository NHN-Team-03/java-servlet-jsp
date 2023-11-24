package com.nhnacademy.student.controller;

import com.nhnacademy.student.annotation.RequestMapping;
import com.nhnacademy.student.command.Command;
import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.student.Student;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/student/view.do", method = RequestMapping.Method.GET)
public class StudentViewController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");

        String id = req.getParameter("id");

        if (Objects.isNull(id)) {
            throw new RuntimeException("parameter [id] is null");
        }
        log.error("id : {}", id);

        Student student = studentRepository.getStudentById(id);
        req.setAttribute("student", student);

        return "/student/view.jsp";
    }
}
