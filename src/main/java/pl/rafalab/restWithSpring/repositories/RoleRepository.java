package pl.rafalab.restWithSpring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.rafalab.restWithSpring.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByRole(String Role);
	public List<Role> findAll();
	
}
