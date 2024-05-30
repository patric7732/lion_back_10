package org.example.springdatajpa;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@SpringBootTest
@Transactional
@Rollback(value = false)
class UserRepoTest {
    @Autowired
    private UserRepository repository;

    @Test
    void updateUserEmail() {
        repository.updateUserEmail(3L, "new_kang@example.com");
        Optional<User> user = repository.findById(3L);
        assertThat(user.get().getEmail()).isEqualTo("new_kang@example.com");
//        Assertions.assertEquals(user.get().getEmail().isEqualTo("new_kang@example.com"));
        Assertions.assertTrue(user.isPresent(), "User should be present");
        Assertions.assertEquals("new_kang@example.com", user.get().getEmail(), "Email should be new_kang@example.com");
    }
}