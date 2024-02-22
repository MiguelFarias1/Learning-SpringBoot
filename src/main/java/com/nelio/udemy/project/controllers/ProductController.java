package com.nelio.udemy.project.controllers;

import com.nelio.udemy.project.entities.Product;
import com.nelio.udemy.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {

        var list = productService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Product> findById(@PathVariable(name = "id") Long id) {

        var user = productService.findById(id);

        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product product) {

        productService.save(product);

        return ResponseEntity.ok(product);
    }
}
