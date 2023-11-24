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
import com.nhnacademy.student.factory.ControllerFactory;
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
            ControllerFactory controllerFactory = (ControllerFactory) req.getServletContext().getAttribute("controllerFactory");
            Command command = (Command) controllerFactory.getBean(req.getMethod(), req.getServletPath());
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
}
