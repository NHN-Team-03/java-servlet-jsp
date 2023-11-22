package com.nhnacademy.filter;

public class MyPageResponse implements Response{
    @Override
    public void doResponse(Request request) {
        System.out.println("###### response:MypageResponse #####");
        Member member = (Member) request.get("member");

        System.out.println("아이디: " + member.getId());
        System.out.println("이름: " + member.getName());
        System.out.println("등급: " + Member.Role.USER);
        System.out.println("주소: " + "조선대학교");
        System.out.println("do something ... USER ...");
    }
}
