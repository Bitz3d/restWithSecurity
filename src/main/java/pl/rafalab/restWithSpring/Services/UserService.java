package pl.rafalab.restWithSpring.Services;

import pl.rafalab.restWithSpring.Model.User;

public interface UserService {

	public User findUserByEmail(String email);
	public void saveUser(User user);
}
