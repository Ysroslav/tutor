package com.bodrov.spring.tutor.database.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = DictPoll.TABLE_NAME)
@Entity(name = DictPoll.ENTITY_NAME)
public class DictPoll extends AbstractEntity {

    @NotNull
    public static final String ENTITY_NAME = "dictPoll";

    @NotNull
    public static final String TABLE_NAME = "dict_poll";

    @Column(name = "type_name", unique = false, nullable = true)
    private String nameType;

    public DictPoll(){}

    public DictPoll(String nameType){this.nameType = nameType;}

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
