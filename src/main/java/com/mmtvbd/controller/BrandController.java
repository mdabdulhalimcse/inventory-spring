package com.mmtvbd.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mmtvbd.entity.Brand;
import com.mmtvbd.repository.BrandRepo;
import com.mmtvbd.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BrandController {

    @Autowired
    private BrandRepo brandRepo;
    @Autowired
    private BrandService brandService;


    @RequestMapping(value = "/getAll")
    public String showAll(Model model){
        model.addAttribute("brandList", this.brandRepo.findAllByOrderByEntryDateDesc());
        return "brands/list";
    }


    @RequestMapping(value = "/brand/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<Object> saveBrand(@RequestBody ObjectNode objectNode,Brand brand){
        List<Object> list=new ArrayList<>();
        String rtnMsg= this.brandService.brandSave(objectNode,brand);
        list.add(rtnMsg);
        return list;
    }

    @RequestMapping(value = "/brand/update", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<Object> updateBrand(@RequestBody ObjectNode objectNode){
        List<Object> list=new ArrayList<>();
        String rtnMsg= this.brandService.brandUpdate(objectNode);
        list.add(rtnMsg);
        return list;
    }

    @GetMapping(value = "brand/delete/{id}")
    public String deleteBrand(@PathVariable("id") Long id ,Model model){
        this.brandRepo.deleteById(id);
        return "redirect:/getAll";
    }

    @RequestMapping(value = "/brand/update-data/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Brand> updateBrand(@PathVariable("id") Long id ,Model model){
        List<Brand> list=  this.brandRepo.findAllById(id);
        return list;
    }

    @RequestMapping(value = "/brand/find-brand", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Brand> findBrandByBrandName(){
        return this.brandRepo.findAll();
    }



}
