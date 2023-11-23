package com.nhnacademy.student.servlet;

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
@WebServlet(name = "StudentDeleteServlet", urlPatterns = "/student/delete")
public class StudentDeleteServlet extends HttpServlet {

    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String id = Objects.requireNonNull(req.getParameter("id"));
            studentRepository.deleteById(id);
        } catch (NullPointerException e) {
            throw new RuntimeException("id가 존재하지 않습니다.");
        }

        req.setAttribute("view", "redirect:/student/list.do");
    }
}
