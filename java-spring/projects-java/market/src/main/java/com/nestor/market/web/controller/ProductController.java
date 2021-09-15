package com.nestor.market.web.controller;

import com.nestor.market.domain.Product;
import com.nestor.market.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Controlador de una API REST
@RequestMapping("/products")
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    @ApiOperation("Get all supermarket products")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a product with an ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not found"),
    })
    public ResponseEntity<Product> getProduct(@ApiParam(value = "The id of the product", required = true, example = "7")
                                              @PathVariable("id") int productId) {
        //Cuando se regresa un OPTIONAL, se puede trabajar con el operador map
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

//    @GetMapping("/category/{categoryId}")
//    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
//        return productService.getByCategory(categoryId)
//                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }


    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
        final Optional<List<Product>> products = productService.getByCategory(categoryId);
        if (products.isPresent() && !products.get().isEmpty())
            return new ResponseEntity<>(products.get(), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

//    @DeleteMapping("/delete/{productId}")
//    public ResponseEntity<> delete(@PathVariable("productId") int productId) {
//        if (productService.delete(productId)) {
//            new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity delete(@PathVariable("productId") int productId) {
        ResponseEntity response = productService.delete(productId) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
        return response;
    }


//    @PutMapping(value = "/update/{productId}")
//    public ResponseEntity<Product> update(@PathVariable("productId") int productId, @RequestBody Product product) {
//        if (productService.getProduct(productId) == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<>(productService.update(productId, product), HttpStatus.OK);
//        }
//    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }

//    @PutMapping("/update/{productId}")
//    public Product update(@RequestBody Product product, @PathVariable("productId") int productId) {
//        return productService.getProduct(productId)
//                .map(product1 -> {
//                    product1.setName(product.getName());
//                    product1.setCategoryId(product.getCategoryId());
//                    product1.setPrice(product.getPrice());
//                    product1.setStock(product.getStock());
//                    product1.setActive(product.isActive());
//                    return productService.save(product1);
//                }).orElseGet(() -> {
//                    product.setProductId(productId);
//                    return productService.save(product);
//                });
//    }

}
