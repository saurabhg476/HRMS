package com.hrms.api.req;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssignEmployeeReq{
    @NonNull
    private String employeeCode;
    @NonNull
    private String teamCode;
}
