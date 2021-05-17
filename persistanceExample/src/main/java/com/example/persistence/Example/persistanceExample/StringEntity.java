package com.example.persistence.Example.persistanceExample;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StringEntity {
    @Id
    private String string;

    public StringEntity(){}

    public StringEntity(String string){
        this.string = string;
    }
    public String getString(){
        return this.string;
    }
}
