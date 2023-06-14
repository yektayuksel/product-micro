package com.mealkit.productmicro.web.response;

import java.math.BigDecimal;

public class IngredientApiOutput {

    private Long id;
    private String name;
    private Double amount;

    public IngredientApiOutput(Long id, String name, Double amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
