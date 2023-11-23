package com.nhnacademy.hello;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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

        String htmlPath = "src/main/webapp/multi.html";

        File file = new File(htmlPath);
        System.out.println(file.getName());

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");


        try (PrintWriter out = resp.getWriter();
             BufferedReader br = new BufferedReader(new InputStreamReader(getServletContext().getResourceAsStream(htmlPath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                out.println(line);
            }
        } catch (IOException ex) {
            log.info(ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] values = req.getParameterValues("class");

        try (PrintWriter out = resp.getWriter()) {
            out.println(String.join(",", values));
        } catch (IOException ex) {
            log.info(ex.getMessage());
        }
    }

}
