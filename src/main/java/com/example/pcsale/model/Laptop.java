package com.example.pcsale.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// HP ProBook x360 G8:

// Display: 14-inch FHD (1920 x 1080) resolution.
// Processor: AMD Ryzen 7 5700U.
// Storage: 512GB SSD.
// RAM: 16GB DDR4.
// Keyboard: Backlit.
// Condition: Excellent.
// Price: 8.5k.
@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String name;
    private String processor;
    private String storage;
    private String ram;
    private String additionalFeatures;

    @Column(name = "condition_col")
    private String condition;
    private Double price;

    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;

    // Constructors
    public Laptop() {
    }

    public Laptop(String brand, String name, String processor, String storage, String ram, String additionalFeatures,
            String condition, Double price, byte[] image) {
        this.brand = brand;
        this.name = name;
        this.processor = processor;
        this.storage = storage;
        this.ram = ram;
        this.additionalFeatures = additionalFeatures;
        this.condition = condition;
        this.price = price;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getAdditionalFeatures() {
        return additionalFeatures;
    }

    public void setAdditionalFeatures(String additionalFeatures) {
        this.additionalFeatures = additionalFeatures;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

}
