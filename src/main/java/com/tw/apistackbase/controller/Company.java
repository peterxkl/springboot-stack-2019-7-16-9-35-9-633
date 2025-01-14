package com.tw.apistackbase.controller;

import java.util.List;

public class Company {
        private long companyId;
        private String companyName;
        private long employeesNumber;
        private List<Employee> employees;

    public Company() {
    }

    public Company(long companyId, String companyName, long employeesNumber, List<Employee> employees) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
        this.employees = employees;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public long getEmployeesNumber() {
            return employeesNumber;
        }

        public void setEmployeesNumber(long employeesNumber) {
            this.employeesNumber = employeesNumber;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(List<Employee> employees) {
            this.employees = employees;
        }
}
