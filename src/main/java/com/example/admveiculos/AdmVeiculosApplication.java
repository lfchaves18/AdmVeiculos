package com.example.admveiculos;

import com.example.admveiculos.config.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;



@EntityScan(basePackages = {"com.example.admveiculos.entity"})
@SpringBootApplication
@Import(JpaConfiguration.class)
public class AdmVeiculosApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdmVeiculosApplication.class, args);
    }

}
