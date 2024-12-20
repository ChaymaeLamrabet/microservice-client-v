package ma.projet.client.repositories;

import ma.projet.client.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepositroy extends JpaRepository<Client, Long> {
}
