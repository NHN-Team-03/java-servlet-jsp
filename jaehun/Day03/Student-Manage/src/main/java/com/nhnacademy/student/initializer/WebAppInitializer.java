package com.nhnacademy.student.initializer;

import com.nhnacademy.student.factory.ControllerFactory;
import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@HandlesTypes(
        value = {
                com.nhnacademy.student.command.Command.class
        }
)
public class WebAppInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        ControllerFactory controllerFactory = new ControllerFactory();
        controllerFactory.init(set);
        servletContext.setAttribute("controllerFactory", controllerFactory);
    }
}
