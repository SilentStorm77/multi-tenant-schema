package com.example.multi_tenant_schema.dto;

import lombok.Data;

@Data
public class TeamDTO {
    private String teamName;
    private String city;
    private ManagerDTO manager;
}
