package com.nhnacademy.student.servlet;

import com.nhnacademy.student.Gender;
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

@WebServlet(name = "StudentUpdateServlet", urlPatterns = "/student/update")
public class StudentUpdateServlet extends HttpServlet {

    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = Objects.requireNonNull(req.getParameter("id"));
        Student student = studentRepository.getStudentById(id);
        req.setAttribute("student", student);

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
        studentRepository.update(student);

        req.setAttribute("view", "redirect:/student/view.do?id=" + student.getId());
    }
}
