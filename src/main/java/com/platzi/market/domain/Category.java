package com.platzi.market.domain;

public class Category {

    private int cateforyId;
    private String category;
    private boolean active;

    public int getCateforyId() {
        return cateforyId;
    }

    public void setCateforyId(int cateforyId) {
        this.cateforyId = cateforyId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

