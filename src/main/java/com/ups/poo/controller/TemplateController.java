package com.ups.poo.controller;

import com.ups.poo.service.AuthorService;
import com.ups.poo.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {
    private final AuthorService authorService;
    private final BookService bookService;

    public TemplateController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors", authorService.findAll());
        return "authors/list";
    }
    @GetMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookService.findAll());
        return "books/list";
    }
}
