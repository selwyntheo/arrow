package com.model;

import lombok.*;

import com.opencsv.bean.CsvBindByName;

@Data
@Getter
@Setter
//@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Holding {

    @CsvBindByName(column="securityId")
    public String securityId;

    @CsvBindByName(column="securityIdType")
    public String securityIdType;

    @CsvBindByName(column="quantity")
    public int quantity;

    @CsvBindByName(column="price")
    public float price;

    @CsvBindByName(column="marketValueBase")
    public float marketValueBase;

    @CsvBindByName(column="marketValueLocal")
    public float marketValueLocal;

    @CsvBindByName(column="currency")
    public String currency;

    @CsvBindByName(column="effectiveDate")
    public String effectiveDate;

    @CsvBindByName(column="fundId")
    public String fundId;


    // Getters and setters and toString method go here.

}

