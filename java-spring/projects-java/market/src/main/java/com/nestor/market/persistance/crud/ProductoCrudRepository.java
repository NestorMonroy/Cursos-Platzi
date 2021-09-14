package com.nestor.market.persistance.crud;

import com.nestor.market.persistance.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

}
