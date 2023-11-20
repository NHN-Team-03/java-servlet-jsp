package com.nhnacademy.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class requestServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(requestServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        try (PrintWriter out = resp.getWriter()) {
            out.println("locale = " + req.getLocale());
            out.println("parameter name = " + req.getParameter("userId"));
            out.println("content type = " + req.getContentType());
            out.println("content length = " + req.getContentLength());
            out.println("method = " + req.getMethod());
            out.println("servlet path = " + req.getServletPath());
            out.println("request uri = " + req.getRequestURI());
            out.println("request url = " + req.getRequestURL());
            out.println("User-Agent header = " + req.getHeader("User-Agent"));
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

}
