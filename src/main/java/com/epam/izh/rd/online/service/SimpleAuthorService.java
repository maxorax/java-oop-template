package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.repository.AuthorRepository;
import com.epam.izh.rd.online.repository.SimpleAuthorRepository;

public class SimpleAuthorService implements AuthorService  {
    private AuthorRepository authorRepository;

    public SimpleAuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public boolean save(Author author){
                return authorRepository.save(author);
    }

    public Author findByFullName(String name, String lastname){
        return authorRepository.findByFullName(name,lastname);
    }

    public boolean remove(Author author){
        return authorRepository.remove(author);
    }

    @Override
    public int count(){return  authorRepository.count();};

}
