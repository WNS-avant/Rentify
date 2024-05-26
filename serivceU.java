package Testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Testing.entity.User;
import Testing.repository.UserRepository;



@Service
public class serivceU implements UserService{
	
	@Autowired
	UserRepository urep;

	@Override
	public String create(User u) {
		urep.save(u);
		return "all Set";
	}

	@Override
	public boolean check(String email) {
		if(urep.findByEmail(email)==null)
		{
			return false;
		}
		else 
			{return true;}
			
	}

	@Override
	public boolean validate(String email, String password) {
	    User user = urep.findByEmail(email);
	   
	    if (user != null && user.getPassword().equals(password)) {
	        return true;
	    } else {
	        return false;
	    }
	}

	
	@Override
	public String getRole(String email) 
	{
	    User user = urep.findByEmail(email);
	    if (user != null) {
	        String role = user.getRole();
	        System.out.println("Role: " + role);
	        return role;
	    } else {
	        System.out.println("User not found for email: " + email);
	        return null;
	    }
	}

	@Override
	public User getUser(String email) {
		return urep.findByEmail(email);	
		}


}
