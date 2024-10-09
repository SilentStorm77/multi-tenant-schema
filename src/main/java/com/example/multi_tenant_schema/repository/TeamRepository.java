package com.example.multi_tenant_schema.repository;

import com.example.multi_tenant_schema.entity.ManagerEntity;
import com.example.multi_tenant_schema.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<TeamEntity, String> {

    List<TeamEntity> findByCity(String city);

    List<TeamEntity> findByManagerName(ManagerEntity managerName);

    @Query(value = "SELECT m.manager_name, t.team_name, t.city FROM Association.manager m INNER JOIN PL.team t ON t.manager_name = m.manager_name", nativeQuery = true)
    List<TeamEntity> findMaagersWithTeams();
}
