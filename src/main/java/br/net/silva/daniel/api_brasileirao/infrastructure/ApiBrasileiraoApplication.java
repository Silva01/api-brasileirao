package br.net.silva.daniel.api_brasileirao.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"br.net.silva.daniel.api_brasileirao", "br.net.silva.daniel.api_brasileirao.*"})
public class ApiBrasileiraoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiBrasileiraoApplication.class, args);
    }

}
