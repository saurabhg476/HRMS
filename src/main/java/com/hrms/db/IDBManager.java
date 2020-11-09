package com.hrms.db;

import com.hrms.exceptions.HRMSException;
import com.hrms.model.Employee;
import com.hrms.model.Team;

import java.util.List;

public interface IDBManager {
    Employee createEmployee(Employee employee) throws HRMSException;
    List<Employee> getEmployees() throws HRMSException;
    Team createTeam(Team team) throws HRMSException;
    void assignEmployee(String employeeCode, String teamCode) throws HRMSException;
}
