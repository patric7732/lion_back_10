package org.example.boardmvc.service;

import org.example.boardmvc.domain.Board;
import org.example.boardmvc.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<Board> findPaginated(int page, int pageSize) {
        return boardRepository.findPaginatedBoards(page, pageSize);
    }

    public int getTotalBoardCount() {
        return boardRepository.getBoardCount();
    }

    public Optional<Board> findById(Long id) {
        return boardRepository.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    public boolean verifyPassword(Long id, String password) {
        Optional<Board> board = findById(id);
        return board.map(b -> b.getPassword().equals(password)).orElse(false);
    }

    @Transactional
    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }


    @Transactional
    public Board update(Board board) {
        return boardRepository.save(board);
    }
}
