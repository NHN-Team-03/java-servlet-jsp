package com.nhnacademy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitServlet extends HttpServlet {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Override
    public void init(ServletConfig config) throws ServletException {


        Object onion = getServletContext().getAttribute("onion");
        Object egg = getServletContext().getInitParameter("egg");
        Object greenOnion = getServletContext().getInitParameter("greenOnion");
        Object apple = getServletContext().getInitParameter("apple");

        log.info("onion = {}", onion);
        log.info("egg = {}", egg);
        log.info("greenOnion = {}", greenOnion);
        log.info("apple = {}", apple);

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try (PrintWriter out = resp.getWriter()) {

            out.println("<!Doctype html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='utf-8'>");
            out.println("<title>NHN Mart</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>NHN Mart</h1>");
            out.println("<p> 상품목록으로 이동 : <a href='/foods'>Foods</a></p>");
            out.println("</body>");
            out.println("</html>");

        }
    }

}
