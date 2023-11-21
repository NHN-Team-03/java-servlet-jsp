package com.nhnacademy.hello.chain;

public class AdminPageResponse implements Response {


    @Override
    public void doResponse(Request request) {
        System.out.println("####### response: AdminPageResponse #######");
        Member member = (Member) request.get("member");

        System.out.println("ID : " + member.getId());
        System.out.println("Name : " + member.getName());
        System.out.println("Role : " + Member.Role.ADMIN);
        System.out.println("Email : " + "seungjo@nhnacademy.com");
        System.out.println("do something ... ADMIN ... ");
    }
}
