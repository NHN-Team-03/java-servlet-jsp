package com.nhnacademy.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MultiServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(MultiServlet.class.getName());

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"ko\">");
                out.println("<head>");
                    out.println("<title>multiple choices</title>");
                    out.println("<meta charset=\"UTF-8\" />");
                out.println("</head>");
                out.println("<body>");
                    out.println("<form method=\"post\" action=\"/multi\">");
                    out.println("<ul>");
                        out.println("<li><input type=\"checkbox\" name=\"class\" id=\"class_java\" value=\"java\" /> <label for=\"class_java\" >Java</label></li>");
                        out.println("<li><input type=\"checkbox\" name=\"class\" id=\"class_html\" value=\"html\" /> <label for=\"class_html\">HTML</label></li>");
                        out.println("<li><input type=\"checkbox\" name=\"class\" id=\"class_maven\" value=\"maven\" /> <label for=\"class_maven\">Maven</label></li>");
                        out.println("<li><input type=\"checkbox\" name=\"class\" id=\"class_servlet\" value=\"servlet\" />  <label for=\"class_servlet\">Servlet</label></li>");
                    out.println("</ul>");
                    out.println("<input type=\"submit\" value=\"전송\" />");
                    out.println("</form>");
                out.println("</body>");
            out.println("</html>");
        } catch (
                IOException ex) {
            log.info(ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] values = req.getParameterValues("class");
        String url = getServletContext().getInitParameter("url");

        try (PrintWriter out = resp.getWriter()) {
            out.println(String.join(",", values));
            out.printf("url: %s\n", url);
        } catch (IOException ex) {
            log.info(ex.getMessage());
        }
    }

}
