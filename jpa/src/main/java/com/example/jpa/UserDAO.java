package com.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDAO {
//    private EntityManagerFactory emf;

//    public UserDAO(){
//        emf = Persistence.createEntityManagerFactory("UserPU");
//    }
//
//
//    public void close(){
//        if(emf != null)
//            emf.close();
//    }

    public void createUser(User user){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        try{
            entityManager.getTransaction().begin();

            entityManager.persist(user);

            entityManager.getTransaction().commit();
        }finally {
            entityManager.close();
        }
    }

}
