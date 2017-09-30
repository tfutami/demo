package com.example.demo.dto;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Data
public class ZipCodeDto {

    int status;

    String message;

    List<ZipCodeDataDto> results = new ArrayList<>();

    public void setResults(List<ZipCodeDataDto> results){
        this.results = results;
    }

    public List<ZipCodeDataDto> getResults(){
        return this.results;
    }

}
