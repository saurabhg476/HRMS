package com.hrms.api.res;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrms.model.Team;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamRes {

    private String name;
    private String code;
    private String description;
    private List<String> members;

    public TeamRes(Team team){
        this.name = team.getName();
        this.code = team.getCode();
        this.description = team.getDescription();
        this.members = new ArrayList<>(team.getMembers());
    }
}
