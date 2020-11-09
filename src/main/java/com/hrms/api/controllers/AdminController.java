package com.hrms.api.controllers;

import com.google.inject.Inject;
import com.hrms.api.req.AssignEmployeeReq;
import com.hrms.api.req.CreateEmployeeReq;
import com.hrms.api.req.CreateTeamReq;
import com.hrms.api.res.*;
import com.hrms.pojo.User;
import com.hrms.service.AdminService;
import com.hrms.service.IAdminService;
import io.dropwizard.auth.Auth;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class AdminController {

    private IAdminService adminService;

    @Inject
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @POST
    @Path("/employee")
    public CreateEmployeeRes createEmployee(@Valid CreateEmployeeReq createEmployeeReq, @Context HttpServletRequest req) {
        return adminService.createEmployee(createEmployeeReq);
    }

    @GET
    @Path("/employee")
    public GetEmployeesRes getEmployees(@Auth User user){
        return adminService.getEmployees();
    }

    @POST
    @Path("/team")
    public CreateTeamRes createTeam(@Valid CreateTeamReq createTeamReq){
        return adminService.createTeam(createTeamReq);
    }

    @POST
    @Path("/team/assign")
    public AssignEmployeeRes assignEmployeeRes(@Valid AssignEmployeeReq assignEmployeeReq){
        return adminService.assignEmployee(assignEmployeeReq);
    }

}
