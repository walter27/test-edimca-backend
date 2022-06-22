package ec.com.edimca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.edimca.model.Client;
import ec.com.edimca.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;

	@Override
	public void save(Client client) {
		clientRepository.save(client);
	}

	@Override
	public void deleteById(Long id) {
		clientRepository.deleteById(id);
	}

	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Optional<Client> findById(Long id) {
		return clientRepository.findById(id);
	}

}
