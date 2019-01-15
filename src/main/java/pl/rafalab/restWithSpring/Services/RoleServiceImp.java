package pl.rafalab.restWithSpring.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.rafalab.restWithSpring.Model.Role;
import pl.rafalab.restWithSpring.repositories.RoleRepository;


@Service
@Transactional
public class RoleServiceImp implements RoleService {

	@Autowired
	private RoleRepository roleRepo;

	public List<Role> findAll() {
		return roleRepo.findAll();
	}

}
