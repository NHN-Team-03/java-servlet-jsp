package com.nhnacademy.student.controller;

import com.nhnacademy.student.annotation.RequestMapping;
import com.nhnacademy.student.command.Command;
import com.nhnacademy.student.repository.StudentRepository;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/student/delete.do", method = RequestMapping.Method.POST)
public class StudentDeleteController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        String id = req.getParameter("id");
        log.error("id : {}", id);
        if (Objects.isNull(id)) {
            throw new RuntimeException("Parameter [id] is null");
        }

        studentRepository.deleteById(id);

        return "redirect:/student/list.do";
    }
}
