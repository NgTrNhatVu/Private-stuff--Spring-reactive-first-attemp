package com.enterprisenao.spring_reactive_no5.controller;

import com.enterprisenao.spring_reactive_no5.model.Admin;
import com.enterprisenao.spring_reactive_no5.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequestMapping("/admin")

@RestController
public class AdminController {
    @Autowired
    private AdminService service;

    @GetMapping
    public Flux<Admin> findAll(){
        return service.findAll();
    }

    @GetMapping(path = "/stream")
    public Flux<Admin> findBy(){
        return service.findBy();
    }
}
