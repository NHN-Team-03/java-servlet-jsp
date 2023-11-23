package com.nhnacademy.hello.chain;

public class OrderPageFilter implements Filter {
    @Override
    public void doFilter(Request request, FilterChain filterChain) {
        if (request.getPath().equals("/order")) {
            Member member = (Member) request.get("member");

            if (member.hasRole(Member.Role.NONE)) {
                System.out.println("path:" + request.getPath() + " member role has NONE : true");
            } else {
                System.out.println("path:" + request.getPath() + " member role has NONE : false");
                filterChain.doFilter(request);
            }
        } else {
            System.out.println("OrderPageCheckFilter : 다음 필터로 넘김! ");
            filterChain.doFilter(request);
        }
    }
}
