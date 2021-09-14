package com.nestor.market.persistance.crud;

import com.nestor.market.persistance.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    //@Query(value = "select * from produtos where id_categoria = ?", nativeQuery = true)
    List<Producto> findByIdCategoriaOOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndAndEstado(int cantidadStock, boolean estado);
}
