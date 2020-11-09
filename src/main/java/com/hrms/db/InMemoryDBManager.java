package com.hrms.db;

import com.google.inject.Singleton;
import com.hrms.constants.Constants;
import com.hrms.db.inmemory.EmployeeDB;
import com.hrms.db.inmemory.TeamDB;
import com.hrms.exceptions.Code;
import com.hrms.exceptions.HRMSException;
import com.hrms.model.Employee;
import com.hrms.model.Team;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Singleton
public class InMemoryDBManager implements IDBManager {

    private Map<String, EmployeeDB> employeeStore = new HashMap<>();
    private Map<String, TeamDB> teamStore = new HashMap<>();
    private AtomicInteger employeeCounter = new AtomicInteger(0);
    private AtomicInteger teamCounter = new AtomicInteger(0);


    private String generateNewEmployeeCode(){
        int employeeNumber = employeeCounter.incrementAndGet();
        return Constants.EMP + employeeNumber;
    }

    private String generateNewTeamCode(){
        int teamNumber = teamCounter.incrementAndGet();
        return Constants.TEAM + teamNumber;
    }

    @Override
    public Employee createEmployee(Employee employee) throws HRMSException {
        EmployeeDB employeeDB = new EmployeeDB(employee);
        String code = generateNewEmployeeCode();
        employeeDB.setCode(code);
        employeeStore.put(code,employeeDB);
        return employeeDB.toEmployee();
    }

    @Override
    public List<Employee> getEmployees() throws HRMSException {
        List<Employee> employeeList = new ArrayList<>();
        employeeStore.forEach((k,v)-> employeeList.add(v.toEmployee()));
        return employeeList;
    }

    @Override
    public Team createTeam(Team team) throws HRMSException {
        TeamDB teamDB = new TeamDB(team);
        String code = generateNewTeamCode();
        teamDB.setCode(code);
        teamStore.put(code,teamDB);
        return teamDB.toTeam();
    }

    @Override
    public void assignEmployee(String employeeCode, String teamCode) throws HRMSException {
        TeamDB teamDB = teamStore.get(teamCode);
        EmployeeDB employeeDB = employeeStore.get(employeeCode);
        Set<String> members = teamDB.getMembers();

        if(members.contains(employeeCode)){
            throw new HRMSException(Code.ALREADY_ASSIGNED);
        }
        synchronized (this){
            members.add(employeeCode);
        }
        employeeDB.setTeam(teamCode);
    }
}
