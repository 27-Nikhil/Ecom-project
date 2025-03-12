package com.example.ecom_proj.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

    private Date releaseDate;
    private boolean productAvailable;
    private int stockQuantity;

    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}


/*
INSERT INTO product (name, desc, brand, price, release_date, quantity)
VALUES
('Tesla Model S', 'Electric luxury sedan with autopilot', 'Tesla', 79999.99, '2024-02-15', 10),
('Ford Mustang GT', 'Muscle car with a V8 engine', 'Ford', 55999.99, '2023-08-10', 15),
('Toyota Corolla', 'Reliable and fuel-efficient sedan', 'Toyota', 24999.99, '2024-01-05', 20),
('BMW X5', 'Luxury SUV with advanced features', 'BMW', 65999.99, '2023-11-20', 8),
('Honda Civic', 'Compact sedan with modern design', 'Honda', 27999.99, '2024-02-01', 18);
 */