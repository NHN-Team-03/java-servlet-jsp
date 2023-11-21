package com.nhnacademy.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;

public class BeautifyServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(BeautifyServlet.class.getName());

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        try (PrintWriter writer = resp.getWriter()) {
            writer.println("<!Doctype html>");
            writer.println("<html>");
                writer.println("<head>");
                    writer.println("<meta charset='UTF-8'>");
                    writer.println("<title>정리되지 않은 Html 내용을 입력받아 beautify 해서 응답</title>");
                writer.println("</head>");
                writer.println("<body >");
                    writer.println("<form method ='post' action ='beautify'>");
                        writer.println("<textarea name = 'html' rows = '10' cols = '200'></textarea>");
                        writer.println("<p >");
                            writer.println("<button type = 'submit'> 전송 </button >");
                        writer.println("</p >");
                    writer.println("</form >");
                writer.println("</body >");
            writer.println("</html >");
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String html = req.getParameter("html");
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        try (PrintWriter out = resp.getWriter()) {
            out.println(Jsoup.parse(html));
        } catch (Exception ex) {
            log.info(ex.getMessage());
        }
    }
}
