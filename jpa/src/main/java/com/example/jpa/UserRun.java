package com.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserRun {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserPU");
        EntityManager entityManager = emf.createEntityManager();

        //엔티티 생성  --  아직은 영속성 컨텍스트가 관리하지 않는 상태!!(비영속)
        User user = new User();
//        user.setId(1L);
        user.setName("kim");
        user.setEmail("kim@gmail.com");

        // 여기까지도 영속성 컨텍스트가 관리하지는 않음.
        entityManager.getTransaction().begin();

        //영속성 컨텍스트에게 관리를 맡김.  (영속상태)
        entityManager.persist(user);
        System.out.println("userId :::::::::::::::::"+user.getId());

        //이때 DB에 저장함.
        entityManager.getTransaction().commit();


    }
}
