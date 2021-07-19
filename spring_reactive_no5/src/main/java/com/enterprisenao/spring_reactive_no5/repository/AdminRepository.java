package com.enterprisenao.spring_reactive_no5.repository;

import com.enterprisenao.spring_reactive_no5.model.Admin;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AdminRepository extends ReactiveMongoRepository<Admin, String> {

    @Tailable
    public Flux<Admin> findBy();
}
