package com.bodrov.spring.tutor.database.helper;

import javax.inject.Named;

@Named
public class MyRepository {

    private String nameRepository;

    private long countRows;

    private String pathXhtml;

    public MyRepository(){}

    public MyRepository(String nameRepository, long countRows){
        this.nameRepository = nameRepository;
        this.countRows = countRows;
        this.pathXhtml = "/secure/" + nameRepository.toLowerCase()
                .replaceAll("repository", "") + "-list";
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

    public String getPathXhtml() {
        return pathXhtml;
    }

    public void setPathXhtml(String pathXhtml) {
        this.pathXhtml = pathXhtml;
    }
}
