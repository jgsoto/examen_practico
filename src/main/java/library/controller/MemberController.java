package library.controller;

import library.model.Member;
import library.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping
    public String members(Model model) {

        model.addAttribute(
                "members",
                service.findAll()
        );

        return "members";
    }

    @PostMapping
    public String create(Member member) {

        service.create(member);

        return "redirect:/members";
    }
}