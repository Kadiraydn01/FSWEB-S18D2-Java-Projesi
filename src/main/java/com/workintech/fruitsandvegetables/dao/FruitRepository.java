package com.workintech.fruitsandvegetables.dao;

import com.workintech.fruitsandvegetables.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit,Long> {

    @Query(value = "SELECT f " +
            "FROM Fruit f " +
            "ORDER BY f.price asc")
    List<Fruit> searchPriceAsc(double price);

    @Query(value = "SELECT f " +
            "FROM Fruit f " +
            "ORDER BY f.price desc" )
    List<Fruit> searchPriceDesc(double price);

    @Query("SELECT f FROM Fruit f WHERE f.name ilike %:name%")
    List<Fruit> searchForFruitName(String name);

}
