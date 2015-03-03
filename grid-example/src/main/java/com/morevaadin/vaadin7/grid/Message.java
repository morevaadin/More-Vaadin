package com.morevaadin.vaadin7.grid;

import java.util.Date;

public class Message {

    private Long id;
    private String author;
    private String text;
    private Date timeStamp;

    public Message(String author, String text, Date timeStamp) {
        this.id = System.currentTimeMillis();
        this.author = author;
        this.text = text;
        this.timeStamp = timeStamp;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }
}
