package com.workintech.fruitsandvegetables.dao;
import com.workintech.fruitsandvegetables.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable,Long> {
    @Query(value = "SELECT v " +
            "FROM Vegetable v " +
            "ORDER BY v.price asc")
    List<Vegetable> searchPriceAsc(double price);

    @Query(value = "SELECT v " +
            "FROM Vegetable v " +
            "ORDER BY v.price desc")
    List<Vegetable> searchPriceDesc(double price);

    @Query("SELECT v FROM Vegetable v WHERE v.name ilike %:name%")
    List<Vegetable> searchForVegetableName(String name);
}
