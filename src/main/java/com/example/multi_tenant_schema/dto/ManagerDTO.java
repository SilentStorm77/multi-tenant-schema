package com.example.multi_tenant_schema.dto;

public class ManagerDTO {
    private String managerName;

    public ManagerDTO(){
    }

    public ManagerDTO(String managerName){
        this.managerName = managerName;
    }

    public String getManagerName(){
        return managerName;
    }

    public void setManagerName(String managerName){
        this.managerName = managerName;
    }
}
