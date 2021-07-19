package com.enterprisenao.spring_reactive_no5.controller;

import com.enterprisenao.spring_reactive_no5.model.Product;
import com.enterprisenao.spring_reactive_no5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public Flux<Product> findAll() {
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    public Mono<Product> findAll(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @GetMapping(path = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> findBy() {
        return service.findBy();
    }

    @GetMapping(path = "/s={name}")
    public Flux<Product> findByName(@PathVariable("name") String name) {
        return service.findByNameRegex(name);
    }

    @PutMapping(path = "/{id}")
    public Mono<Product> save(@PathVariable("id") String id, @RequestBody Product product){
        try{
            return service.save(id, product);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(path = "/ord=asc")
    public Flux<Product> findByOrderByPriceAsc() {
        return service.findByOrderByPriceAsc();
    }

    @GetMapping(path = "/ord=desc")
    public Flux<Product> findByOrderByPriceDesc() {
        return service.findByOrderByPriceDesc();
    }

    @GetMapping(path = "/s={name}&ord=asc")
    public Flux<Product> findByNameOrderByPriceAsc(@PathVariable("name") String name){
        return service.findByNameOrderByPriceAsc(name);
    }

    @GetMapping(path = "/s={name}&ord=desc")
    public Flux<Product> findByNameRegexAndOrderByPriceDesc(@PathVariable("name") String name){
        return service.findByNameRegexAndOrderByPriceDesc(name);
    }

    @PostMapping
    public Mono<Product> insert(@RequestBody Product product) {
        return service.insert(product);
    }
}
