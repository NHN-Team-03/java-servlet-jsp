package com.nhnacademy.filter;

public class OrderFilter implements Filter{
    @Override
    public void doFilter(Request request, FilterChain filterChain) {
        if (request.getPath().equals("/order")) {
            Member member = (Member) request.get("member");
            if (!(member.hasRole(Member.Role.NONE))) {
                System.out.println("path: " + request.getPath() + " member role has not NONE : true");
                filterChain.doFilter(request);
            } else {
                System.out.println("path: " + request.getPath() + " member role has not NONE: false");
            }

        } else {
            System.out.println("OrderFilter: 다음 필터로 넘김!");

            filterChain.doFilter(request);
        }
    }
}
