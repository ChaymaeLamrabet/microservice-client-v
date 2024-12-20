package ma.projet.voiture.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricule;
    private String marque;
    private String model;
    private String annee;
    private Long clientId;

    @Transient
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    public Voiture() {
    }

    // Constructeur avec paramètres pour création nouvelle voiture
    public Voiture(String matricule, String marque, String modele, String annee, Client client) {
        this.matricule = matricule;
        this.marque = marque;
        this.model = modele;
        this.annee = annee;
        this.client = client;
        this.clientId = client != null ? client.getId() : null;
    }

    // Constructeur complet avec ID
    public Voiture(Long id, String matricule, String marque, String modele, String annee, Long clientId, Client client) {
        this.id = id;
        this.matricule = matricule;
        this.marque = marque;
        this.model = modele;
        this.annee = annee;
        this.clientId = clientId;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }
}
