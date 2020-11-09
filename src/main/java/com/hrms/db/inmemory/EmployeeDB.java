package com.hrms.db.inmemory;

import com.hrms.model.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class EmployeeDB {
    private String code;
    private String name;
    private String designation;
    private String team;

    public EmployeeDB(Employee employee){
        this.code = employee.getCode();
        this.name = employee.getName();
        this.designation = employee.getDesignation();
        this.team = employee.getTeam();
    }

    public Employee toEmployee(){
        Employee employee = new Employee();
        employee.setName(this.name);
        employee.setCode(this.code);
        employee.setDesignation(this.designation);
        employee.setTeam(this.team);
        return employee;
    }
}
