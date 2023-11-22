package com.nhnacademy.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "counterServlet",
        urlPatterns = "/counter",

        initParams = {
                @WebInitParam(name = "counter", value = "100")
        },

        loadOnStartup = 5
)
public class CounterServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(CounterServlet.class.getName());

    private long count;
    private String url;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        count = Optional.ofNullable(config.getInitParameter("counter"))
                .map(Long::parseLong)
                .orElse(0l);
        url = getServletContext().getInitParameter("url");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        count++;

        try (PrintWriter writer = resp.getWriter()) {
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<meta charset='utf-8'>");
            writer.println("</head>");
            writer.println("<body>");
            writer.printf("<h1>%d</h1>\n", count);
            writer.printf("<h1>%s</h1>\n", url);
            writer.println("</body>");
            writer.println("</html>");
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }
}
