package org.example.springdatajpa2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    @DisplayName("고객명으로 조회")
    void findByName(){

//         List<Customer> customers = repository.findByName("홍길동");
//
//        for (Customer customer : customers) {
//            log.info(customer.getName()+" :: " + customer.getEmail());
//        }

        //Given
        Customer customer1 = new Customer("user1","user1@test.com");
        Customer customer2 = new Customer("user2","user1@test.com");
        Customer customer3 = new Customer("user3","user3@test.com");
        repository.save(customer1);
        repository.save(customer2);
        repository.save(customer3);

        //When
        List<Customer> user1 = repository.findByName("user1");

        //Then



    }

    @Test
    void findByEmailContaining(){
//        List<Customer> exams = repository.findByEmailContaining("exam");
//        exams.forEach(customer -> log.info(customer.getName()+" :: " + customer.getEmail()));

        //Given
        Customer customer1 = new Customer("user1","user1@test.com");
        Customer customer2 = new Customer("user2","user1@test.com");
        Customer customer3 = new Customer("user3","user3@test.com");
        repository.save(customer1);
        repository.save(customer2);
        repository.save(customer3);

        //When
        List<Customer> customers = repository.findByEmailContaining("test");

        //Then
        Assertions.assertThat(customers).hasSize(3);
    }

    @Test
    void findCustomerOrderCount(){
        List<Object[]> customerOrderCount = repository.findCustomerOrderCount();
        customerOrderCount.forEach(result ->{
            Customer customer = (Customer) result[0];
            Long count = (Long)result[1];
            log.info("고객이름 : {} , 주문 수 : {}",customer.getName(),count);
        });
    }

}