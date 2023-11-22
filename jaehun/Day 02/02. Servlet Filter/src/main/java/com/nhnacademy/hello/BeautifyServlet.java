package com.nhnacademy.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;

@WebServlet(
        name = "beautifyServlet",
        urlPatterns = "/beauty",
        loadOnStartup = 3
)
public class BeautifyServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(BeautifyServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String html = req.getParameter("html");
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");

        try(PrintWriter out = resp.getWriter()) {
            out.println(Jsoup.parse(html));
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}
