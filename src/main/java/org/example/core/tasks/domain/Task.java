package org.example.core.tasks.domain;

public class Task {
    private Boolean isDone;

    public int getId() {
        return id;
    }

    private final int id;
    private final String text;

    private Task(int id, Boolean isDone, String text) {
        this.isDone = isDone;
        this.id = id;
        this.text = text;
    }

    public static Task done(int id, String name){
        return new Task(id, true , name);
    }
    public static Task todo(int id, String name){
        return new Task(id, false,  name);
    }

    public Task check(){
        this.isDone = true;
        return this;
    }

    public Boolean getDone() {
        return isDone;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
