package com.nhnacademy.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class requestServlet extends HttpServlet {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**
         * TODO #1 buffer size 설정
         * 1024 byte = 1kb
         *  - 1KB 이하의 작은 양의 데이터 전송 시 출력 buffer가 꽉 차지 않도록 바로 전송.
         *  - 1KB 이상의 큰 데이터 양을 전송할 때는 출력 버퍼가 가득 차기 전 까지 데이터를 쌓은 당므에 한 번에 전송.
         *  - default bufferSize : 8192 byte = 8KB
         */

        log.info("default buffer size : {}", resp.getBufferSize());
        resp.setBufferSize(1024);

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        try (PrintWriter out = resp.getWriter()) {

            out.println("locale = " + req.getLocale());
            out.println("parameter name = " + req.getParameter("name"));

            // TODO #2 flush 버퍼링 된 출력 바이트를 즉시 쓰도록 (소켓을 통해서 내보냄) 강제함. clinet와 연결 종료
            // 즉, 아래 로직은 실행 되더라도 브라우저에 표시되지 않음
            // out.flush();
            // out.close();

            String userId = req.getParameter("userId");
            log.info("userId = {}", userId);

            if (userId == null || userId.isEmpty()) {
                // TODO #3 response 초기화
                resp.reset();

                // TODO #4 error 코드 (500) 설정
                resp.setStatus(500);

                // TODO #5 에러 코드를 500으로 설정하고, error message 'name is empty' 설정
                resp.sendError(500, "name is empty");
                return;
            }

            // TODO #6 redirect
            String redirect = req.getParameter("redirect");

            if (Objects.nonNull(redirect)) {
                resp.sendRedirect(redirect);
                return;
            }

            out.println("method = " + req.getMethod());
            out.println("request uri = " + req.getRequestURI());

            // TODO #7 reset buffer - response 객체에 담겨 있던 모든 buffer 초기화
            resp.resetBuffer();

            out.println("User-Agent header = " + req.getHeader("User-Agent"));
        } catch (IOException e) {
            log.error("/req = {}", e.getMessage(), e);
        }
    }
}
