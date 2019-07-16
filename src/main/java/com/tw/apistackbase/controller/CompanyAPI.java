package com.tw.apistackbase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CompanyAPI {

    List<Employee> employees  = new ArrayList<>();
    List<Company> companies = new ArrayList<>();
    @GetMapping("/companies")
    public List<Company> getAllCompanies(){
        employees.add(new Employee(4,"oocl1",20,"male",6000));
        employees.add(new Employee(11,"oocl2",22,"male",6000));
        companies.add(new Company(1,"ccol",200,employees));

        return companies;
    }
    @GetMapping("/companies/{id}")
    public Company getCompany(@PathVariable Long id){
         Company company = companies.stream().filter(x->x.getCompanyId()==id).collect(Collectors.toList()).get(0);
         return company;

    }

}
