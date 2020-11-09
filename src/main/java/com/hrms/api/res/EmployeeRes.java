package com.hrms.api.res;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrms.model.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeRes {
    private String code;
    private String name;
    private String designation;
    private String team;

    public EmployeeRes(Employee employee){
        this.code = employee.getCode();
        this.name = employee.getName();
        this.designation = employee.getDesignation();
        this.team = employee.getTeam();
    }
}
