package ec.com.edimca.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.com.edimca.model.UserEdimca;

@Repository
public interface UserRepository extends CrudRepository<UserEdimca, Long> {

	public UserEdimca findByUsername(String username);
}
