package com.moviecustom.board.service;


import com.moviecustom.board.dto.BoardDTO;
import com.moviecustom.board.entity.BoardEntity;
import com.moviecustom.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Serive에서는
//DTO -> Entity     Controller로부터 호출을 받을 때는 DTO로 넘겨받고
//Entity -> DTO     Repository로 넘겨줄 때는 Entity로 넘겨준다.
//DB에 데이터를 조회할때는, Repository로부터 Entity로 받아온다. 그것을 Controller로 다시 return줄 때는 또 DTO로 바꿔서 넘겨줌


@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;      //생성자를 주입방식

    //** DTO객체를 Entity객체로 옮겨 담는다.
    public void save(BoardDTO boardDTO) {
        //Entity클래스 객체를 넘겨줘됨
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        boardRepository.save(boardEntity);      //insert를 db에 할 수 있게, save의 매개변수, return으로 entity타입으로 지정되어 있음
    }

    //** Entity객체를 DTO객체로 옮겨 담는다.
    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();      
        //repository로부터 뭔가를 가져올때는 거의 대부분 entity로 옴(list형태)
        
        //entity로 넘어온 이 객체를 dto객체로 담아 controller에 리턴해줘야함
        List<BoardDTO> boardDTOList = new ArrayList<>();        //list객체를 하나 선언

        for (BoardEntity boardEntity : boardEntityList){        //Entity에서 하나씩 꺼내서
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));  //dto로 변환을 하고 변환된 객체를 List에 담는
        }
        return boardDTOList;
    }
}
