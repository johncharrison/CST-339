package com.gcu.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "USERS_ID")
    long users_id;

    @Column(name = "PRODUCTS_ID")
    long products_id;

    int quantity;

    boolean completed;

    @Column(name = "CREATED_DATE")
    Date created_date;

    @Column(name = "MODIFIED_DATE")
    Date modified_date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    public long getProducts_id() {
        return products_id;
    }

    public void setProducts_id(long products_id) {
        this.products_id = products_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getModified_date() {
        return modified_date;
    }

    public void setModified_date(Date modified_date) {
        this.modified_date = modified_date;
    }

    @PrePersist
    protected void onCreate() {
        this.created_date = new Date();
        this.modified_date = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.modified_date = new Date();
    }

}
