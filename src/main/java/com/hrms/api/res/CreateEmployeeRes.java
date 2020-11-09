package com.hrms.api.res;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrms.model.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateEmployeeRes extends ServiceRes {
    private EmployeeRes employee;

    public CreateEmployeeRes(boolean success, String message) {
        super(success, message);
    }
}
