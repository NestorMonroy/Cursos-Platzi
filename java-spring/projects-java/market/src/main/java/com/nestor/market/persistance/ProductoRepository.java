package com.nestor.market.persistance;

import com.nestor.market.domain.Product;
import com.nestor.market.domain.repository.ProductRepository;
import com.nestor.market.persistance.crud.ProductoCrudRepository;
import com.nestor.market.persistance.entity.Producto;
import com.nestor.market.persistance.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Indicando que tipo de repository en especifico es a spring que esta clase interactua con la base de datos
// @Component //Generalizacion
public class ProductoRepository implements ProductRepository {
    @Autowired //se sede el, control a spring para crear las instancias de los objetos, inyección de dependencias
    private ProductoCrudRepository productoCrudRepository;
    @Autowired // Se debe de estar seguro que el objecto sea un componente de Spring
    //Nota para usar el @Autowired los objectos deben de heredar de spring
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productosByCategory = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productosByCategory));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productosScarse = productoCrudRepository.findByCantidadStockLessThanAndAndEstado(quantity, true);
        return productosScarse.map(products -> mapper.toProducts(products)); //.map retorna un optional
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(product -> mapper.toProduct(product));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }


    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
