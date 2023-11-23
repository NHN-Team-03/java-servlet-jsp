package com.nhnacademy.student.controller;

import com.nhnacademy.student.repository.StudentRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentDeleteController implements Command {

    private StudentRepository studentRepository;
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        this.studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");

        String id = req.getParameter("id");
        log.info("id = {}", id);

        studentRepository.deleteById(id);

        return "redirect:/student/list.do";
    }
}
