package com.mealkit.productmicro.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class ProductEntity {

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
    private String imageUrl;

    @Column(name = "cooking_time")
    private Integer cookingTime;

    @Column(name = "calories")
    private Long calories;

    @Column(name = "difficulty")
    private String difficulty;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "Product_Tag",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<TagEntity> tags;


    @OneToMany(mappedBy = "product")
    private Set<ProductIngredientEntity> ingredients;




}