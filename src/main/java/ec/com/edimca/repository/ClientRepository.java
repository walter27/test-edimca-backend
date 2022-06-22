package ec.com.edimca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.edimca.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
