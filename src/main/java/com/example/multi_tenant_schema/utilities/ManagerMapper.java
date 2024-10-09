package com.example.multi_tenant_schema.utilities;

import com.example.multi_tenant_schema.dto.ManagerDTO;
import com.example.multi_tenant_schema.entity.ManagerEntity;

public class ManagerMapper {

    public static ManagerDTO toDTO(ManagerEntity managerEntity){
        ManagerDTO dto = new ManagerDTO();
        dto.setManagerName(managerEntity.getManagerName());
        return dto;
    }

    public static ManagerEntity toEntity(ManagerDTO managerDTO){
        ManagerEntity entity = new ManagerEntity();
        entity.setManagerName(managerDTO.getManagerName());
        return entity;
    }
}
