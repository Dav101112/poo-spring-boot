package com.ups.poo.controller;

import com.ups.poo.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {
    private final AuthorService authorService;

    public TemplateController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors", authorService.findAll());
        return "authors/list";
    }
}
