package pl.rafalab.restWithSpring.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.rafalab.restWithSpring.Model.User;
import pl.rafalab.restWithSpring.repositories.UserRepository;

@Service
@Transactional
public class UserServicesImp implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User findUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

	public void saveUser(User user) {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setAvtive(1);
			userRepository.save(user);
	}

}
