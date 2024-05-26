package Testing.service;

import Testing.entity.User;

public interface UserService {
	public String create(User user);
	
	public boolean check(String email);
	
	public boolean validate(String email,String password);

	public String getRole(String email);

	public User getUser(String email);
}
