package library.controller;

import library.service.BookService;
import library.service.LoanService;
import library.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;
    private final BookService bookService;
    private final MemberService memberService;

    public LoanController(
            LoanService loanService,
            BookService bookService,
            MemberService memberService
    ) {
        this.loanService = loanService;
        this.bookService = bookService;
        this.memberService = memberService;
    }

    @GetMapping
    public String loans(Model model) {

        model.addAttribute(
                "loans",
                loanService.findAll()
        );

        model.addAttribute(
                "availableBooks",
                bookService.findAvailableBooks()
        );

        model.addAttribute(
                "members",
                memberService.findAll()
        );

        return "loans";
    }

    @PostMapping
    public String borrowBook(
            Long bookId,
            Long memberId
    ) {

        loanService.borrowBook(
                bookId,
                memberId
        );

        return "redirect:/loans";
    }

    @PostMapping("/{id}/return")
    public String returnBook(
            @PathVariable Long id
    ) {

        loanService.returnBook(id);

        return "redirect:/loans";
    }
}