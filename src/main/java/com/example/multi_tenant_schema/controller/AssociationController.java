package com.example.multi_tenant_schema.controller;

import com.example.multi_tenant_schema.dto.MultiDTO;
import com.example.multi_tenant_schema.entity.ManagerEntity;
import com.example.multi_tenant_schema.entity.TeamEntity;
import com.example.multi_tenant_schema.repository.ManagerRepository;
import com.example.multi_tenant_schema.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssociationController {

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/manager")
    List<ManagerEntity> getManagers() {
        return managerRepository.findAll();
    }

    @PostMapping("/manager")
    ManagerEntity addTenant(@RequestBody ManagerEntity managerEntity) {
        return managerRepository.save(managerEntity);
    }

    @GetMapping("/employed-managers")
    MultiDTO getEmployedManagers() {
        List<ManagerEntity> managerEntityList = managerRepository.findAll();
        List<TeamEntity> teamEntityList = teamRepository.findAll();
        return new MultiDTO(teamEntityList, managerEntityList);
    }
}
