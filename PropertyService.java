package Testing.service;

import java.util.List;

import Testing.entity.Property;

public interface PropertyService {
	
	public String create(Property p);
	
	public List<Property> display();
	
	void delete(Property p,String name);

	List<Property> getSellerProperties(String email);




}
