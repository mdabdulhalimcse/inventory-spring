package com.mmtvbd.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mmtvbd.entity.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> findAllById(long id);
    List<Brand> findAllByOrderByEntryDateDesc();
    List<String> findBrandByBrandName(String name);
    String brandUpdate(ObjectNode objectNode);
    String brandSave(ObjectNode objectNode,Brand brand);

}
