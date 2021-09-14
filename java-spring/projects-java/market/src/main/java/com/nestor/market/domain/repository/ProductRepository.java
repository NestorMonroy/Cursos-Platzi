package com.nestor.market.domain.repository;

import com.nestor.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    /*
        Siempre hablar en terminos de dominio ya que esto nos ayuda a
        * No exponer la base de datos en el API
        * Desacoplar nuestra API a una base de datos puntual
        * No tener campos innecesarios en el API
        * Sin mezclar idiomas en el dominio
     */

    List<Product> getAll();

    Optional<List<Product>> getByCategory(int categoryId);

    Optional<List<Product>> getScarseProducts(int quantity);

    Optional<List<Product>> getProduct(int productId);

    Product save(Product product);

    void delete(int productId);

}
