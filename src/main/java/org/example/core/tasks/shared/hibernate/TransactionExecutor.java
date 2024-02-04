package org.example.core.tasks.shared.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.function.Function;

public class TransactionExecutor {
    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public <R>R execute(Function<Session, R> operation) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            var result = operation.apply(session);
            transaction.commit();
            return result;
        }
    }
}

