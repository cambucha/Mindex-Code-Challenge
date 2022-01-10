package com.mindex.challenge;


import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document                                   //tells this class will be collection and store doc inside collection
public class Compensation {

    /*instance variables*/
    @Indexed(unique = true)                 //this stops the program from submitting duplicate records, so two emails can't be the same.
    private String employee;
    private String salary;
    private LocalDateTime effectiveDate;

    public Compensation(String employee, String salary, LocalDateTime effectiveDate) {
        this.employee = employee;
        this.salary = salary;
        this.effectiveDate = effectiveDate;
    }
}
