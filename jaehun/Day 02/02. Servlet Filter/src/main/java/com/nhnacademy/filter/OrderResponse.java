package com.nhnacademy.filter;

public class OrderResponse implements Response{
    @Override
    public void doResponse(Request request) {
        System.out.println("###### response:OrderResponse ######");
        Member member = (Member) request.get("member");

        System.out.println("주문 페이지 입니다.");
        System.out.println("아이디: " + member.getId());
        System.out.println("이름: " + member.getName());
        System.out.println("등급: " + member.getRole());
        System.out.println("주소: " + "조선대학교");
        System.out.println("do something ... ORDER ...");
    }
}
