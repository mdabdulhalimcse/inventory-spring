package com.mmtvbd.repository;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mmtvbd.entity.Brand;
import com.mmtvbd.entity.Models;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelsRepo extends JpaRepository<Models,Long> {
    List<Models> findAllById(Long id);
    List<Models> findAllByBrand(Brand brand);
}
