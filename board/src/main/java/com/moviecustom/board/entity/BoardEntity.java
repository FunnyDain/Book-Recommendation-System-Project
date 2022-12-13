package com.moviecustom.board.entity;

//DB의 테이블 역할을 하는 클래스
//spring data jap에서는 필수적으로 써야하는 클래스 형태

import com.moviecustom.board.dto.BoardDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
//name은 필수적이진 않지만 여기에 정의한 name대로 우리가 따로 데이터베이스에 table을 생성하지 않아도 spring data jap가  테이블이 생김
@Table(name = "board_table")
public class BoardEntity extends BaseEntity{
    @Id     //PK column지정. 필수!
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //mysql기준 auto_increment
    private Long id;

    //@Column의 default : 크기 255, null가능
    @Column(length = 20, nullable = false)      //Column크기값 정함(크기 20), not null
    private String boardWriter;

    @Column     //크기 255, null 가능
    private String boardPass;

    @Column
    private String boardTitle;

    @Column(length = 500)
    private String boardContents;

    @Column
    private int boardHits;

    //input으로 dto에 담긴 값들을 entity객체로 옮겨담는 작업
    public static BoardEntity toSaveEntity(BoardDTO boardDTO){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardPass(boardDTO.getBoardPass());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardHits(0);        //기본값0으로 세팅
        return boardEntity;     //다 옮겨담으로 객체 return, 그럼 service에서
    }

    public static BoardEntity toUpdateEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(boardDTO.getId());
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardPass(boardDTO.getBoardPass());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardHits(boardDTO.getBoardHits());
        return boardEntity;
    }
}
