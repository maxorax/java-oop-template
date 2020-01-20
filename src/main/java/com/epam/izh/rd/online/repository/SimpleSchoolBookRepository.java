package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook>{

    private SchoolBook[] schoolBooks= new SchoolBook[]{};

    public boolean save(SchoolBook book){
        SchoolBook[] tempSchoolBooks=new SchoolBook[schoolBooks.length+1];
        tempSchoolBooks[schoolBooks.length]=book;
        schoolBooks=tempSchoolBooks;
        return true;
    }

    public SchoolBook[] findByName(String name){
        SchoolBook[] tempSchoolBooks=new SchoolBook[]{};
        for (int i = 0; i <schoolBooks.length ; i++) {
            if(schoolBooks[i].getName()==name){
                SchoolBook[] tempTempSchoolBooks=new SchoolBook[tempSchoolBooks.length+1];
                tempTempSchoolBooks[tempSchoolBooks.length]=schoolBooks[i];
                tempSchoolBooks=tempTempSchoolBooks;
            }
        }
        return tempSchoolBooks;
    }

    public boolean removeByName(String name){
        SchoolBook[] removeSchoolBooks=findByName(name);
        if (removeSchoolBooks != null) {
            for ( int i = 0; i < schoolBooks.length ; i++) {
                if(schoolBooks[i].getName()==name){
                    schoolBooks[i]=null;
                }
            }
            for (int i = 0; i <schoolBooks.length ; i++) {
                if(schoolBooks[i]==null){
                    for (int j=0;j<schoolBooks.length;j++){
                        SchoolBook temp=schoolBooks[i];
                        schoolBooks[i]=schoolBooks[j];
                        schoolBooks[j]=temp;
                    }
                }

            }
            return true;
        } else {
            return false;
        }
    }

    public  int count(){
        return schoolBooks.length;
    }


}
