package com.mmtvbd.service.serviceimpl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mmtvbd.entity.Brand;
import com.mmtvbd.entity.Models;
import com.mmtvbd.repository.BrandRepo;
import com.mmtvbd.repository.ModelsRepo;
import com.mmtvbd.service.ModelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ModelsServiceImpl implements ModelsService {
    @Autowired
    private ModelsRepo modelsRepo;
    @Autowired
    private BrandRepo brandRepo;
    @Autowired
    EntityManager entityManager;

    @Override
    public String modelsUpdate(ObjectNode objectNode) {
        String brandI = objectNode.get("brandName").asText();
        String modelName = objectNode.get("modelName").asText();
        Long bId = Long.parseLong(brandI);
        List<String> modelItems = entityManager.createNativeQuery(" SELECT model_name FROM inventory_db.models where model_name = '"+modelName+"' and brand_id= "+bId+"").getResultList();
        int modelCheck = modelItems.size();
        if (modelCheck == 0){
            String brandId = objectNode.get("brandName").asText();
            Models models = modelsRepo.getOne(Long.valueOf(objectNode.get("id").asText()));
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            models.setEntryDate(timestamp);
            models.setModelName(objectNode.get("modelName").asText());

            Brand brand = new Brand();
            brand.setId(Long.parseLong(brandId));

            models.setBrand(brand);
            modelsRepo.save(models);

            return "success";
        }
        return "dublicate";
    }

    @Override
    public String modelsSave(ObjectNode objectNode, Models models) {
        String brandI = objectNode.get("brandName").asText();
        String modelN = objectNode.get("modelName").asText();
        Long bId = Long.parseLong(brandI);
        List<String> modelItems = entityManager.createNativeQuery(" SELECT model_name FROM inventory_db.models where model_name = '"+modelN+"' and brand_id= "+bId+"").getResultList();
        int modelCheck = modelItems.size();
        if (modelCheck == 0){
            String brandId = objectNode.get("brandName").asText();
            String modelName = objectNode.get("modelName").asText();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            models.setEntryDate(timestamp);
            models.setModelName(objectNode.get("modelName").asText());
            Brand brand = new Brand();
            brand.setId(Long.parseLong(brandId));
            models.setBrand(brand);
            modelsRepo.save(models);
            return "success";
        }
        return "dublicate";
    }
}
