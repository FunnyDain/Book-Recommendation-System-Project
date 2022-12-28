package com.project.custommovie.service;



import com.project.custommovie.dto.BoardDTO;
import com.project.custommovie.entity.BoardEntity;
import com.project.custommovie.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    //JPA에서 제공하는 메서드가 아니라 별도 추가된 메서드를 사용할 경우 이 어노테이션을 붙여줘야함
    @Transactional
    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }


    public BoardDTO findById(Long id) {
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
        if (optionalBoardEntity.isPresent()) {
            BoardEntity boardEntity = optionalBoardEntity.get();
            BoardDTO boardDTO = BoardDTO.toBoardDTO(boardEntity);
            return boardDTO;
        } else {
            return null;
        }
    }

    //jpa에서 update를 해주는 메서드는 없다.
    //save메서드를 가지고 id값이 유무에 따라 save, insert를 가능하게 함
    //id값이 db에 있다면 update를 하라것으로 대응
    public BoardDTO update(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toUpdateEntity(boardDTO);       //entity로 변환
        boardRepository.save(boardEntity);
        return findById(boardDTO.getId());     //상세조회값을 넘겨줘야하므로, findById에서 작업을 다 해줌
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

    public Page<BoardDTO> paging(Pageable pageable) {
        int page = pageable.getPageNumber() -1;     //몇 페이지를 보고 싶은지, page 위치에 있는 값은 0부터 시작하기 때문에 사용자요청에서 하나 빼줌
        int pageLimit = 3;      //한 페이지에 보여줄 글 갯수
        //한 페이지당 3개씩 글을 보여주고 정렬 기준은 id기준으로 내림차순 정렬
        Page<BoardEntity> boardEntities =       //Page객체로 리턴
                boardRepository.findAll(PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC,"id")));
        //findeAll로 가져오는데 옵션
        //Sort.by : 정렬기준해서 해당 페이지 값을 가지고 오는 것,
        //DESC: 내림차순, "id"는 기준, entity에 작성한 이름 기준(db컬럼 기준 x)


        System.out.println("boardEntities.getContent() = " + boardEntities.getContent());       //요청 페이지에 해당하는 글
        System.out.println("boardEntities.getTotalElements() = " + boardEntities.getTotalElements());       //전체 글갯수
        System.out.println("boardEntities.getNumber() = " + boardEntities.getNumber());       //DB로 요청한 페이지 번호, ex) 실제 사용자가 1를 요청했다면 0으로 요청이 갔을것!
        System.out.println("boardEntities.getTotalPages() = " + boardEntities.getTotalPages());       //전체 페이지 갯수
        System.out.println("boardEntities.getSize() = " + boardEntities.getSize());       //한 페이지에 보여지는 글 갯수
        System.out.println("boardEntities.hasPrevious() = " + boardEntities.hasPrevious());       //이전 페이지 존재 여부(true/false), 현재 요청한 페이지보다 앞선 페이지가 있는가
        System.out.println("boardEntities.isFirst() = " + boardEntities.isFirst());       //첫 페이지 여부
        System.out.println("boardEntities.isLast() = " + boardEntities.isLast());       //마지막 페이지 여부

        //여기서 board는 entity객체, map을 통해 board변수를 하나씩 꺼내서 DTO객체로 옮겨 담는 작업
        //Page타입 그대로 있으모 위에 메서드들을 그대로 사용가능하다.
        //목록 : id, writer, title, hits, createdTime => 이 정보를 담을 수 있는 dto 생성자를 추가해야함
        Page<BoardDTO> boardDTOS = boardEntities.map(board -> new BoardDTO(board.getId(), board.getBoardWriter(), board.getBoardTitle(), board.getBoardHits(), board.getCreatedTime()));
        return boardDTOS;       //Controller쪽으로 리턴
    }
}
