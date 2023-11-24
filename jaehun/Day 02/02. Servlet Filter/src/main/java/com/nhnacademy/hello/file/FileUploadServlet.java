package com.nhnacademy.hello.file;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import lombok.extern.slf4j.Slf4j;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100,
        location = "/Users/jangjaehun/Team-03/java-servlet-jsp/jaehun/Day 02/02. Servlet Filter/src/main/resources/temp"
)

@Slf4j
@WebServlet(name = "fileUploadServlet", urlPatterns = "/file/fileUpload")
public class FileUploadServlet extends HttpServlet {
    private static final String CONTENT_DISPOSITION = "Content-Disposition";
    private static final String UPLOAD_DIR = "/Users/jangjaehun/Team-03/java-servlet-jsp/jaehun/Day 02/02. Servlet Filter/src/main/resources/";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for(Part part : req.getParts()) {
            String contentDisposition = part.getHeader(CONTENT_DISPOSITION);

            if (contentDisposition.contains("filename=")) {
                String fileName = extractFileName(contentDisposition);
                log.info("file name={}", part.getName());

                if (part.getSize() > 0) {
                    part.write(UPLOAD_DIR + File.separator + fileName);
                    part.delete();
                } else {
                    String formValue = req.getParameter(part.getName());
                    log.error("{}={}", part.getName(), formValue);
                }
            }


        }
        resp.sendRedirect("/");
    }

    private String extractFileName(String contentDisposition) {
        log.error("contentDisposition:{}", contentDisposition);

        for (String token : contentDisposition.split(";")) {
            if(token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() -1);
            }
        }

        return null;
    }
}
