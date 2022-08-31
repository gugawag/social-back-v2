package br.edu.ifpb.gugawag.socialback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SocialBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialBackApplication.class, args);
    }

}
