package com.nhnacademy.hello.file;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(
        name = "fileDownloadServlet",
        urlPatterns = "/file/fileDownload"
)
public class FileDownloadServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "/Users/jangjaehun/Team-03/java-servlet-jsp/jaehun/Day 02/02. Servlet Filter/src/main/resources/temp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("fileName");

        if(Objects.isNull(fileName) || fileName.isEmpty()) {
            resp.sendError(400, "fileName parameter is needed");
            return ;
        }

        String filePath = UPLOAD_DIR + File.separator + fileName;
        Path path = Paths.get(filePath);

        if(!Files.exists(path)) {
            log.error("File not found: " + fileName);
            resp.sendError(404, "File not found: " + fileName);

            return;
        }

        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition", "attachment; filename=" + fileName);

        try (InputStream is = Files.newInputStream(path);
             OutputStream os = resp.getOutputStream()) {
            byte[] buffer = new byte[4096];

            int n;

            while (-1 != (n = is.read(buffer))) {
                os.write(buffer, 0, n);
            }
        } catch (IOException e) {
            log.error("", e);
        }
    }
}
