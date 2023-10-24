package com.workintech.fruitsandvegetables.services;

import com.workintech.fruitsandvegetables.dao.VegetableRepository;
import com.workintech.fruitsandvegetables.entity.Vegetable;
import com.workintech.fruitsandvegetables.exceptions.PlantExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Vegetable> vegetableOptional = vegetableRepository.findById(id);
        if(vegetableOptional.isPresent()){
            return vegetableOptional.get();
        }
        throw new PlantExceptions("Vegetable with given id is not exist: "+ id , HttpStatus.NOT_FOUND);

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
