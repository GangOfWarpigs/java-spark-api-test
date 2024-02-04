package org.example.core.tasks.infraestructure.hibernate;

import org.example.core.tasks.domain.Task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks") // Specifies the table name explicitly
public class TaskDB{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // It's a good practice to keep entity fields private

    public boolean isChecked() {
        return isChecked;
    }

    private String text;
    private boolean isChecked;

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    // Constructors
    public TaskDB() {}

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean check) {
        this.isChecked = check;
    }

    public static TaskDB from(Task task){
        var t = new TaskDB();
        t.setText(task.getText());
        t.setChecked(task.getDone());
        return t;
    }
}
