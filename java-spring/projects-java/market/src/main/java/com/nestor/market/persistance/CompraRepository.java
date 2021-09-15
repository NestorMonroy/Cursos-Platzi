package com.nestor.market.persistance;

import com.nestor.market.domain.Purchase;
import com.nestor.market.domain.repository.PurchaseRepository;
import com.nestor.market.persistance.crud.CompraCrudRepository;
import com.nestor.market.persistance.entity.Compra;
import com.nestor.market.persistance.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Es un repositorio que interactua con la base de datos
public class CompraRepository implements PurchaseRepository {
    //Al implements PurchaseRepository, generamos todos los métodos
    @Autowired
    private CompraCrudRepository compraCrudRepository;

    //se inyecta el mapper para que el repositorio hable en terminos de dominio
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    // Se crea un query method dentro de CompraCrudRepository
    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                //.map sirve para operar lo que viene dentro del Optional, si no viene
                // nada dentro del map no se ejecuta
                // lo queremos convertir a toPurchases
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        //Primero se convierte en compra
        Compra compra = mapper.toCompra(purchase);
        //Garantizar que la información se guarda en cascada
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        //Va a retornar el resultado del mapelo
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
