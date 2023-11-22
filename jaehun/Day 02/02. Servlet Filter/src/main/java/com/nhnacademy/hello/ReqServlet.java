package com.nhnacademy.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(
        name = "reqServlet",
        urlPatterns = "/req",
        loadOnStartup = 5
)
public class ReqServlet extends HttpServlet {

    private static Logger log = LoggerFactory.getLogger(ReqServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("default buffer size : {}", resp.getBufferSize());
        resp.setBufferSize(1024);

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");

        try (PrintWriter writer = resp.getWriter()) {
            writer.println("locale=" + req.getLocale());
            writer.println("parameter name=" + req.getParameter("name"));


            String userId = req.getParameter("userId");
            log.info("userId:{}", userId);

            if (userId == null || userId.isEmpty()) {
                resp.reset();

                resp.setStatus(500);

                resp.sendError(500, "name is empty");
                return;
            }

            String redirect = req.getParameter("redirect");

            if (Objects.nonNull(redirect)) {
                resp.sendRedirect(redirect);
                return;
            }

            writer.println("method=" + req.getMethod());
            writer.println("request uri=" + req.getRequestURI());


            resp.resetBuffer();

            writer.println("User-Agent header=" + req.getHeader("User-Agent"));
        } catch (Exception e) {
            log.error("/req : {}", e.getMessage(), e);
        }
    }
}
