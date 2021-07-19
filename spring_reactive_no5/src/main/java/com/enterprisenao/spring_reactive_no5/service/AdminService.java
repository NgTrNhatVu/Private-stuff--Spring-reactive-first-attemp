package com.enterprisenao.spring_reactive_no5.service;

import com.enterprisenao.spring_reactive_no5.model.Admin;
import com.enterprisenao.spring_reactive_no5.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class AdminService {
    @Autowired
    private final AdminRepository repository;

    public Flux<Admin> findAll() {
        return repository.findAll();
    }

    public Flux<Admin> findBy() {
        return repository.findBy();
    }
}
