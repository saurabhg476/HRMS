package com.hrms.model;

import com.hrms.api.req.CreateEmployeeReq;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Employee {
    private String code;
    private String name;
    private String designation;
    private String team;

    public Employee(CreateEmployeeReq createEmployeeReq){
        this.name = createEmployeeReq.getName();
        this.designation = createEmployeeReq.getDesignation();
    }
}
