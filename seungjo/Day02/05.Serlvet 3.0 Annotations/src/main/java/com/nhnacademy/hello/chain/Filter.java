package com.nhnacademy.hello.chain;

public interface Filter {
    void doFilter(Request request, FilterChain filterChain);
}
