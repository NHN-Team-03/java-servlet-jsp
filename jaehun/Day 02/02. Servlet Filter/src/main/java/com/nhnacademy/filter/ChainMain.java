package com.nhnacademy.filter;

public class ChainMain {
    public static void main(String[] args) {
        Request myPageRequest = new Request("/mypage");
        myPageRequest.put("member", Member.createUser("jaehun", "재훈", "1234"));

        Request adminPageRequest = new Request("/admin");
        adminPageRequest.put("member", Member.createAdmin("admin", "관리자", "1234"));

        Request orderRequest = new Request("/order");
        orderRequest.put("member", Member.createManager("manager", "매니저", "1234"));

        Request mainRequest = new Request("/main");
        mainRequest.put("member", Member.createUncertifiedMember("Non", "비회원", "1234"));

        System.out.println("########## /mypage 요청 ##########");
        HttpRequest httpRequest1 = new HttpRequest();
        httpRequest1.doRequest(myPageRequest);

        System.out.println("########## /admin 요청 ##########");
        HttpRequest httpRequest2 = new HttpRequest();
        httpRequest2.doRequest(adminPageRequest);

        System.out.println("########## /order 요청 ##########");
        HttpRequest httpRequest3 = new HttpRequest();
        httpRequest3.doRequest(orderRequest);

        System.out.println("########## /main 요청 ##########");
        HttpRequest httpRequest4 = new HttpRequest();
        httpRequest4.doRequest(mainRequest);
    }
}
