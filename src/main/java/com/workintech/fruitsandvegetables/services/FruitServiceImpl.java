package com.workintech.fruitsandvegetables.services;

import com.workintech.fruitsandvegetables.dao.FruitRepository;
import com.workintech.fruitsandvegetables.entity.Fruit;
import com.workintech.fruitsandvegetables.exceptions.PlantErrorResponse;
import com.workintech.fruitsandvegetables.exceptions.PlantExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{

    private FruitRepository fruitRepository;
@Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit find(long id) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);
        if(fruitOptional.isPresent()){
            return fruitOptional.get();
        }
        throw new PlantExceptions("Fruit with given id is not exist: "+ id , HttpStatus.NOT_FOUND);
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(long id) {
    Fruit fruit = find(id);
    fruitRepository.delete(fruit);
        return fruit;
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchForFruitName(name);
    }

    @Override
    public List<Fruit> searchPriceUp(double price) {
        return fruitRepository.searchPriceAsc(price);
    }

    @Override
    public List<Fruit> searchPriceDown(double price) {
        return fruitRepository.searchPriceDesc(price);
    }
}
