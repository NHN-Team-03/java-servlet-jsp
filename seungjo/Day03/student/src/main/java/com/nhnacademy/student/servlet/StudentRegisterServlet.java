package com.nhnacademy.student.servlet;

import com.nhnacademy.student.Gender;
import com.nhnacademy.student.Student;
import com.nhnacademy.student.repository.StudentRepository;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@WebServlet(name = "studentRegisterServlet", urlPatterns = "/student/register")
public class StudentRegisterServlet extends HttpServlet {

    private StudentRepository studentRepository;


    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("view", "/student/register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = Objects.requireNonNull(req.getParameter("id"));
        String name = Objects.requireNonNull(req.getParameter("name"));
        String genderString = Objects.requireNonNull(req.getParameter("gender"));
        String age = Objects.requireNonNull(req.getParameter("age"));

        Gender gender = genderString.equals("M") ? Gender.M : Gender.F;

        Student student = new Student(id, name, gender, Integer.parseInt(age));
        studentRepository.save(student);

        // 해당 학생의 상세 페이지로 redirect ('/studnet/view?id={id}')
        req.setAttribute("view", "/redirect:/student/view.do?id=" + student.getId());
    }


}
