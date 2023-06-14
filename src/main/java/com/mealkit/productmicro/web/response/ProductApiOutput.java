package com.mealkit.productmicro.web.response;

import com.mealkit.productmicro.domain.dto.TagDto;

import java.util.Set;

public class ProductApiOutput {

    private Long id;
    private String productName;
    private String description;
    private byte[] image;
    private String recipe;

    public ProductApiOutput(Long id, String productName, String description, byte[] image, String recipe, Double price, Set<TagDto> tags) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.image = image;
        this.recipe = recipe;
        this.price = price;
        this.tags = tags;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

    public Set<TagDto> getTags() {
        return tags;
    }

    public void setTags(Set<TagDto> tags) {
        this.tags = tags;
    }

    private Double price;
    private Set<TagDto> tags;
}
