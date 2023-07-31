package com.atwop.katanga.movement.model;

public class MovementResponseModel {
    private String id;
    private Float amount;

    public MovementResponseModel(String id, Float amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public Float getAmount() {
        return amount;
    }
}
