package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.Book;
import com.epam.izh.rd.online.entity.SchoolBook;
import com.epam.izh.rd.online.repository.BookRepository;

public class SimpleSchoolBookService implements BookService {
    private BookRepository<SchoolBook> schoolBookBookRepository;
    private AuthorService authorService;


    public SimpleSchoolBookService() {

    }

    public SimpleSchoolBookService(BookRepository<SchoolBook> schoolBookBookRepository, AuthorService authorService) {
        this.schoolBookBookRepository = schoolBookBookRepository;
        this.authorService = authorService;
    }

        public boolean save(Book book){
        Author author=findAuthorByBookName(book.getName());
        if(author!=null || (schoolBookBookRepository.count()==0 && authorService.count()!=0)){
            schoolBookBookRepository.save((SchoolBook) book);
            return true;
        }else {
            return false;
        }
    }

    public Book[] findByName(String name) {
        return schoolBookBookRepository.findByName(name);
    }

    public int getNumberOfBooksByName(String name) {
        return findByName(name).length;
    }

    public boolean removeByName(String name) {
        return schoolBookBookRepository.removeByName(name);
    }

    public int count() {
        return schoolBookBookRepository.count();
    }

    public Author findAuthorByBookName(String name) {
        SchoolBook[] books = schoolBookBookRepository.findByName(name);
        if (books.length > 0) {
            return authorService.findByFullName(books[0].getAuthorName(),books[0].getAuthorLastName());
        }else {
            return null;
        }
    }
}
