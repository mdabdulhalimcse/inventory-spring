package com.mmtvbd.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mmtvbd.entity.Brand;
import com.mmtvbd.repository.BrandRepo;
import com.mmtvbd.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public List<Brand> saveBrand(@RequestBody ObjectNode objectNode,Brand brand){
        return this.brandService.brandSave(objectNode,brand);
    }

    @RequestMapping(value = "/brand/update", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<Brand> updateBrand(@RequestBody ObjectNode objectNode){
        return this.brandService.brandUpdate(objectNode);
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
