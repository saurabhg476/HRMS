package com.hrms.service;

import com.hrms.api.req.AssignEmployeeReq;
import com.hrms.api.req.CreateEmployeeReq;
import com.hrms.api.req.CreateTeamReq;
import com.hrms.api.res.*;

public interface IAdminService {

    CreateEmployeeRes createEmployee(CreateEmployeeReq createEmployeeReq);

    GetEmployeesRes getEmployees();

    CreateTeamRes createTeam(CreateTeamReq createTeamReq);

    AssignEmployeeRes assignEmployee(AssignEmployeeReq assignEmployeeReq);
}
