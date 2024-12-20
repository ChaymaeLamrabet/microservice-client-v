package ma.projet.client.controllers;

import ma.projet.client.entities.Client;
import ma.projet.client.repositories.ClientRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientRepositroy clientRepositroy;

    @GetMapping("/clients")
    public List<Client> findAll() {
        return clientRepositroy.findAll();
    }

    @GetMapping("/client/{id}")
    public Client findById(@PathVariable Long id) throws Exception {
        return clientRepositroy.findById(id)
                .orElseThrow(() -> new Exception("Client non trouver"));
    }
}
