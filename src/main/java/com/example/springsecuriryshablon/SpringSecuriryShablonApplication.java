package com.example.springsecuriryshablon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecuriryShablonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecuriryShablonApplication.class, args);
        System.out.println("In test mode, see data console from url: http://localhost:8080/h2-console/");
    }

}
