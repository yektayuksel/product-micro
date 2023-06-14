package com.mealkit.productmicro.dao.entity;

import jakarta.persistence.*;


import java.util.Set;

@Entity
@Table(name = "product")
public class ProductEntity {
    public ProductEntity(Long id, String productName, String description, String recipe, Double price, byte[] image, Set<TagEntity> tagEntities, Set<ProductIngredientEntity> productIngredientEntities) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.recipe = recipe;
        this.price = price;
        this.image = image;
        this.tagEntities = tagEntities;
        this.productIngredientEntities = productIngredientEntities;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "recipe")
    private String recipe;

    @Column(name = "price")
    private Double price;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "product_tag",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<TagEntity> tagEntities;

    public ProductEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Set<TagEntity> getTagEntities() {
        return tagEntities;
    }

    public void setTagEntities(Set<TagEntity> tagEntities) {
        this.tagEntities = tagEntities;
    }

    public Set<ProductIngredientEntity> getProductIngredientEntities() {
        return productIngredientEntities;
    }

    public void setProductIngredientEntities(Set<ProductIngredientEntity> productIngredientEntities) {
        this.productIngredientEntities = productIngredientEntities;
    }

    @OneToMany(mappedBy = "productEntity")
    Set<ProductIngredientEntity> productIngredientEntities;


}