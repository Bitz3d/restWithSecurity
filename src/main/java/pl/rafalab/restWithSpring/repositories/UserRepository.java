package pl.rafalab.restWithSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.rafalab.restWithSpring.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email); 
	
}
