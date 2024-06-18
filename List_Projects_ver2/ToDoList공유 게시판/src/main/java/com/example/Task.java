package com.example;

import java.io.Serializable;

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String item;
    private String startDateTime;
    private String dueDateTime;
    private boolean completed;

    public Task(String id, String item, String startDateTime, String dueDateTime) {
        this.id = id;
        this.item = item;
        this.startDateTime = startDateTime;
        this.dueDateTime = dueDateTime;
        this.completed = false;
    }

    public String getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public String getDueDateTime() {
        return dueDateTime;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
