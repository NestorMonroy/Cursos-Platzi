package com.nestor.market.domain.repository;

import com.nestor.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>>  getByClient(String clientId);
    Purchase save(Purchase purchase);

}
