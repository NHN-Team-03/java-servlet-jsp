package com.nhnacademy.student.controller;

import com.nhnacademy.student.command.Command;
import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.student.Student;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentListController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");

        List<Student> studentList = studentRepository.getStudents();

        req.setAttribute("studentList", studentList);

        return "/student/list.jsp";
    }
}
