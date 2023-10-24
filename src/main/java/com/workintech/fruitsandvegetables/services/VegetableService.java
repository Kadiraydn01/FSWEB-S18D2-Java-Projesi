package com.workintech.fruitsandvegetables.services;

import com.workintech.fruitsandvegetables.entity.Fruit;
import com.workintech.fruitsandvegetables.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    List<Vegetable> findAll();
    Vegetable find(long id);
    Vegetable save(Vegetable vegetable);
    Vegetable delete (long id);

    List<Vegetable> searchPriceUp(double price);
    List<Vegetable> searchPriceDown(double price);
    List<Vegetable> searchByName(String name);
}
