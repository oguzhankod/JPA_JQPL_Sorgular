package org.example.jpaFactory.concretes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.jpaFactory.abstracts.JPAFactory;

public class JPAFactoryImpl implements JPAFactory {

    private EntityManager entityManager = null;

    @Override
    public EntityManager getEntityManager() {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        entityManager = managerFactory.createEntityManager();
        return entityManager;
    }

    @Override
    public EntityTransaction getTransaction() {

        EntityTransaction transaction = entityManager.getTransaction();
        return transaction;
    }
}
