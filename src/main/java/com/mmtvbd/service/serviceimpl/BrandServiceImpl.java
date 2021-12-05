package com.mmtvbd.service.serviceimpl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mmtvbd.entity.Brand;
import com.mmtvbd.repository.BrandRepo;
import com.mmtvbd.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepo brandRepo;

    @Override
    public List<Brand> findAllById(long id) {
        List<Brand> list=  this.brandRepo.findAllById(id);
        return list;
    }

    @Override
    public List<Brand> findAllByOrderByEntryDateDesc() {
        return null;
    }

    @Override
    public List<String> findBrandByBrandName(String name) {
        return null;
    }

    @Override
    public String brandUpdate(ObjectNode objectNode) {
        String name = objectNode.get("brandName").asText().toString();
        List<String> brands = this.brandRepo.findBrandByBrandName(name);
        int brandCheck = brands.size();

        if (brandCheck == 0){
            Brand brand1 = brandRepo.getOne(Long.valueOf(objectNode.get("id").asText()));
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            brand1.setEntryDate(timestamp);
            brand1.setBrandName(objectNode.get("brandName").asText());
            brandRepo.save(brand1);
            return "success";
        }
        return "dublicate";
    }

    @Override
    public String brandSave(ObjectNode objectNode,Brand brand) {
        String name = objectNode.get("brandName").asText().toString();
        List<String> brands = this.brandRepo.findBrandByBrandName(name);
        int brandCheck = brands.size();

        if (brandCheck == 0){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            brand.setEntryDate(timestamp);
            brand.setBrandName(objectNode.get("brandName").asText());
            brandRepo.save(brand);
            return "success";
        }
        return "dublicate";
    }
}
