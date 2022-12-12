package com.moviecustom.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")            //기본주소 요청이 오면
    public String index(){         //메서드 호출
        return "index";            //index.html를 찾아감
    }

}
