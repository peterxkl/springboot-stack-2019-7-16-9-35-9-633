package com.tw.apistackbase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompanyAPI {


    @GetMapping("/companies")
    public List<Company> getAllCompanies(){
        List<Employee> employees  = new ArrayList<>();
        List<Company> companies = new ArrayList<>();
        employees.add(new Employee(4,"oocl1",20,"male",6000));
        employees.add(new Employee(11,"oocl2",22,"male",6000));
        companies.add(new Company("ccol",200,employees));

        return companies;
    }

}
