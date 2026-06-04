package library.interfaces.controller;

import library.application.usecase.GetMembersUseCase;
import library.application.usecase.RegisterMemberUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
public class MemberController {

    private final RegisterMemberUseCase registerMemberUseCase;
    private final GetMembersUseCase getMembersUseCase;

    public MemberController(
            RegisterMemberUseCase registerMemberUseCase,
            GetMembersUseCase getMembersUseCase
    ) {
        this.registerMemberUseCase = registerMemberUseCase;
        this.getMembersUseCase = getMembersUseCase;
    }

    @GetMapping
    public String members(Model model) {

        model.addAttribute(
                "members",
                getMembersUseCase.execute()
        );

        return "members";
    }

    @PostMapping
    public String create(
            @RequestParam String name
    ) {

        registerMemberUseCase.execute(name);

        return "redirect:/members";
    }
}