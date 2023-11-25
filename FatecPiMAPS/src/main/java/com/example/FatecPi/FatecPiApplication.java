package com.example.FatecPi;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class FatecPiApplication {
    public static void main(String[] args) {
        SpringApplication.run(FatecPiApplication.class, args);
    }
}
