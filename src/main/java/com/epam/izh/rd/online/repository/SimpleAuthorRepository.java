package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public class SimpleAuthorRepository implements AuthorRepository {

  private Author[] authors=new Author[]{};

    public boolean save(Author author){
        Author tempAuthor=findByFullName(author.getName(),author.getLastName());
        if(tempAuthor==null){
            Author[] tempAuthors=new Author[authors.length+1];
            tempAuthors[authors.length]=author;
            authors=tempAuthors;
            return true;
        } else {
           return false;
        }
    }

    public Author findByFullName(String name, String lastname){
        for (int i=0;i<authors.length;i++){
            if (authors[i].getName() == name && authors[i].getLastName()==lastname) {
            return authors[i];
            }
        }
        return null;
    }
   public boolean remove(Author author){
       Author tempAuthor=findByFullName(author.getName(),author.getLastName());
       if(tempAuthor!=null){
           Author[] tempAuthors=new Author[authors.length-1];
           for (int i = 0; i < tempAuthors.length ; i++) {
               if(authors[i].getName()!=author.getName() && authors[i].getLastName()!=author.getLastName())
                   tempAuthors[i]=authors[i];
           }
           authors=tempAuthors;
           return true;
       } else {
           return false;
       }
   }

   @Override
    public int count(){ return authors.length;}

}
