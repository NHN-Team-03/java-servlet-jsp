package com.nhnacademy.student.listener;

import com.nhnacademy.student.Gender;
import com.nhnacademy.student.Student;
import com.nhnacademy.student.repository.MapStudentRepository;
import com.nhnacademy.student.repository.StudentRepository;
import java.time.LocalDateTime;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.random.RandomDataGenerator;


@Slf4j
@WebListener
public class WebApplicationListener implements ServletContextListener {

    /**
     * Application 구동과 동시에 student1 ~ 10까지 생성
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        StudentRepository studentRepository = new MapStudentRepository();

        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();

        for (int i = 1; i <= 10; i++) {
            Student student = new Student();

            // id name gender age createdAt
            student.setId("student" + i);
            student.setName("아카데미" + i);
            student.setGender(i % 2 == 0 ? Gender.M : Gender.F);
            student.setAge(randomDataGenerator.nextInt(20, 30));
            student.setCreatedAt(LocalDateTime.now());
            studentRepository.save(student);
        }

        log.info("contextInit!");
        context.setAttribute("studentRepository", studentRepository);
    }
}
