package ma.projet.client;

import ma.projet.client.entities.Client;
import ma.projet.client.repositories.ClientRepositroy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ClientRepositroy clientRepositroy) {
        return args -> {
            clientRepositroy.save(new Client( "chaymae",21f));
            clientRepositroy.save(new Client( "lamrabet",24f));
            clientRepositroy.save(new Client( "malak",21f));
        };
    }

}
