package com.nhnacademy.student.factory;

import com.nhnacademy.student.annotation.RequestMapping;
import com.nhnacademy.student.command.Command;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ControllerFactory {
    private final ConcurrentMap<String, Object> beanMap = new ConcurrentHashMap<>();

    public void init(Set<Class<?>> c) {
        //todo beanMap에 key = method + servletPath, value = Controller instance를 저장합니다.
        for (Class<?> clazz : c) {
            try {
                RequestMapping requestMapping = clazz.getAnnotation(RequestMapping.class);
                if (Objects.isNull(requestMapping))
                    continue;
                String key = requestMapping.method().toString().concat(requestMapping.value());
                log.error("put key : {}", key);
                Object value = clazz.newInstance();

                beanMap.put(key, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    public Object getBean(String method, String path) {
        log.error("key : {}", method.concat(path));
        Object container = beanMap.get(method.concat(path));
        return container;
    }
}
