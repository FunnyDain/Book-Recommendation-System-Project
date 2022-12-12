package com.moviecustom.board.controller;

import com.moviecustom.board.dto.BoardDTO;
import com.moviecustom.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor            //**Service클래스를 호출하고 가야되기 때문에
@RequestMapping("/board")
public class BoardController {
    
    private final BoardService boardService;        //**생성자 주입방식으로 의존성을 주입받게 됌
    
    @GetMapping("/save")
    public String saveForm(){
        return "save";
    }

    //2. input의 여러 request를 한번에 dto라는 클래스 객체에 담아서 controller에 넘어오는 작업이 필요함
    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO){      //1. 입력한 값을 controller로 가져오기 위해서 @RequestParam으로 받아도 되지만,
        System.out.println("boardDTO = " + boardDTO);
        //**3. 저장하러 service, repository
        boardService.save(boardDTO);

        return "index";     //save하고 나서 index로 보냄
    }

    //data, 즉, 전체목록을 db로부터 가져와야함 => model객체를 사용
    @GetMapping("/")
    public String findAll(Model model){
        // DB에서 전체 게시글 데이터를 가져와서 list.html에 보여준다.
        List<BoardDTO> boardDTOList = boardService.findAll();       //여러개를 가져와야하므로 List형태
        model.addAttribute("boardList", boardDTOList);           //가져온 데이터를 모델 객체에 담아야함
        return "List";
    }

}
