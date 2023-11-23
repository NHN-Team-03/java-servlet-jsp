package com.nhnacademy.hello.chain;

public class MyPageResponse implements Response {
    @Override
    public void doResponse(Request request) {
        System.out.println("####### response: MyPageResponse #######");
        Member member = (Member) request.get("member");

        System.out.println("ID : " + member.getId());
        System.out.println("Name : " + member.getName());
        System.out.println("Role : " + Member.Role.USER);
        System.out.println("Address : " + "광주광역시 동구 조선대 5길 IT융합대학 ");
        System.out.println("do something ... USER ... ");
    }
}
