package Testing.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Testing.entity.Property;
import Testing.entity.User;
import Testing.repository.PropertyRepository;
import Testing.repository.UserRepository;

@Service
public class serviceP implements PropertyService{
	@Autowired
	PropertyRepository prep;
	
	@Autowired
	UserRepository urep;

	@Override
	public String create(Property p) {
		prep.save(p);
		System.out.println("property saved in rep");
		return "saved";
	}

	@Override
	public List<Property> display() {
		List<Property> prt = prep.findAll();
		return prt;
	}

	@Override
	public void delete(Property p, String name) {
	    List<Property> property = prep.findByPropertyName(name);
	    if(property!=null && property.equals(p)) 
	    {	      
	            prep.delete(p);	        
	    }
	}

	@Override
	public List<Property> getSellerProperties(String sellerEmail) {
		return prep.findBySellerEmail(sellerEmail);
		
	}

}
