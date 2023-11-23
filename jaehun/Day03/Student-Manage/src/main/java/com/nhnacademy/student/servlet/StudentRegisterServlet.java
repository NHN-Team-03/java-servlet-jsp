package com.nhnacademy.student.servlet;

import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.student.Gender;
import com.nhnacademy.student.student.Student;
import java.io.IOException;
import java.time.LocalDateTime;
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
//@WebServlet(name = "studentRegisterServlet", urlPatterns = "/student/register")
public class StudentRegisterServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //todo  init studentRepository
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo  /student/register.jsp forward 합니다.
//        RequestDispatcher rd = req.getRequestDispatcher("/student/register.jsp");
//        rd.forward(req, resp);
        req.setAttribute("view", "/student/register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo null check
//        String id = Objects.requireNonNull(req.getParameter("id"));
//        String name = Objects.requireNonNull(req.getParameter("name"));
//        String stringGender = Objects.requireNonNull(req.getParameter("gender"));
//        int age = Integer.parseInt(Objects.requireNonNull(req.getParameter("age")));
//
//        Gender gender = stringGender.equals("M") ? Gender.M : Gender.F;

        String id = req.getParameter("id");
        String name = req.getParameter("name");

        Gender gender = null;
        if(Objects.nonNull(req.getParameter("gender"))){
            gender = Gender.valueOf(req.getParameter("gender"));
        }

        Integer age = null;
        if(Objects.nonNull(req.getParameter("age"))){
            age = Integer.parseInt(req.getParameter("age"));
        }

        if(Objects.isNull(id) || Objects.isNull(name) || Objects.isNull(gender) || Objects.isNull(age)){
            throw new RuntimeException("id,name,gender,age 확인해주세요!");
        }

        //todo save 구현
        Student student = new Student(id, name, gender, age);
        studentRepository.save(student);

        //todo redirect /student/view?id=student1
//        resp.sendRedirect("/student/view?id=" + student.getId());
        req.setAttribute("view", "redirect:/student/view.do?id=" + student.getId());
    }
}
