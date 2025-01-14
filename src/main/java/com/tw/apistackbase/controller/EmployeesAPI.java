package com.tw.apistackbase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeesAPI {
    private static List<Employee> employees = new ArrayList<>();
    static {
        employees.add(new Employee(4,"oocl1",20,"male",6000));
        employees.add(new Employee(11,"oocl2",22,"female",6000));
        employees.add(new Employee(15,"oocl3",20,"male",6000));
        employees.add(new Employee(17,"oocl4",24,"female",6000));
    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id){

        return employees.stream().filter(x->x.getId()==id).collect(Collectors.toList()).get(0);
    }
    @GetMapping(path="/employees", params = {"page","pageSize"})
    public List<Employee> getSomeCompany(@RequestParam int page,@RequestParam int pageSize){
        List<Employee> employees1 = new ArrayList<>();
        for (int i =(page-1)*pageSize ;i<pageSize*page;i++){
            employees1.add(employees.get(i));
        }
        return employees1;
    }

    @GetMapping(path="/employees", params = {"gender"})
    public List<Employee> getSomeCompanyByGender(@RequestParam String gender){
        return employees.stream().filter(x->x.getGender()==gender).collect(Collectors.toList());
    }
}
