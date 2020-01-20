package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.SchoolBook;
import com.epam.izh.rd.online.repository.BookRepository;
import com.epam.izh.rd.online.repository.SimpleSchoolBookRepository;

public abstract class SimpleSchoolBookService implements BookService<SchoolBook> {

    private BookRepository<SchoolBook> schoolBookBookRepository;

    private AuthorService authorService;

    public SimpleSchoolBookService() {
    }

    public SimpleSchoolBookService(BookRepository<SchoolBook> schoolBookBookRepository, AuthorService authorService) {
        this.schoolBookBookRepository = schoolBookBookRepository;
        this.authorService = authorService;
    }

    public boolean save(SchoolBook book){
        if (authorService.findByFullName(book.getAuthorName(),book.getAuthorLastName())!=null){
            return new SimpleSchoolBookRepository().save(book);
        }else {
            return false;
        }
    }

    public SchoolBook[] findByName(String name){
        return new SimpleSchoolBookRepository().findByName(name);
    }

    public int getNumberOfBooksByName(String name){
        return new SimpleSchoolBookRepository().findByName(name).length;
    }

    public boolean removeByName(String name){
        return new SimpleSchoolBookRepository().removeByName(name);
    }

    public int count(){
        return new SimpleSchoolBookRepository().count();
    }

    public Author findAuthorByBookName(String name){
        if(schoolBookBookRepository.findByName(name)!=null){
            SchoolBook[] book=schoolBookBookRepository.findByName(name);
            return authorService.findByFullName(book[0].getAuthorName(),book[0].getAuthorLastName());
        } else{ return null;}
    }


}
