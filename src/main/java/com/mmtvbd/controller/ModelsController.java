package com.mmtvbd.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mmtvbd.entity.Brand;
import com.mmtvbd.entity.Models;
import com.mmtvbd.repository.BrandRepo;
import com.mmtvbd.repository.ModelsRepo;
import com.mmtvbd.service.ModelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ModelsController {
    @Autowired
    private ModelsRepo modelsRepo;
    @Autowired
    private BrandRepo brandRepo;
    @Autowired
    private ModelsService modelsService;

    @RequestMapping(value = "/model/getAll")
    public String showAll(Model model){
        model.addAttribute("modelList", this.modelsRepo.findAll());
        return "models/index";
    }

    @RequestMapping(value = "/model/getBrand", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Brand> getBrandList(){
        return this.brandRepo.findAll();
    }
    @RequestMapping(value = "/model/get-all-model", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Models> getAllModel(){
        return this.modelsRepo.findAll();
    }

    @RequestMapping(value = "/model/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<Object> saveModels(@RequestBody ObjectNode objectNode, Models models ){
        List<Object> list=new ArrayList<>();
        String rtnMsg= modelsService.modelsSave(objectNode,models);
        list.add(rtnMsg);
        return list;
    }

    @GetMapping(value = "model/delete/{id}")
    public String deleteModel(@PathVariable("id") Long id ,Model model){
        this.modelsRepo.deleteById(id);
        return "redirect:/model/getAll";
    }

    @RequestMapping(value = "/model/update-data/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Object> updateModel(@PathVariable("id") Long id ,Model model){
        List<Models> list=  this.modelsRepo.findAllById(id);
        List<Brand> brandList = this.brandRepo.findAll();
        List<Object> result = new ArrayList<>();
        result.add(list);
        result.add(brandList);

        return result;
    }

    @RequestMapping(value = "/model/update", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<Object> saveModelUpdate(@RequestBody ObjectNode objectNode, Models models, Model model){
        List<Object> list=new ArrayList<>();
        String rtnMsg= modelsService.modelsUpdate(objectNode);
        list.add(rtnMsg);
        return list;
    }

}
