package com.nhnacademy.jsp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Notice implements Serializable {
    private String subject;
    private String name;
    private Long counter;
    private LocalDateTime createdAt;

    public Notice(String subject, String name, Long counter) {
        this.subject = subject;
        this.name = name;
        this.counter = counter;
        this.createdAt = LocalDateTime.now();
    }
}
