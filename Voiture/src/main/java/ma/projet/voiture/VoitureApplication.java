package ma.projet.voiture;

import ma.projet.voiture.entities.Client;
import ma.projet.voiture.entities.Voiture;
import ma.projet.voiture.feign.ClientService;
import ma.projet.voiture.repositories.VoitureRepository;
import ma.projet.voiture.services.VoitureService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class VoitureApplication {
    private final ClientService clientService;

    public VoitureApplication(ClientService clientService) {
        this.clientService = clientService;
    }
    public static void main(String[] args) {
        SpringApplication.run(VoitureApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(VoitureRepository voitureRepository, VoitureService voitureService) {
        return args -> {
            try {
                // Récupération du client via Feign
                Client c1 = clientService.clientById(1L);
                Client c2 = clientService.clientById(3L);
                System.out.println("******************************");
                System.out.println("Id est : " + c2.getId());
                System.out.println("Nom est : " + c2.getNom());
                System.out.println("******************************");
                System.out.println("******************************");
                System.out.println("Id est : " + c1.getId());
                System.out.println("Nom est : " + c1.getNom());
                System.out.println("Age est : " + c1.getAge());
                System.out.println("******************************");
                voitureService.save(new Voiture(  "A 25 333", "Corolla","Toyota", "2024", c2));
                voitureService.save(new Voiture(  "B 6 3456", "Megane","Renault", "2025", c2));
                voitureService.save(new Voiture( "A 55 4444","Peugeot",  "301", "2023", c1));
            } catch (Exception e) {
                System.err.println("Erreur lors de l'initialisation des données: " + e.getMessage());
            }
        };
        //p14
    }

}
