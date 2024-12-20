package ma.projet.voiture.services;

import ma.projet.voiture.entities.Voiture;
import ma.projet.voiture.feign.ClientService;
import ma.projet.voiture.repositories.VoitureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VoitureService {
    private final VoitureRepository voitureRepo;

    private final ClientService clientService;

    public VoitureService(VoitureRepository voitureRepo, ClientService clientService) {
        this.voitureRepo = voitureRepo;
        this.clientService = clientService;
    }

    public List<Voiture> findAll() {
        List<Voiture> voitures = voitureRepo.findAll();
        voitures.forEach(voiture -> {
            try {
                voiture.setClient(clientService.clientById(voiture.getClientId()));
            } catch (Exception e) {
                // Log l'erreur mais continue le traitement
                System.err.println("Erreur lors de la récupération du client " + voiture.getClientId() + ": " + e.getMessage());
            }
        });
        return voitures;
    }


    public Optional<Voiture> findById(Long id) {
        Optional<Voiture> voiture = voitureRepo.findById(id);
        voiture.ifPresent(v -> {
            try {
                v.setClient(clientService.clientById(v.getClientId()));
            } catch (Exception e) {
                System.err.println("Erreur lors de la récupération du client pour la voiture " + id + ": " + e.getMessage());
            }
        });
        return voiture;
    }

    public List<Voiture> findByClientId(Long clientId) {
        return voitureRepo.findAll().stream()
                .filter(voiture -> clientId.equals(voiture.getClientId()))
                .map(voiture -> {
                    try {
                        voiture.setClient(clientService.clientById(clientId));
                    } catch (Exception e) {
                        System.err.println("Erreur lors de la récupération du client " + clientId + ": " + e.getMessage());
                    }
                    return voiture;
                })
                .collect(Collectors.toList());
    }

    public Voiture save(Voiture voiture) {
        if (voiture.getClient() != null) {
            voiture.setClientId(voiture.getClient().getId());
        }

        Voiture savedVoiture = voitureRepo.save(voiture);

        try {
            if (savedVoiture.getClientId() != null) {
                savedVoiture.setClient(clientService.clientById(savedVoiture.getClientId()));
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération du client après sauvegarde: " + e.getMessage());
        }

        return savedVoiture;
    }


    public void deleteById(Long id) {
        voitureRepo.deleteById(id);
    }

    public Voiture update(Long id, Voiture voiture) {
        if (voitureRepo.existsById(id)) {
            voiture.setId(id);
            return save(voiture);
        }
        return null;
    }
}