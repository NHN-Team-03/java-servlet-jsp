package com.nhnacademy.student.controller;

import static javax.servlet.RequestDispatcher.*;

import com.nhnacademy.student.annotation.RequestMapping;
import com.nhnacademy.student.command.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/error.do")
public class ErrorController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("status_code", ERROR_STATUS_CODE);
        req.setAttribute("exception_type", ERROR_EXCEPTION_TYPE);
        req.setAttribute("excepion", ERROR_EXCEPTION);
        req.setAttribute("message", ERROR_MESSAGE);
        req.setAttribute("request_uri", ERROR_REQUEST_URI);

        return "/error.jsp";
    }
}
