package com.mmtvbd.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mmtvbd.entity.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> findAllById(long id);
    List<Brand> findAllByOrderByEntryDateDesc();
    List<String> findBrandByBrandName(String name);
    List<Brand> brandUpdate(ObjectNode objectNode);
    List<Brand> brandSave(ObjectNode objectNode,Brand brand);

}
