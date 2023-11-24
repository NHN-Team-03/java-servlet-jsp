package com.nhnacademy.student.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter(
        filterName = "contentTypeFilter",
        urlPatterns = "*.do",
        initParams = {
                @WebInitParam(name = "contentType", value = "text/html; charset=UTF-8")
        }
)
public class contentTypeFilter implements Filter {

    private String contentType;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.contentType = filterConfig.getInitParameter("contentType");
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
            throws IOException, ServletException {

//        log.info("contentType Filter start!");
//        log.info("contentType = {}", contentType);

        resp.setContentType(contentType);
        filterChain.doFilter(req, resp);
    }
}
