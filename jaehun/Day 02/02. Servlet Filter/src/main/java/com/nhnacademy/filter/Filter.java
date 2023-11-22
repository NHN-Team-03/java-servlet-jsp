package com.nhnacademy.filter;

public interface Filter {
    void doFilter(Request request, FilterChain filterChain);
}
