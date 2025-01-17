package com.nhnacademy;

import com.beust.jcommander.JCommander;

public class Main {
    public static void main(String[] args) {
        CgiArgs cgiArgs = new CgiArgs();

        JCommander.newBuilder()
                .addObject(cgiArgs)
                .build()
                .parse(args);

        System.out.println("content-type:" + cgiArgs.getContentType());
        System.out.println("method:" + cgiArgs.getMethod());
        System.out.println("query-string:" +cgiArgs.getQueryString());
        System.out.println("server-name" + cgiArgs.getQueryString());
        System.out.println("server-port" + cgiArgs.getPort());
        System.out.println("path:" + cgiArgs.getPath());
        System.out.println("body:" + cgiArgs.getBody());
    }
}