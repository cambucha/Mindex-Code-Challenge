package com.mindex.challenge;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

@Configuration
public interface CompensationRepository extends MongoRepository<Compensation, String> {

    @Bean
    Optional<Compensation> findCompensationByEmployee(String employee);

}
