package com.nhnacademy.hello.chain;

public class OrderResponse implements Response {
    @Override
    public void doResponse(Request request) {
        System.out.println("####### response: OrderResponse #######");
        Member member = (Member) request.get("member");

        System.out.println("ID : " + member.getId());
        System.out.println("Name : " + member.getName());
        System.out.println("Role : " + member.getRole());
        System.out.println("do somthing ...");
    }
}
