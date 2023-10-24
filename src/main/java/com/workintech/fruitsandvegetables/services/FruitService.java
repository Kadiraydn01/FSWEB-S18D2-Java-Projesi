package com.workintech.fruitsandvegetables.services;

import com.workintech.fruitsandvegetables.entity.Fruit;

import java.util.List;

public interface FruitService {
    List<Fruit> findAll();
    Fruit find(long id);
    Fruit save(Fruit fruit);
    Fruit delete (long id);

    List<Fruit>searchByName(String name);
    List<Fruit> searchPriceUp(double price);
    List<Fruit> searchPriceDown(double price);
}
