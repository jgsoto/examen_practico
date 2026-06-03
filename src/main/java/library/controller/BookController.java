package library.controller;

import library.model.Book;
import library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public String books(Model model) {

        model.addAttribute("books", service.findAll());

        return "books";
    }

    @PostMapping
    public String create(Book book) {

        service.create(book);

        return "redirect:/books";
    }
}