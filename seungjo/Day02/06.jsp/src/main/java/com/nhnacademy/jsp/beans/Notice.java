package com.nhnacademy.jsp.beans;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable {

    private String subject;
    private String name;
    private long counter;
    private Date createdAt;

    public Notice(){}

    public Notice(String subject, String name, long counter) {
        this.subject = subject;
        this.name = name;
        this.counter = counter;
        this.createdAt = new Date();
    }

    public String getSubject() {
        return subject;
    }

    public String getName() {
        return name;
    }

    public long getCounter() {
        return counter;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
