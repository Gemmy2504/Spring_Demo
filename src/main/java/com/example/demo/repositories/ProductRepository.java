package com.example.demo.repositories;

import com.example.demo.models.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
    Flux<Product> findAll();
    Mono<Product> findById(String id);

}