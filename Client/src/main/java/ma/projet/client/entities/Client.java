package ma.projet.client.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Float age;

    // Constructeur par défaut
    public  Client() {
    }

    // Constructeur avec paramètres
    public Client(String nom, float age) {
        this.nom = nom;
        this.age = age;
    }

    // Getters et Setters pour chaque champ
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnom() {
        return nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    // Vous pouvez également ajouter toString(), equals() et hashCode() si nécessaire
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Float.compare(client.age, age) == 0 &&
                id.equals(client.id) &&
                nom.equals(client.nom);
    }

    @Override
    public int hashCode() {
        return 31 * id.hashCode() + nom.hashCode() + Float.hashCode(age);
    }

}
