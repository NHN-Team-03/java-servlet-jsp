package com.nhnacademy.student.servlet;

import com.nhnacademy.student.Student;
import com.nhnacademy.student.repository.StudentRepository;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "StudentViewServlet", urlPatterns = "/student/view")
public class StudentViewServlet extends HttpServlet {

    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = Objects.requireNonNull(req.getParameter("id"));
        Student student = Objects.requireNonNull(studentRepository.getStudentById(id));

        log.error("student = {}", student);
        req.setAttribute("student", student);
        req.setAttribute("view", "/student/view.jsp");
    }

}
