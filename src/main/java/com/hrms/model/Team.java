package com.hrms.model;

import com.hrms.api.req.CreateTeamReq;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Team {
    private String name;
    private String description;
    private String code;
    private Set<String> members;

    public Team(CreateTeamReq createTeamReq){
        this.name = createTeamReq.getName();
        this.description = createTeamReq.getDescription();
        this.members = new HashSet<>();
    }
}
