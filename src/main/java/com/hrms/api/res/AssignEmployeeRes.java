package com.hrms.api.res;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssignEmployeeRes extends ServiceRes {

    public AssignEmployeeRes(boolean success, String message) {
        super(success, message);
    }
}
