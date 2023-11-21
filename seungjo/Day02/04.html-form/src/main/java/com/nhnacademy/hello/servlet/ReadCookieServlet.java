package com.nhnacademy.hello.servlet;

import com.nhnacademy.util.CookieUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadCookieServlet extends HttpServlet {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = CookieUtils.getCookie(req, "locale");

        log.info("cookie.getName = {}", cookie.getName());
        log.info("cookie.getValue = {}", cookie.getValue());

        if (Objects.isNull(cookie)) {
            resp.sendError(500, "cookie not found");
            return;
        }

        String messageKey = "hello";

        String locale = cookie.getValue();
        String helloValue = ResourceBundle.getBundle("message", new Locale(locale)).getString(messageKey);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!Doctype html>");
            out.println("<html>");
                out.println("<head>");
                    out.println("<meta charset='utf-8'>");
                out.println("</head>");
                out.println("<body>");
                    out.println("<h1>" + helloValue + "</h1>");
                out.println("</body>");
            out.println("</html>");
        }

    }
}