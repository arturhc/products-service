package com.tecgurus.products_service.app.service;

import com.tecgurus.products_service.app.dto.product.ProductDTO;
import com.tecgurus.products_service.app.dto.product.alter.ProductDeletedDTO;
import com.tecgurus.products_service.app.dto.product.alter.ProductUpdateDTO;
import com.tecgurus.products_service.app.dto.product.create.ProductCreateDTO;
import com.tecgurus.products_service.app.dto.product.create.ProductCreatedDTO;
import com.tecgurus.products_service.app.persistence.model.Product;
import com.tecgurus.products_service.app.persistence.repository.ProductRepository;
import com.tecgurus.products_service.common.config.exception.model.ValidationException;
import com.tecgurus.products_service.common.service.BaseService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

import static com.tecgurus.products_service.common.util.EventMessage.*;

@Service
public class ProductService extends BaseService<ProductRepository, Product> {

    public ProductDTO findProductById(Long productId) throws Exception {
        return findById(productId, ProductDTO.class);
    }

    public ProductDTO findProductByName(String name) throws ValidationException {

        Optional<Product> product = repository.findByName(name);

        return convertUtil.convert(product.orElseThrow(() ->
                new ValidationException(NON_EXISTENT_PRODUCT, name)), ProductDTO.class);
    }

    public List<ProductDTO> findProductByCategoryId(Long categoryId) {

        List<Product> products = repository.findByCategoryId(categoryId);

        return convertUtil.convert(products, ProductDTO.class);
    }

    public List<ProductDTO> findAllProducts() {
        return findAll(ProductDTO.class);
    }

    public List<ProductDTO> findProductsByName(String name) {

        List<Product> products = repository.findByNameIgnoreCaseContaining(name);

        return convertUtil.convert(products, ProductDTO.class);
    }

    public ProductCreatedDTO createProduct(ProductCreateDTO productCreateDTO) throws Exception {
        try {
            return convertUtil.convert(findProductByName(productCreateDTO.getName()), ProductCreatedDTO.class);
        } catch (ValidationException ex) {
            return save(productCreateDTO, ProductCreatedDTO.class);
        }
    }

    public ProductCreatedDTO updateProduct(ProductUpdateDTO productUpdateDTO, boolean partialUpdate) throws Exception {
        return update(productUpdateDTO.getId(), productUpdateDTO, ProductCreatedDTO.class, partialUpdate);
    }

    public ProductDeletedDTO deleteProduct(Long productId) throws Exception {
        return delete(productId, ProductDeletedDTO.class, false);
    }

    public ProductDTO findProduct(Long productId) throws Exception {

        try {
            return this.findProductById(productId);
        } catch (EntityNotFoundException ex) {
            throw new ValidationException(INVALID_PRODUCT);
        }

    }

}
