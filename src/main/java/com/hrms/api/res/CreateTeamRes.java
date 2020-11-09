package com.hrms.api.res;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrms.model.Team;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTeamRes extends ServiceRes {
    private TeamRes team;

    public CreateTeamRes(boolean success, String message) {
        super(success, message);
    }
}
