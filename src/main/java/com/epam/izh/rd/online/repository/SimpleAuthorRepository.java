package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public class SimpleAuthorRepository implements AuthorRepository {

  private Author[] authors=new Author[]{};

    public boolean save(Author author){

        Author tempAuthor=findByFullName(author.getName(),author.getLastName());
        if(tempAuthor!=null){
            author.setName(tempAuthor.getName());
            author.setLastName(tempAuthor.getLastName());
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
            return null;
            }
        }
        Author tempAuthor=new Author();
        tempAuthor.setLastName(lastname);
        tempAuthor.setName(name);
        return tempAuthor;
    }
   public boolean remove(Author author){
       Author tempAuthor=findByFullName(author.getName(),author.getLastName());
       if(tempAuthor!=null){
           int count;
           for ( count=0;count<authors.length;count++) {
              if(authors[count]==author){
                  authors[count]=null;
              }
           }
           Author[] tempAuthors=new Author[authors.length-1];
           System.arraycopy(authors,0,tempAuthor,0,count-1);
           System.arraycopy(authors,count+1,tempAuthors,count,authors.length-count);
           authors=tempAuthors;
           return true;
       } else {
           return false;
       }
   }
    public int count(){ return authors.length;}

}
