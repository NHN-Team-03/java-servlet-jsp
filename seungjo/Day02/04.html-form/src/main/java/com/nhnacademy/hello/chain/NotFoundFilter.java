package com.nhnacademy.hello.chain;

public class NotFoundFilter implements Filter {
    @Override
    public void doFilter(Request request, FilterChain filterChain) {
        if (request.getPath().equals("/main")) {
            System.out.println("path:" + request.getPath() + " : Not Found Page!");
            filterChain.doFilter(request);
        } else {
            System.out.println("NotFoundFilter : 다음 필터로 넘김! ");
            filterChain.doFilter(request);
        }
    }
}
