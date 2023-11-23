package com.nhnacademy.student.servlet;

import static javax.servlet.RequestDispatcher.*;

import com.nhnacademy.student.command.Command;
import com.nhnacademy.student.controller.ErrorController;
import com.nhnacademy.student.controller.StudentDeleteController;
import com.nhnacademy.student.controller.StudentListController;
import com.nhnacademy.student.controller.StudentRegisterController;
import com.nhnacademy.student.controller.StudentRegisterFormController;
import com.nhnacademy.student.controller.StudentUpdateController;
import com.nhnacademy.student.controller.StudentUpdateFormController;
import com.nhnacademy.student.controller.StudentViewController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        try {
            Command command = resolveCommand(req.getServletPath(), req.getMethod());

            String view = command.execute(req, resp);
            if (view.startsWith(REDIRECT_PREFIX)) {
                log.error("redirect-url : {}", view.substring(REDIRECT_PREFIX.length()));
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
            } else {
                RequestDispatcher rd = req.getRequestDispatcher(view);
                rd.include(req, resp);
            }
        } catch (Exception ex) {
            req.setAttribute("status_code", req.getAttribute(ERROR_STATUS_CODE));
            req.setAttribute("exception_type", req.getAttribute(ERROR_EXCEPTION_TYPE));
            req.setAttribute("message", req.getAttribute(ERROR_MESSAGE));
            req.setAttribute("exception", req.getAttribute(ERROR_EXCEPTION));
            req.setAttribute("request_uri", req.getAttribute(ERROR_REQUEST_URI));
            log.error("status_code:{}", req.getAttribute(ERROR_STATUS_CODE));
            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req,resp);
        }
    }

    private Command resolveCommand(String servletPath, String method) {
        Command command = null;

        if("/student/list.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new StudentListController();
        } else if ("/student/register.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new StudentRegisterFormController();
        } else if ("/student/register.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new StudentRegisterController();
        } else if ("/student/view.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new StudentViewController();
        } else if ("/student/update.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new StudentUpdateFormController();
        } else if ("/student/update.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new StudentUpdateController();
        } else if ("/student/delete.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new StudentDeleteController();
        } else if ("/error.do".equals(servletPath)) {
            command = new ErrorController();
        }

        return command;
    }
}
