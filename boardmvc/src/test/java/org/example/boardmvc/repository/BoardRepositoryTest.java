package org.example.boardmvc.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@JdbcTest
@Import(CustomBoardRepositoryImpl.class)
@ComponentScan(basePackages = "org.example.springmvc.repository")
//@ContextConfiguration(classes = {BoardRepositoryTest.TestConfig.class})
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void testGetBoardCount() {
        int count = boardRepository.getBoardCount();
        assertThat(count).isEqualTo(2);
    }

}
