package com.nhnacademy.hello.chain;

public class ChainMain {
    public static void main(String[] args) {

//        Request myPageRequest = new Request("/mypage");
//        myPageRequest.put("member", Member.createUser("seungjo", "승조", "1234"));
//
//        Request adminPageRequest = new Request("/admin");
//        adminPageRequest.put("member", Member.createAdmin("admin", "관리자", "1234"));
//
//        System.out.println("############ /mypage 요청 ############");
//        HttpRequest myPageHttpRequest = new HttpRequest();
//        myPageHttpRequest.doRequest(myPageRequest);
//
//        System.out.println("############ /admin 요청 ############");
//        HttpRequest adminPageHttpRequest = new HttpRequest();
//        adminPageHttpRequest.doRequest(adminPageRequest);

        // order 요청
//        Request orderRequest = new Request("/order");
//
//        System.out.println("############ /order 요청 (관리자) ############");
//        orderRequest.put("member", Member.createAdmin("admin", "관리자", "1234"));
//        HttpRequest orderHttpRequest = new HttpRequest();
//        orderHttpRequest.doRequest(orderRequest);
//
//        orderRequest.put("member", Member.createManager("manager", "매니저", "1234"));
//        System.out.println("############ /order 요청 (매니저) ############");
//        orderHttpRequest.doRequest(orderRequest);
//
//        System.out.println("############ /order 요청 (사용자) ############");
//        orderRequest.put("member", Member.createUser("user", "사용자", "1234"));
//        orderHttpRequest.doRequest(orderRequest);
//
//
        // 비회원 order 요청
        System.out.println("############ /order 요청 (비회원) ############");
        Request nonOrderRequest = new Request("/order");
        nonOrderRequest.put("member", Member.createUncertifiedMember("none", "비회원", "0000"));
        HttpRequest nonOrderHttpRequest = new HttpRequest();
        nonOrderHttpRequest.doRequest(nonOrderRequest);

        // main 요청
        System.out.println("############ /main 요청 ############");
        Request mainRequest = new Request("/main");
        mainRequest.put("member", Member.createUser("user", "사용자", "1234"));
        HttpRequest mainHttpRequest = new HttpRequest();
        mainHttpRequest.doRequest(mainRequest);
    }
}
