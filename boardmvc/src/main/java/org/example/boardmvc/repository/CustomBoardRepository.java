package org.example.boardmvc.repository;

import org.example.boardmvc.domain.Board;

import java.util.List;

public interface CustomBoardRepository {
    List<Board> findPaginatedBoards(int page, int size);
    int getBoardCount();
}