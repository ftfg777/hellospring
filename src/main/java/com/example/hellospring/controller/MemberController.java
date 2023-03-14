package com.example.hellospring.controller;

import com.example.hellospring.domain.Member;
import com.example.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    /* @Autowired 필드 주입 = 좋은 방법은 아님 */
    private final MemberService memberService;

    /*
    @Autowired setter 주입/public으로 노출됨
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }*/

    @Autowired // = 생성자 주입 () 권장
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /* 조회 : get */
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    /* 데이터 등록 : post url이 같아도 메소드에 따라 선택 */
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
