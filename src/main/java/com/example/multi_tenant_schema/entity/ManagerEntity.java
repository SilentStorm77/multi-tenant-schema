package com.example.multi_tenant_schema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "manager", schema = "association")
public class ManagerEntity {
    @Id
    @Column(name = "manager_name")
    private String managerName;

}
