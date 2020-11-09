package com.hrms.service;

import com.google.inject.Inject;
import com.hrms.api.req.AssignEmployeeReq;
import com.hrms.api.req.CreateEmployeeReq;
import com.hrms.api.req.CreateTeamReq;
import com.hrms.api.res.*;
import com.hrms.constants.Constants;
import com.hrms.db.IDBManager;
import com.hrms.db.InMemoryDBManager;
import com.hrms.exceptions.HRMSException;
import com.hrms.model.Employee;
import com.hrms.model.Team;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class AdminService implements IAdminService{

    private IDBManager idbManager;

    @Inject
    public AdminService(InMemoryDBManager inMemoryDBManager){
        this.idbManager = inMemoryDBManager;
    }

    @Override
    public CreateEmployeeRes createEmployee(CreateEmployeeReq createEmployeeReq) {
        try{
            Employee employee = new Employee(createEmployeeReq);
            Employee savedEmployee = idbManager.createEmployee(employee);
            CreateEmployeeRes response = new CreateEmployeeRes(true, Constants.EMPLOYEE_CREATED_SUCCESSFUL);
            response.setEmployee(new EmployeeRes(savedEmployee));
            return response;
        }catch(HRMSException e){
            log.error("error while creating employee",e);
            return new CreateEmployeeRes(false, e.getCode().getMessage());
        }catch (Exception e){
            log.error("error while creating employee",e);
            return new CreateEmployeeRes(false, Constants.SOMETHING_WENT_WRONG);
        }
    }

    @Override
    public GetEmployeesRes getEmployees(){
        try{
            List<Employee> employeeList = idbManager.getEmployees();
            List<EmployeeRes> resEmployeeList = employeeList.stream().map(EmployeeRes::new).collect(Collectors.toList());
            GetEmployeesRes response = new GetEmployeesRes(true, Constants.EMPLOYEE_DETAILS_FETCHED_SUCCESSFUL);
            response.setEmployeeList(resEmployeeList);
            return response;
        }catch(HRMSException e){
            return new GetEmployeesRes(false, e.getCode().getMessage());
        }catch(Exception e){
            return new GetEmployeesRes(false, Constants.SOMETHING_WENT_WRONG);
        }
    }

    @Override
    public CreateTeamRes createTeam(CreateTeamReq createTeamReq) {
        try{
            Team team = new Team(createTeamReq);
            Team savedTeam = idbManager.createTeam(team);
            CreateTeamRes response = new CreateTeamRes(true, Constants.TEAM_CREATED_SUCCESSFULLY);
            response.setTeam(new TeamRes(savedTeam));
            return response;
        }catch(HRMSException e){
            log.error("error while creating team ", e);
            return new CreateTeamRes(false, e.getCode().getMessage());
        }catch (Exception e){
            log.error("error while creating team ", e);
            return new CreateTeamRes(false, Constants.SOMETHING_WENT_WRONG);
        }
    }

    @Override
    public AssignEmployeeRes assignEmployee(AssignEmployeeReq assignEmployeeReq) {
        try {
            String employeeCode = assignEmployeeReq.getEmployeeCode();
            String teamCode = assignEmployeeReq.getTeamCode();
            idbManager.assignEmployee(employeeCode, teamCode);
            return new AssignEmployeeRes(true, Constants.EMPLOYEE_ASSIGNED_SUCCESSFULLY);
        }catch(HRMSException e){
            return new AssignEmployeeRes(false, e.getCode().getMessage());
        }catch(Exception e){
            return new AssignEmployeeRes(false, Constants.SOMETHING_WENT_WRONG);
        }
    }
}
