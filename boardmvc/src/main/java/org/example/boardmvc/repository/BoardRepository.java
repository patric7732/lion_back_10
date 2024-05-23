package org.example.boardmvc.repository;

import org.example.boardmvc.domain.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long>, CustomBoardRepository{

}