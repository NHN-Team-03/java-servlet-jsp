package com.nhnacademy.student.servlet;

import static javax.servlet.RequestDispatcher.ERROR_EXCEPTION;
import static javax.servlet.RequestDispatcher.ERROR_EXCEPTION_TYPE;
import static javax.servlet.RequestDispatcher.ERROR_MESSAGE;
import static javax.servlet.RequestDispatcher.ERROR_REQUEST_URI;
import static javax.servlet.RequestDispatcher.ERROR_STATUS_CODE;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {

    private static final String REDIRECT_PREFIX = "redirect";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        try {
            // 실제 요청 처리할 servlet을 결정
            String servletPath = resolveServlet(req.getServletPath());
            RequestDispatcher rd = req.getRequestDispatcher(servletPath);
            rd.include(req, resp);


            // 실제 요청을 처리한 servlet이 'view'라는 request 속성 값으로 view 전달
            String view = (String) req.getAttribute("view");
            if (view.startsWith(REDIRECT_PREFIX)) {
                log.error("redirect: {}", view.substring(REDIRECT_PREFIX.length() + 1));
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length() + 1));
            } else {
                rd = req.getRequestDispatcher(view);
                rd.include(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("status_code", req.getAttribute(ERROR_STATUS_CODE));
            req.setAttribute("exception_type", req.getAttribute(ERROR_EXCEPTION_TYPE));
            req.setAttribute("message", req.getAttribute(ERROR_MESSAGE));
            req.setAttribute("exception", req.getAttribute(ERROR_EXCEPTION));
            req.setAttribute("request_uri", req.getAttribute(ERROR_REQUEST_URI));

            log.error("status_code = {}", req.getAttribute(ERROR_STATUS_CODE));
            req.getRequestDispatcher("/error.jsp").forward(req, resp);

        }
    }

    private String resolveServlet(String servletPath) {

        String processingServlet = null;
        if ("/student/list.do".equals(servletPath)) {
            processingServlet = "/student/list";
        } else if ("/student/register.do".equals(servletPath)) {
            processingServlet = "/student/register";
        } else if ("/student/delete.do".equals(servletPath)) {
            processingServlet = "/student/delete";
        } else if ("/student/update.do".equals(servletPath)) {
            processingServlet = "/student/update";
        } else if ("/student/view.do".equals(servletPath)) {
            processingServlet = "/student/view";
        } else if ("/error.do".equals(servletPath)) {
            processingServlet = "/error";
        }

        return processingServlet;
    }
}
