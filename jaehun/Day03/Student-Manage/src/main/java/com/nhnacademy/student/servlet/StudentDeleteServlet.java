package com.nhnacademy.student.servlet;

import com.nhnacademy.student.repository.StudentRepository;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@WebServlet(name = "studentDeleteServlet", urlPatterns = "/student/delete")
public class StudentDeleteServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        log.error("id {}", id);

        if(id == null) {
            throw new RuntimeException("Student Delete : id is null");
        }

        studentRepository.deleteById(id);

//        resp.sendRedirect("/student/list");
        req.setAttribute("view", "redirect:/student/list.do");
    }
}
