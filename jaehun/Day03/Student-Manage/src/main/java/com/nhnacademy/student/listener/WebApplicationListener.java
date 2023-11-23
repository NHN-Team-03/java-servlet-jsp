package com.nhnacademy.student.listener;

import com.nhnacademy.student.repository.JsonStudentRepository;
import com.nhnacademy.student.student.Gender;
import com.nhnacademy.student.student.Student;
import com.nhnacademy.student.repository.StudentRepository;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Random random = new Random();
        ServletContext context = sce.getServletContext();
        StudentRepository studentRepository = new JsonStudentRepository();

        for(int i = 1; i <= 10; i++) {
            String id = "student" + i;
            String name = "아카데미" + i;
            Gender gender = Gender.values()[random.nextInt(2)];
            int age = random.nextInt(11) + 20;

            Student student = new Student(id, name, gender, age);


            studentRepository.save(student);
        }

        context.setAttribute("studentRepository", studentRepository);
    }
}
