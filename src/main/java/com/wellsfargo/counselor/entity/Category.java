package com.wellsfargo.counselor.entity;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "cat_name", length = 100, nullable = false, unique = true)
    private String catName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Security> securities = new ArrayList<>();

    public Category() {}

    public Category(String catName) {
        this.catName = catName;
    }

    // Getters and setters
    public Integer getCategoryId() { return categoryId; }
    public String getCatName() { return catName; }
    public void setCatName(String catName) { this.catName = catName; }
    public List<Security> getSecurities() { return securities; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }
}