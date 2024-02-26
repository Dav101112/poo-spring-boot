package com.ups.poo.service;

import com.ups.poo.domain.Author;
import com.ups.poo.domain.Book;
import com.ups.poo.dto.AuthorDTO;
import com.ups.poo.dto.BookDTO;
import com.ups.poo.repository.AuthorRepository;
import com.ups.poo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<BookDTO> findAll() {
        List<BookDTO> bookList = new ArrayList<>();
        Iterable<Book> books= bookRepository.findAll();
        for (Book bookI : books) {
            BookDTO book = new BookDTO();
            book.setTitle(bookI.getTitle());
            book.setEditorial(bookI.getEditorial());
            AuthorDTO authorDTO = new AuthorDTO();
            authorDTO.setName(bookI.getAuthor().getName());
            authorDTO.setLastname(bookI.getAuthor().getLastname());
            book.setAuthorDTO(authorDTO);
            bookList.add(book);
        }
        return bookList;
    }
}
