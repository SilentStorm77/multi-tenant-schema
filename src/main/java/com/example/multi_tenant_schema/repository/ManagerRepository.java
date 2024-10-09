package com.example.multi_tenant_schema.repository;

import com.example.multi_tenant_schema.entity.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<ManagerEntity, String> {
}
