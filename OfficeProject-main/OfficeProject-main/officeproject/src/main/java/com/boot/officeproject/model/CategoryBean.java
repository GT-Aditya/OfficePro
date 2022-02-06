package com.boot.officeproject.model;

import java.time.LocalDate;

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
    private LocalDate createDate;
    private LocalDate updateDate;

    public CategoryBean() {
    }

    public CategoryBean(String name, String categoryCode, boolean disContinue, LocalDate createDate, LocalDate updateDate) {
        this.name = name;
        this.categoryCode = categoryCode;
        this.disContinue = disContinue;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
    

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
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
