package com.moviecustom.board.repository;

import com.moviecustom.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//Repository는 기본적으로 entity클래스만 받아준다!
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
