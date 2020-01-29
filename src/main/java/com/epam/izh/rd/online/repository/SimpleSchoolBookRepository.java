package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {

    private SchoolBook[] schoolBooks = new SchoolBook[0];

    public boolean save(SchoolBook book) {

        SchoolBook[] mirrorSchoolBooks = new SchoolBook[schoolBooks.length];

        if (schoolBooks.length>0) {
            for (int i = 0; i < schoolBooks.length; i++) {
                mirrorSchoolBooks[i] = schoolBooks[i];
            }
            schoolBooks = new SchoolBook[schoolBooks.length + 1];

            for (int i = 0; i < schoolBooks.length - 1; i++) {
                schoolBooks[i] = mirrorSchoolBooks[i];
            }

            schoolBooks[schoolBooks.length - 1] = book;
        }
        else{
            schoolBooks = new SchoolBook[schoolBooks.length + 1];
            schoolBooks[schoolBooks.length - 1] = book;
        }
        return true;
    }

    public SchoolBook[] findByName(String name) {
        int countBooks = 0;
        for (int i = 0;i<schoolBooks.length;i++){
            if(schoolBooks[i].getName() == name){
                countBooks++;
            }
        }
        SchoolBook[] tempBooks = new SchoolBook[countBooks];
        countBooks=0;
        for (int i = 0;i<schoolBooks.length;i++){
            if(schoolBooks[i].getName() == name){
                tempBooks[countBooks]= schoolBooks[i];
                countBooks++;
            }
        }
        return tempBooks;
    }

    public boolean removeByName(String name) {
        int count = 0;
        SchoolBook[] removeBooks = new SchoolBook[schoolBooks.length-findByName(name).length];
        if (findByName(name).length !=0 ){
            for(int i = 0; i < schoolBooks.length; i++){
                if (schoolBooks[i].getName() != name){
                    removeBooks[count] = schoolBooks[i];
                    count++;
                }
            }
            schoolBooks = new SchoolBook[removeBooks.length];
            schoolBooks=removeBooks;
            return true;
        }
        else{
            return false;
        }
    }

    public int count() {
        return schoolBooks.length;
    }
}


