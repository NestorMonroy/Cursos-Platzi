package com.nestor.market.persistance;

import com.nestor.market.persistance.crud.ProductoCrudRepository;
import com.nestor.market.persistance.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
