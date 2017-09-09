package com.zinios.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zinios.blog.bean.Employee;

@RestController
public class EmployeeRESTController
{
    @RequestMapping(value = "/employees")
    public List<Employee> getAllEmployees()
    {
        List<Employee> employees = new ArrayList<Employee>();
          
        Employee empOne = new Employee(1,"Lokesh","Gupta","howtodoinjava@gmail.com");
        Employee empTwo = new Employee(2,"Amit","Singhal","asinghal@yahoo.com");
        Employee empThree = new Employee(3,"Kirti","Mishra","kmishra@gmail.com");
          
          
        employees.add(empOne);
        employees.add(empTwo);
        employees.add(empThree);
          
        return employees;
    }
      
    @RequestMapping(value = "/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") int id)
    {
        if (id <= 3) {
            Employee employee = new Employee(1,"Lokesh","Gupta","howtodoinjava@gmail.com");
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}