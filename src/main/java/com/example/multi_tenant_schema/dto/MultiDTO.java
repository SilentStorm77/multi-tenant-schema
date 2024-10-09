package com.example.multi_tenant_schema.dto;

import com.example.multi_tenant_schema.entity.ManagerEntity;
import com.example.multi_tenant_schema.entity.TeamEntity;

import java.util.List;

public class MultiDTO {

    List<TeamEntity> teams;
    List<ManagerEntity> managers;

    public MultiDTO(){

    }

    public MultiDTO(List<TeamEntity> teams, List<ManagerEntity> managers){
        this.teams = teams;
        this.managers = managers;
    }
}
