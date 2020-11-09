package com.hrms.api.res;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetEmployeesRes extends ServiceRes{
    private List<EmployeeRes> employeeList;

    public GetEmployeesRes(boolean success, String message) {
        super(success, message);
    }
}
