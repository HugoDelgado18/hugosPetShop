package com.hugosPetShop.petShop.springboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Pet {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private Integer age;
    private String breed;
    private Integer price;
    private boolean available;

    public Pet(long id, String name, Integer age, String breed, Integer price, boolean available) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.price = price;
        this.available = available;
    }

    public Pet() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}
