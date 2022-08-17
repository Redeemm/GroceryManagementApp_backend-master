package com.nishant.entities;

import com.nishant.interfaces.ItemInterface;
import com.nishant.views.ItemView;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ITEM")
public class ItemEntity implements ItemInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SHELF_LIFE")
    private String shelfLife;

    @Column(name = "STORAGE_STATE", nullable = false)
    private String storageState;

    @Column(name = "PURCHASE_DATE", nullable = false)
    private Date purchaseDate;

    @Column(name = "EXPIRY_DATE")
    private Date expiryDate;

    /**
     *
     */
    public ItemEntity() {
        // Default Constructor
    }

    public ItemEntity(ItemView itemView) {
        BeanUtils.copyProperties(itemView, this, ItemInterface.class);
    }

    @Override
    public Date getExpiryDate() {
        return this.expiryDate;
    }

    @Override
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Date getPurchaseDate() {
        return this.purchaseDate;
    }

    @Override
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String getShelfLife() {
        return this.shelfLife;
    }

    @Override
    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    @Override
    public String getStorageState() {
        return this.storageState;
    }

    @Override
    public void setStorageState(String storageState) {
        this.storageState = storageState;
    }
}
