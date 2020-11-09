package com.hrms.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.ws.rs.WebApplicationException;

@Getter
@Setter
@AllArgsConstructor
public class HRMSException extends WebApplicationException {
    private Code code;
}
