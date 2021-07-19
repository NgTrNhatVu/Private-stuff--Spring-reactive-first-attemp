package com.enterprisenao.spring_reactive_no5.service;

import com.enterprisenao.spring_reactive_no5.model.Product;
import com.enterprisenao.spring_reactive_no5.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private final ProductRepository repository;

    public Flux<Product> findAll() {
        return repository.findAll();
    }

    public Mono<Product> findById(String id) {
        return repository.findById(id);
    }

    public Flux<Product> findBy() {
        return repository.findBy();
    }

    public Mono<Product> insert(Product product) {
        return repository.insert(product);
    }

    public Flux<Product> findByName(String name) {
        if (name.equals("")) return repository.findAll();
        return repository.findByName(name);
    }

    public Mono<Product> save(String id, Product product){
        product.setId(id);
        return repository.save(product);
    }
    public Flux<Product> findByNameRegex(String name){
        return repository.findByNameRegex(name);
    }
    public Flux<Product> findByOrderByPriceAsc() {
        return repository.findByOrderByPriceAsc();
    }

    public Flux<Product> findByOrderByPriceDesc() {
        return repository.findByOrderByPriceDesc();
    }

    public Flux<Product> findByNameOrderByPriceAsc(String name) {
        if (name.equals("")) return repository.findByOrderByPriceAsc();
        return repository.findByNameOrderByPriceAsc(name);
    }

    public Flux<Product> findByNameRegexAndOrderByPriceDesc(String name) {
        if (name.equals("")) return repository.findByOrderByPriceDesc();
        return repository.findByNameRegexAndOrderByPriceDesc(name);
    }


}
