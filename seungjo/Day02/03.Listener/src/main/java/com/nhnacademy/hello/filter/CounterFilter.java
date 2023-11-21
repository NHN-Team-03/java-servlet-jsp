package com.nhnacademy.hello.filter;

import com.nhnacademy.util.CounterUtils;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CounterFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        CounterUtils.increaseCounter(servletRequest.getServletContext());

        filterChain.doFilter(servletRequest, servletResponse);

        log.error("counter = {}", servletRequest.getServletContext().getAttribute("counter"));
    }
}
