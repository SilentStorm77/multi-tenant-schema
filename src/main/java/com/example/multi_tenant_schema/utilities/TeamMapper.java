package com.example.multi_tenant_schema.utilities;

import com.example.multi_tenant_schema.dto.TeamDTO;
import com.example.multi_tenant_schema.entity.TeamEntity;

public class TeamMapper {

    public static TeamDTO toDTO(TeamEntity teamEntity){
        TeamDTO dto = new TeamDTO();
        dto.setTeamName(teamEntity.getTeamName());
        dto.setCity(teamEntity.getCity());
        dto.setManager(ManagerMapper.toDTO(teamEntity.getManagerName()));
        return dto;
    }

    public static TeamEntity toEntity(TeamDTO teamDTO){
        TeamEntity entity = new TeamEntity();
        entity.setTeamName(teamDTO.getTeamName());
        entity.setCity(teamDTO.getCity());
        entity.setManagerName(ManagerMapper.toEntity(teamDTO.getManager()));
        return entity;
    }
}
