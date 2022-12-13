package com.moviecustom.board.controller;

import com.moviecustom.board.dto.BoardDTO;
import com.moviecustom.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
        model.addAttribute("boardList", boardDTOList);           //가져온 데이터를 "boardList" 이름으로 모델 객체에 담아야함
        return "list";
    }

    //상세조회를 위해 id값을 받아와야함
    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model,
                           @PageableDefault(page=1) Pageable pageable){      //경로상에 있는 값을 가져올 때는 PathVariable 애노테이션 사용, 데이터를 담아야하므로 model객체 필요
        /*
            해당 게시글의 조회수를 하나 올리고
            게시글 데이터를 가져와서 detail.html에 출력
        */
        boardService.updateHits(id);        //서비스클래스에 updateHitst메서드 호출, 1.조회수처리하고
        BoardDTO boardDTO = boardService.findById(id);      //2.해당게시글가져와서 boardDTO로 받아오고
        model.addAttribute("board", boardDTO);            //3. board 파라미터에 담아서, 즉, 모델에 담아서
        model.addAttribute("page",pageable.getPageNumber());
        return "detail";        //detail.html로 넘어간다.               //4. html로 넘어감
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model){        //데이터를 반환해야하므로 model이 필요함
        //1. 해당게시글의 정보만 가져오면 되기 때문에(updatehtml에 그 정보를 보여줘야함), findById활용
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("boardUpdate",boardDTO);
        return "update";
    }

    //수정이 완료되고 나서 목록을 띄어줘도 되고, 수정이 반영된 상세페이지를 보여줘도 됨
    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model){
        BoardDTO board = boardService.update(boardDTO);      //update메서드 호출
        model.addAttribute("board",board);
        return "detail";
//        return "redirect:/board/" + board.getId();           이렇게 하면 조회수가 영향을 받을 수 있기 때문에 쓰지 않을 것
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        boardService.delete(id);
        return "redirect:/board/";
    }

    //요청이 갈때 /board/paging?page=1이런식으로 페이지번호가 바뀌게 될것임
    @GetMapping("/paging")
    public String paging(@PageableDefault(page = 1)Pageable pageable, Model model){     //만약에 page값이 없다면 1로 지정해서 사용하겠다는 옵션
//        pageable.getPageNumber();       //몇 페이지가 요청됐는지 값을 사용할 수 있음
        Page<BoardDTO> boardList = boardService.paging(pageable);

        // page 갯수 20개
        // 현재 사용자가 3페이지를 보고 있다.
        // 1 2 3
        // 현재 사용자가 7페이지를 보고 있다.
        // 7 8 9

        int blockLimit = 3;     //페이지 번호 갯수
        int startPage = (((int)(Math.ceil((double)pageable.getPageNumber()/blockLimit))) - 1) * blockLimit + 1;         // 1 4 7 10 ~
        int endPage = ((startPage + blockLimit -1) < boardList.getTotalPages()) ? startPage + blockLimit -1 : boardList.getTotalPages();        //삼항연산자
        // 총 페이지 갯수 8개 

        model.addAttribute("boardList", boardList);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "paging";            //paging.html로 넘어감

    }
}
