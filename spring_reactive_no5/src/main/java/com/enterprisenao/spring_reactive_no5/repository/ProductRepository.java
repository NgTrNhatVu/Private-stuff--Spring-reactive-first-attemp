package com.enterprisenao.spring_reactive_no5.repository;

import com.enterprisenao.spring_reactive_no5.model.Product;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

    @Tailable
    Flux<Product> findBy();

    Flux<Product> findByOrderByPriceAsc();

    Flux<Product> findByOrderByPriceDesc();

    Flux<Product> findByNameOrderByPriceAsc(String name);

    @Query("{'name' : { $regex: /.*(?i)(?0).*/ }}")
    Flux<Product> findByNameRegexAndOrderByPriceDesc(String name);

    @Query("{'name' : { $regex: /.*(?i)(?0).*/ }}")
    Flux<Product> findByNameRegex(String name);

    Flux<Product> findByName(String name);
}
