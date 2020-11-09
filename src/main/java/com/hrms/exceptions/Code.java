package com.hrms.exceptions;

import lombok.Getter;

@Getter
public enum Code {

    ALREADY_ASSIGNED("this employee is already a part of this team");

    String message;

    Code(String message){
        this.message = message;
    }
}
