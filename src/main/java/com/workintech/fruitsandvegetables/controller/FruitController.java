package com.workintech.fruitsandvegetables.controller;

import com.workintech.fruitsandvegetables.entity.Fruit;
import com.workintech.fruitsandvegetables.services.FruitService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/fruits")
public class FruitController {

    private FruitService fruitService;
@Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }
    @GetMapping("/")
    public List<Fruit> findAll(){
    return fruitService.findAll();
    }
    @GetMapping("/{id}")
    public Fruit find(@Positive @PathVariable long id){
    return fruitService.find(id);
    }
   @PostMapping("/")
    public Fruit save(@RequestBody Fruit fruit){
    return fruitService.save(fruit);
   }
    @DeleteMapping("/{id}")
    public Fruit delete(@Positive @PathVariable long id){
    return fruitService.delete(id);
    }
    @GetMapping("/priceUp/{price}")
    public List<Fruit> searchPriceUp(@PathVariable double price){
    return fruitService.searchPriceUp(price);
    }
    @GetMapping("/priceDown/{price}")
    public List<Fruit> searchPriceDown(@PathVariable double price){
        return fruitService.searchPriceDown(price);
    }
    @GetMapping("/byName/{name}")
    public List<Fruit> searchByName(@Size(min = 2 ,max = 15) @PathVariable String name){
    return fruitService.searchByName(name);
    }
}

