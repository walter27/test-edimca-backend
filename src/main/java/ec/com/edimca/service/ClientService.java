package ec.com.edimca.service;

import java.util.List;
import java.util.Optional;

import ec.com.edimca.model.Client;

public interface ClientService {

	void save(Client client);

	void deleteById(Long id);

	Optional<Client> findById(Long id);

	List<Client> findAll();

}
