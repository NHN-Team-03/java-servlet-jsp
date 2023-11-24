package com.nhnacademy.student.controller;

import com.nhnacademy.student.Student;
import com.nhnacademy.student.factory.RequestMapping;
import com.nhnacademy.student.repository.StudentRepository;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/student/list.do", method = RequestMapping.Method.GET)
public class StudentListController implements Command {

    private StudentRepository studentRepository;

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");

        List<Student> studentList = studentRepository.getStudents();
        req.setAttribute("studentList", studentList);

        return "/student/list.jsp";
    }
}
