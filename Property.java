package Testing.entity;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Transient
     MultipartFile propertyImage;
     String propertyName;
     String location;
     double area;
     int bedrooms;
     int bathrooms;
     String nearbyFacilities;
     double price; // New attribute to represent the price of the property

    @ManyToOne
    private User seller;

    // Constructors
    public Property() {
        // Default constructor
    }

    public Property(int id, MultipartFile propertyImage, String propertyName, String location, double area, int bedrooms,
                    int bathrooms, String nearbyFacilities, double price, User seller) {
        this.id = id;
        this.propertyImage = propertyImage;
        this.propertyName = propertyName;
        this.location = location;
        this.area = area;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.nearbyFacilities = nearbyFacilities;
        this.price = price;
        this.seller = seller;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MultipartFile getPropertyImage() {
        return propertyImage;
    }

    public void setPropertyImage(MultipartFile propertyImage) {
        this.propertyImage = propertyImage;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getNearbyFacilities() {
        return nearbyFacilities;
    }

    public void setNearbyFacilities(String nearbyFacilities) {
        this.nearbyFacilities = nearbyFacilities;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    // toString method
    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", propertyImage=" + propertyImage +
                ", propertyName='" + propertyName + '\'' +
                ", location='" + location + '\'' +
                ", area=" + area +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                ", nearbyFacilities='" + nearbyFacilities + '\'' +
                ", price=" + price +
                ", seller=" + seller +
                '}';
    }
}
