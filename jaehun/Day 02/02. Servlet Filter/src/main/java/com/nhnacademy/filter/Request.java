package com.nhnacademy.filter;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

public class Request {
    @Getter
    private final String path;
    private final Map<String, Object> data = new HashMap<>();

    public Request(String path) {
        this.path = path;
    }

    public void put(String key, Object value) {
        data.put(key, value);
    }

    public Object get(String key) {
        return data.get(key);
    }

}
