package com.ups.poo.bootstrap;

import com.ups.poo.domain.Author;
import com.ups.poo.domain.Book;
import com.ups.poo.repository.AuthorRepository;
import com.ups.poo.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book();
        book1.setTitle("Los 3 mosqueteros");
        book1.setEditorial("Pearson");
        bookRepository.save(book1);


        Book book2 = new Book();
        book2.setTitle("El Conde");
        book2.setEditorial("Pearson");
        bookRepository.save(book2);


        Author author1 = new Author("David", "Vasquez");
        author1.getBooks().add(book1);
        author1.getBooks().add(book2);
        book1.setAuthor(author1);
        book2.setAuthor(author1);
        authorRepository.save(author1);
        bookRepository.save(book1);
        bookRepository.save(book2);



        Book book3 = new Book();
        book3.setTitle("Harry Potter 1");
        book3.setEditorial("Bloomsbury");
        bookRepository.save(book3);

        Book book4 = new Book();
        book4.setTitle("Harry Potter 2");
        book4.setEditorial("Bloomsbury");
        bookRepository.save(book4);

        Author author2 = new Author("J.K", "Rowling");
        author2.getBooks().add(book3);
        author2.getBooks().add(book4);
        book3.setAuthor(author2);
        book4.setAuthor(author2);
        authorRepository.save(author2);
        bookRepository.save(book3);
        bookRepository.save(book4);


        System.out.println("-------------Started BootStrapData-----------");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors:" + authorRepository.count());

    }
}
