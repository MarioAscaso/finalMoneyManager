package com.daw.finalmoneymanager;

import com.daw.finalmoneymanager.shared.storagefiles.domain.interfaces.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinalmoneymanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalmoneymanagerApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (String[] args) -> storageService.init();
    }

}
