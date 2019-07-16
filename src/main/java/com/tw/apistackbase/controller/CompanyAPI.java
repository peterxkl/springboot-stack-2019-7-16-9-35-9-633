package com.tw.apistackbase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CompanyAPI {

    List<Employee> employees  = new ArrayList<>();
    List<Employee> employees1  = new ArrayList<>();
    List<Company> companies = new ArrayList<>();
    @GetMapping("/companies")
    public List<Company> getAllCompanies(){
        employees.add(new Employee(4,"oocl1",20,"male",6000));
        employees.add(new Employee(11,"oocl2",22,"male",6000));

        employees1.add(new Employee(43,"alibaba1",20,"male",6000));
        employees1.add(new Employee(17,"alibaba2",22,"male",6000));

        companies.add(new Company(1,"ccol",200,employees));
        companies.add(new Company(2,"alibaba",200,employees1));

        return companies;
    }
    @GetMapping("/companies/{id}")
    public Company getCompany(@PathVariable Long id){
         Company company = companies.stream().filter(x->x.getCompanyId()==id).collect(Collectors.toList()).get(0);
         return company;

    }
    @GetMapping("/companies/{id}/employees")
    public List<Employee> getAllEmployeeOnCompany(@PathVariable Long id){
        Company company = companies.stream().filter(x->x.getCompanyId()==id).collect(Collectors.toList()).get(0);
        if(company==null){
            return null;
        }else{
            return company.getEmployees();
        }

    }

    @GetMapping("/companies?page={page}&pageSize={pageSize}")
    public List<Company> getSomeCompany(@PathVariable int page, @PathVariable int pageSize){
        List<Company> companies2 = new ArrayList<>();
        for (int i =(page-1)*pageSize ;i<pageSize*page;i++){
            companies2.add(companies.get(i));
        }
        return companies2;
    }

    @PostMapping("/companies")
    public Company addCompany(@RequestBody Company company){
        company.setCompanyId(4);
        companies.add(company);
        return company;
    }

}
