package com.nhnacademy.student.factory;

import com.nhnacademy.student.controller.Command;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ControllerFactory {

    private final ConcurrentMap<String, Object> beanMap = new ConcurrentHashMap<>();

    public void init(Set<Class<?>> c) {
        try {
            for (Class<?> clazz : c) {
                for (Annotation annotation : clazz.getDeclaredAnnotations()) {
                    if (annotation instanceof RequestMapping) {
                        createInstance(clazz, (RequestMapping) annotation);
                        break;
                    }
                }
            }
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Object getBean(String method, String path) throws ClassNotFoundException {

        Object bean = beanMap.get(method + path);
        if (Objects.nonNull(beanMap.get(method + path))) {
            return bean;
        }

        log.info("not found bean");
        return null;
    }

    private void createInstance(Class<?> clazz, RequestMapping annotation)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {
        RequestMapping.Method method = annotation.method();
        String servletPath = annotation.value();

        Class<?> controller = Class.forName(clazz.getName());
        Command command = (Command) controller.getConstructor().newInstance();

        beanMap.put(method + servletPath, command);
    }
}
