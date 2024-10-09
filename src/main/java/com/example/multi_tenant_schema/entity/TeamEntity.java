package com.example.multi_tenant_schema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "team")
public class TeamEntity {
    @Id
    @Column(name = "team_name")
    private String teamName;

    @NonNull
    private String city;

    @OneToOne
    @JoinColumn(name = "manager_name", referencedColumnName = "manager_name")
    private ManagerEntity managerName;
}
