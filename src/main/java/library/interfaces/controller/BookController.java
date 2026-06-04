package library.interfaces.controller;

import library.application.usecase.GetBooksUseCase;
import library.application.usecase.RegisterBookUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final RegisterBookUseCase registerBookUseCase;
    private final GetBooksUseCase getBooksUseCase;

    public BookController(
            RegisterBookUseCase registerBookUseCase,
            GetBooksUseCase getBooksUseCase
    ) {
        this.registerBookUseCase = registerBookUseCase;
        this.getBooksUseCase = getBooksUseCase;
    }

    @GetMapping
    public String books(Model model) {

        model.addAttribute(
                "books",
                getBooksUseCase.execute()
        );

        return "books";
    }

    @PostMapping
    public String create(
            @RequestParam String title
    ) {

        registerBookUseCase.execute(title);

        return "redirect:/books";
    }
}