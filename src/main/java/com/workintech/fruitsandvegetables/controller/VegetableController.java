package com.workintech.fruitsandvegetables.controller;

import com.workintech.fruitsandvegetables.entity.Fruit;
import com.workintech.fruitsandvegetables.entity.Vegetable;
import com.workintech.fruitsandvegetables.services.VegetableService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
@RequestMapping("/vegetables")
public class VegetableController {
    private VegetableService vegetableService;
@Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping("/")
    public List<Vegetable> findAll(){
        return vegetableService.findAll();
    }
    @GetMapping("/{id}")
    public Vegetable find(@Positive @PathVariable long id){
        return vegetableService.find(id);
    }
    @PostMapping("/")
    public Vegetable save(@Validated @RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }
    @DeleteMapping("/{id}")
    public Vegetable delete(@Positive @PathVariable long id){
        return vegetableService.delete(id);
    }
    @GetMapping("/priceUp/{price}")
    public List<Vegetable> searchPriceUp(@PathVariable double price){
        return vegetableService.searchPriceUp(price);
    }
    @GetMapping("/priceDown/{price}")
    public List<Vegetable> searchPriceDown(@PathVariable double price){
        return vegetableService.searchPriceDown(price);
    }
    @GetMapping("/byName/{name}")
    public List<Vegetable> searchByName(@Size(min = 2 ,max = 15) @PathVariable String name){
        return vegetableService.searchByName(name);
    }
}
