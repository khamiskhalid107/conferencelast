package com.example.zcsranew.repository;

import com.example.zcsranew.controller.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepo extends JpaRepository<Visitor , Long> {
}
