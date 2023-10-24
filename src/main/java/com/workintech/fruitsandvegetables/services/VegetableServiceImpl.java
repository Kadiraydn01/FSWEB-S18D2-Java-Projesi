package com.workintech.fruitsandvegetables.services;

import com.workintech.fruitsandvegetables.dao.VegetableRepository;
import com.workintech.fruitsandvegetables.entity.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VegetableServiceImpl implements VegetableService{

    private VegetableRepository vegetableRepository;
@Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public Vegetable find(long id) {
        return null;
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable delete(long id) {
    Vegetable vegetable = find(id);
    vegetableRepository.delete(vegetable);
        return vegetable;
    }

    @Override
    public List<Vegetable> searchPriceUp(double price) {
        return vegetableRepository.searchPriceDesc(price);
    }

    @Override
    public List<Vegetable> searchPriceDown(double price) {
        return vegetableRepository.searchPriceAsc(price);
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchForVegetableName(name);
    }
}
