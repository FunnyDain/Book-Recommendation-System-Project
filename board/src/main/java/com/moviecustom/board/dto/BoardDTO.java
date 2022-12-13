package com.moviecustom.board.dto;

import com.moviecustom.board.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter     //request에서 input의 name과 일치한 field의 값을 설정함
@ToString
@NoArgsConstructor      //기본생성자
@AllArgsConstructor     //모든 필드를 매개변수로 하는 생성자
//DTO(Data Transfer Object), VO, Bean,(비슷)           Entity(는 다른 목적)
public class BoardDTO {
    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits;      //조회수
    private LocalDateTime boardCreatedTime;
    private LocalDateTime boardUpdatedTime;


    public BoardDTO(Long id, String boardWriter, String boardTitle, int boardHits, LocalDateTime boardCreatedTime) {
        this.id = id;
        this.boardWriter = boardWriter;
        this.boardTitle = boardTitle;
        this.boardHits = boardHits;
        this.boardCreatedTime = boardCreatedTime;
    }

    //boardDTO에 entity를 하나씩 하나씩 옮겨 담아주면됌
    public static BoardDTO toBoardDTO(BoardEntity boardEntity){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(boardEntity.getId());
        boardDTO.setBoardWriter(boardEntity.getBoardWriter());
        boardDTO.setBoardPass(boardEntity.getBoardPass());
        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDTO.setBoardContents(boardEntity.getBoardContents());
        boardDTO.setBoardHits(boardEntity.getBoardHits());
        boardDTO.setBoardCreatedTime(boardEntity.getCreatedTime());
        boardDTO.setBoardUpdatedTime(boardEntity.getUpdateTime());
        return boardDTO;
    }

}
