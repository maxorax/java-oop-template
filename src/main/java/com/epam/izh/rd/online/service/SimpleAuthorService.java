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
                return new SimpleAuthorRepository().save(author);
    }

    public Author findByFullName(String name, String lastname){
        return new SimpleAuthorRepository().findByFullName(name,lastname);
    }

    public boolean remove(Author author){
        return new SimpleAuthorRepository().remove(author);
    }
    public int count(){return new SimpleAuthorRepository().count();};

}
