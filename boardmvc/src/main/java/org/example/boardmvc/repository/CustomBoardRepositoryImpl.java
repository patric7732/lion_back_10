package org.example.boardmvc.repository;

import org.example.boardmvc.domain.Board;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CustomBoardRepositoryImpl implements CustomBoardRepository{

    private final JdbcTemplate jdbcTemplate;

    public CustomBoardRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Board> findPaginatedBoards(int page, int size) {
        int offset = (page - 1) * size; // 페이지 값 계산
        String sql = "SELECT id, name, title, password, content, created_at, updated_at FROM board ORDER BY id DESC LIMIT ?, ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Board.class), offset, size);
    }

    @Override
    public int getBoardCount() {
        String sql = "SELECT count(*) FROM board";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}