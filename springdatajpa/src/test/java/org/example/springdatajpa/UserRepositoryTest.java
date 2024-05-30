package org.example.springdatajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

//import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
@SpringBootTest
@Transactional
@Rollback(value = false)
class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    void save(){
        User user = new User("kim","kimsp@exam.com");
        repository.save(user);

        System.out.println(user.getId());
    }

    @Test
    void findByName(){
        List<User> users = repository.findByName("kang");
        assertThat(users.size()).isEqualTo(4);


        List<User> users2 = repository.findByName("kim");
        assertThat(users2.size()).isEqualTo(1);

    }

    @Test
    void findByEmail(){
        User byEmail = repository.findByEmail("kang@example.com");
        System.out.println(byEmail.getName());
    }

    @Test
    void findByNameAndEmail(){
        List<User> users = repository.findByNameAndEmail("kim", "kim@exam.com");
        users.forEach(user -> System.out.println(user.getName() + "::" + user.getEmail()));
    }

    @Test
    void findByNameOrEmail(){
        List<User> users = repository.findByNameOrEmail("kim", "kim@exam.com");
        users.forEach(user -> System.out.println(user.getName() + "::" + user.getEmail()));
    }

    @Test
    void updateUserEmail(){
       int count =  repository.updateUserEmail(3L, "new_kang@exam.com");

        Optional<User> user = repository.findById(3L);

        assertThat(user.get().getEmail()).isEqualTo("new_kang@exam.com");

        Assertions.assertEquals(user.get().getEmail(),"new_kang@exam.com");
        Assertions.assertEquals(count, 1);
    }

    @Test
    void deleteByEmail(){
      int count = repository.deleteByEmail("kim@exam.com");
        System.out.println(count);
//      assertThat(count).isEqualTo(1);
    }
}