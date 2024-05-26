package Testing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Testing.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Integer> {

	List<Property> findBySellerEmail(String sellerEmail);

	List<Property> findByPropertyName(String propertyName);

}
