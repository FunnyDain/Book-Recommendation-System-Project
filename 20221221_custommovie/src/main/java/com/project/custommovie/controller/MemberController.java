
package com.project.custommovie.controller;


import com.project.custommovie.dto.MemberDTO;
import com.project.custommovie.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
//@ComponentScan(basePackages = "com.project.custommovie")
@RequiredArgsConstructor
public class MemberController {
    //생성자 주입
    private final MemberService memberService;


    @GetMapping("/ranking/ranking")
        public String rankhome() {
            return "/ranking/ranking";
        }

    //회원가입 페이지 출력 요청
    @GetMapping("/member/save")
    public String home() {
        return "/member/register";

    }

    @PostMapping("/member/save")
    public String save(@ModelAttribute @Valid MemberDTO memberDTO) {

        memberService.save(memberDTO);
        return "/member/login";
    }

//welcome
    @GetMapping("/")
    public String loginForm() {
        return "/member/login";
    }

    @PostMapping("/member/login")
    public String logincheck(@ModelAttribute MemberDTO memberDTO,HttpSession session) {
        MemberDTO loginResult = memberService.login(memberDTO);

        if(loginResult != null) {
            //로그인 성공

            session.setAttribute("loginMbti", loginResult.getMembermbti().substring(0,4));
            session.setAttribute("loginMbtiDescription", loginResult.getMembermbti());
            return "/home";

        }else {
            //로그인 실패
            return "/member/login.html";
        }
    }

    // 로그아웃
    @GetMapping("/member/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "/member/login.html";
    }






}





