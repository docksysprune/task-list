package org.oceballos.model;

import java.util.Date;

public class TaskList {
    private String name;
    private Date creationDate;

    {
        creationDate = new Date();
    }

    public TaskList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
