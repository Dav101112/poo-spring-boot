package com.ups.poo.service;

import com.ups.poo.domain.Author;
import com.ups.poo.dto.AuthorDTO;
import com.ups.poo.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorDTO> findAll(){
        List<AuthorDTO> authorList = new ArrayList<>();
        Iterable<Author> authorIterable = authorRepository.findAll();
        for(Author author: authorIterable){
            AuthorDTO authorDTO =new AuthorDTO(author.getName(), author.getLastname());
            authorList.add(authorDTO);
        }
        return authorList;
    }
}
