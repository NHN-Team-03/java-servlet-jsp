package com.nhnacademy.filter;

public class NotFoundResponse implements Response{
    @Override
    public void doResponse(Request request) {
        System.out.println("###### 존재하지 않는 페이지 입니다. ######");
    }
}
