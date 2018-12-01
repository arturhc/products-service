package com.tecgurus.products_service.app.persistence.repository;

import com.tecgurus.products_service.app.persistence.model.Product;
import com.tecgurus.products_service.common.persistence.repository.SoftDeleteRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends SoftDeleteRepository<Product, Long> {

    Optional<Product> findByName(String name);

    List<Product> findByNameIgnoreCaseContaining(String name);

    List<Product> findByCategoryId(Long categoryId);

}
