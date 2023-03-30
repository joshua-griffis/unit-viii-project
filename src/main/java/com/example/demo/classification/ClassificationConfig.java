package com.example.demo.classification;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClassificationConfig {
    @Bean
    CommandLineRunner commandLineRunner3(ClassificationRepository repository) {
        return args -> {
            Classification safe = new Classification(
                    "Safe"
            );
            Classification euclid = new Classification(
                    "Euclid"
            );
            Classification keter = new Classification(
                    "Keter"
            );
            repository.saveAll(
                    List.of(safe, euclid, keter)
            );
        };
    }
}
