package com.boot.officeproject.model.categorymodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class CategoryBean {
    

    private String name;
    @Id
    private String categoryCode;
    private boolean disContinue;

    public CategoryBean() {
    }

    public CategoryBean(String name, String categoryCode, boolean disContinue) {
        this.name = name;
        this.categoryCode = categoryCode;
        this.disContinue = disContinue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public boolean isDisContinue() {
        return disContinue;
    }

    public void setDisContinue(boolean disContinue) {
        this.disContinue = disContinue;
    }
    
}
