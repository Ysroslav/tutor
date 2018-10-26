package com.bodrov.spring.tutor.database.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = DictQuestion.TABLE_NAME)
@Entity(name = DictQuestion.ENTITY_NAME)
public class DictQuestion extends AbstractEntity {

    @NotNull
    public static final String ENTITY_NAME = "dictQuestion";

    @NotNull
    public static final String TABLE_NAME = "dict_question";

    @Column(name = "type_name", unique = true, nullable = false)
    private String nameType;

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
