package org.example.jpaFactory.abstracts;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public interface JPAFactory {
    EntityManager getEntityManager();
    EntityTransaction getTransaction();
}
