package com.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserRun {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserPU");
        EntityManager entityManager = emf.createEntityManager();
    }
}
