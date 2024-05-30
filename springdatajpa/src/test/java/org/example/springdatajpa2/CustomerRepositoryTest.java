package org.example.springdatajpa2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CustomerRepositoryTest {
    private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryTest.class);
    @Autowired
    CustomerRepository repository;

    @Test
    void save(){
        Customer customer = new Customer("zi", "zi@naver.com");
        repository.save(customer);

        Assertions.assertThat(repository.findById(11L).get().getName()).isEqualTo("zi");
    }

    @Test
    void delete(){

    }

}