package com.mmtvbd.service.serviceimpl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mmtvbd.entity.Brand;
import com.mmtvbd.entity.Models;
import com.mmtvbd.repository.BrandRepo;
import com.mmtvbd.repository.ModelsRepo;
import com.mmtvbd.service.ModelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ModelsServiceImpl implements ModelsService {
    @Autowired
    private ModelsRepo modelsRepo;
    @Autowired
    private BrandRepo brandRepo;

    @Override
    public List<Models> modelsUpdate(ObjectNode objectNode) {
        String brandName = objectNode.get("brandName").asText();
        List<Brand> brands = this.brandRepo.findAllById(Long.parseLong(brandName));
        String getBrandName= brands.get(0).getBrandName();
        List<Models> models1 = this.modelsRepo.findAll();
        boolean result = true;
        for (Models s: models1) {
            if (getBrandName.equals(s.getBrand().getBrandName()) && s.getModelName().equals(objectNode.get("modelName").asText())) {
                System.out.println("Already exists! Please try again...");
                result = false;
                break;
            } else {
                result = true;
            }
        }

        if (result == true){
            String brandId = objectNode.get("brandName").asText();
            Models models = modelsRepo.getOne(Long.valueOf(objectNode.get("id").asText()));
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            models.setEntryDate(timestamp);
            models.setModelName(objectNode.get("modelName").asText());

            Brand brand = new Brand();
            brand.setId(Long.parseLong(brandId));

            models.setBrand(brand);
            modelsRepo.save(models);
        }
        return null;
    }

    @Override
    public List<Models> modelsSave(ObjectNode objectNode, Models models) {
        String brandName = objectNode.get("brandName").asText();
        List<Brand> brands = this.brandRepo.findAllById(Long.parseLong(brandName));
        String getBrandName= brands.get(0).getBrandName();
        List<Models> models1 = this.modelsRepo.findAll();
        boolean result = true;
        for (Models s: models1) {
            if (getBrandName.equals(s.getBrand().getBrandName()) && s.getModelName().equals(objectNode.get("modelName").asText())) {
                System.out.println("Already exists! Please try again...");
                result = false;
                break;
            } else {
                result = true;
            }
        }

        if (result == true){
            String brandId = objectNode.get("brandName").asText();
            String modelName = objectNode.get("modelName").asText();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            models.setEntryDate(timestamp);
            models.setModelName(objectNode.get("modelName").asText());
            Brand brand = new Brand();
            brand.setId(Long.parseLong(brandId));
            models.setBrand(brand);
            modelsRepo.save(models);
        }
        return null;
    }
}
