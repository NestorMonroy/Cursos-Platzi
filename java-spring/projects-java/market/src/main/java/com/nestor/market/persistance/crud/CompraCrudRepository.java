package com.nestor.market.persistance.crud;

import com.nestor.market.persistance.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//Al extends de  CrudRepository recibe el nombre del entity y el tipo de valor de su llave primaria
public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {
    Optional<List<Compra>> findByIdCliente(String idCliente);
}
