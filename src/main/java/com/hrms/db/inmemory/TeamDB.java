package com.hrms.db.inmemory;

import com.hrms.model.Team;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class TeamDB {
    private String name;
    private String code;
    private String description;
    private Set<String> members;

    public TeamDB(Team team){
        this.name = team.getName();
        this.code = team.getCode();
        this.description = team.getDescription();
        this.members = team.getMembers();
    }

    public Team toTeam(){
        Team team = new Team();
        team.setCode(this.code);
        team.setName(this.name);
        team.setDescription(this.description);
        team.setMembers(this.members);

        return team;
    }
}
