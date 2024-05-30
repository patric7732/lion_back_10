package org.example.springdatajpa2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    //쿼리메서드로 추가하고,  테스트 코드를 만들어 주세요.
    //이름으로 조회
    List<Customer> findByName(String name);


    //이메일로 조회
    List<Customer> findByEmail(String email);

    //이메일에 특정 문자열을 포함 하고 있는 고객 조회
    List<Customer> findByEmailContaining(String email);

    //각 고객과 고객의 주문수를 알고싶다.
    @Query("SELECT c , count(o) FROM Customer c LEFT JOIN c.orders o GROUP BY c")
    List<Object[]> findCustomerOrderCount();


}
