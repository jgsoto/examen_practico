package library.interfaces.controller;

import library.application.usecase.BorrowBookUseCase;
import library.application.usecase.GetAvailableBooksUseCase;
import library.application.usecase.GetLoansUseCase;
import library.application.usecase.GetMembersUseCase;
import library.application.usecase.ReturnBookUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/loans")
public class LoanController {

    private final BorrowBookUseCase borrowBookUseCase;
    private final ReturnBookUseCase returnBookUseCase;

    private final GetLoansUseCase getLoansUseCase;
    private final GetAvailableBooksUseCase getAvailableBooksUseCase;
    private final GetMembersUseCase getMembersUseCase;

    public LoanController(
            BorrowBookUseCase borrowBookUseCase,
            ReturnBookUseCase returnBookUseCase,
            GetLoansUseCase getLoansUseCase,
            GetAvailableBooksUseCase getAvailableBooksUseCase,
            GetMembersUseCase getMembersUseCase
    ) {
        this.borrowBookUseCase = borrowBookUseCase;
        this.returnBookUseCase = returnBookUseCase;
        this.getLoansUseCase = getLoansUseCase;
        this.getAvailableBooksUseCase = getAvailableBooksUseCase;
        this.getMembersUseCase = getMembersUseCase;
    }

    @GetMapping
    public String loans(Model model) {

        model.addAttribute(
                "loans",
                getLoansUseCase.execute()
        );

        model.addAttribute(
                "availableBooks",
                getAvailableBooksUseCase.execute()
        );

        model.addAttribute(
                "members",
                getMembersUseCase.execute()
        );

        return "loans";
    }

    @PostMapping
    public String borrowBook(
            @RequestParam Long bookId,
            @RequestParam Long memberId
    ) {

        borrowBookUseCase.execute(
                bookId,
                memberId
        );

        return "redirect:/loans";
    }

    @PostMapping("/{id}/return")
    public String returnBook(
            @PathVariable Long id
    ) {

        returnBookUseCase.execute(id);

        return "redirect:/loans";
    }
}