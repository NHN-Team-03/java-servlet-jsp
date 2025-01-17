package com.nhnacademy.student.servlet;

import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.student.Student;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@WebServlet(name = "studentViewServlet", urlPatterns = "/student/view")
public class StudentViewServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo id null check
        String id = Objects.requireNonNull(req.getParameter("id"));
        if(Objects.isNull(id)) {
            throw new RuntimeException("parameter [id] : null");
        }

        Student student = studentRepository.getStudentById(id);

        if(Objects.isNull(student)) {
            throw new RuntimeException("Student not found : " + id);
        }

        log.error("student:{}", student);
        //todo student 조회
        req.setAttribute("student", student);

        //todo /student/view.jsp <-- forward
//        RequestDispatcher rd = req.getRequestDispatcher("/student/view.jsp");
//        rd.forward(req, resp);
        req.setAttribute("view", "/student/view.jsp");
    }


}
