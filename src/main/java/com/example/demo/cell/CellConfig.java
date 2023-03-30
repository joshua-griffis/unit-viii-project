package com.example.demo.cell;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CellConfig {

    @Bean
    CommandLineRunner commandLineRunner2(CellRepository repository) {
        return args -> {
          Cell cell1 = new Cell(
                  "Cell filled with water",
                  "1",
                  "Safe"
          );
            Cell cell2 = new Cell(
                    "A cell with padded walls",
                    "2",
                    "Not Safe"
            );
          repository.saveAll(
                  List.of(cell1, cell2)
          );
        };
    }
}
