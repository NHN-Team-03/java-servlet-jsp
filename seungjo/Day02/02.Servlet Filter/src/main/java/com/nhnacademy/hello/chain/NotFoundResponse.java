package com.nhnacademy.hello.chain;

public class NotFoundResponse implements Response {
    @Override
    public void doResponse(Request request) {
        System.out.println("존재하지 않는 페이지!");
    }
}
