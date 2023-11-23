package com.nhnacademy.hello.chain;

public class HttpRequest {
    private final FilterChain filterChain = new FilterChain();

    public HttpRequest() {
        initFilter();
    }

    public void doRequest(Request request) {
        filterChain.doFilter(request);
    }

    public void initFilter() {
        filterChain.addFilter(new MyPageFilter());
        filterChain.addFilter(new AdminFilter());
        filterChain.addFilter(new OrderPageFilter());
        filterChain.addFilter(new NotFoundFilter());
    }
}
