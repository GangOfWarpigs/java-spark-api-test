package org.example;

import org.example.core.tasks.infraestructure.hibernate.HibernateTaskRepository;
import org.example.core.tasks.useCases.TodoCreator;
import org.example.core.tasks.useCases.TodoFinder;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        var repository = new HibernateTaskRepository();
        var creator = new TodoCreator(repository);
        var command = creator.create("hello world");
        command.execute();

        var finder  = new TodoFinder(repository);
        System.out.println(finder.find());

    }
}