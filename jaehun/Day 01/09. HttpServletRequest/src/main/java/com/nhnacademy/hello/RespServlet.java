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

public class RespServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(RespServlet.class);



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO#1 buffer size 설정
        // 1024 byte = 1kb
        // 1kb 이하의 작은 양의 데이터 전송 시 출력 buffer가 꽉 차지 않아도 바로 전송.
        // 1kb 이상의 큰 데이터 데이터 전송 시 출력 버퍼가 가득 차기 전까지 데이터를 쌓은 다음 한 번에 전송.
        // default bufferSize : 8192 byte = 8KB


    }
}
