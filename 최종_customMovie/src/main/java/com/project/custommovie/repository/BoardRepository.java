package com.project.custommovie.repository;


import com.project.custommovie.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//Repository는 기본적으로 entity클래스만 받아준다!
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    //update board_table set board_hits=board_hits+1 where id=?
    //jpa에서 제공하는 어노테이션
    @Modifying      //update나 delete같은 쿼리를 사용할 때 필요함
    @Query(value = "update BoardEntity b set b.boardHits=b.boardHits+1 where b.id=:id")     
    //테이블 기준으로 하기도 하는데 여기서는 Entity를 기준으로(b처럼 약어를 사용해야함) 사용해보자
    //:id는 Param의 id와 매칭을 해서 생각하면 됌
    void updateHits(@Param("id") Long id);
}
