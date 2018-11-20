package com.bodrov.spring.tutor.database.helper;

import javax.inject.Named;

@Named
public class MyRepository {

    private String nameRepository;

    private long countRows;

    public MyRepository(){}

    public MyRepository(String nameRepository, long countRows){
        this.nameRepository = nameRepository;
        this.countRows = countRows;
    }

    public String getNameRepository() {
        return nameRepository;
    }

    public void setNameRepository(String nameRepository) {
        this.nameRepository = nameRepository;
    }

    public long getCountRows() {
        return countRows;
    }

    public void setCountRows(long countRows) {
        this.countRows = countRows;
    }
}
