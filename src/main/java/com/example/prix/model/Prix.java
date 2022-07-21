package com.example.prix.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name= "prix")
public class Prix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double prix;

    @Column(name= "description")
    private String description;

    @Column(name= "created_at")
    private LocalDateTime createdAt;

    public Prix (double prix, String description){
        this.prix=prix;
        this.description=description;
        this.createdAt=LocalDateTime.now();
    }

    public Prix(){
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
