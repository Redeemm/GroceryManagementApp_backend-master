package com.nishant.interfaces;

import java.util.Date;

public interface ItemInterface {

    Date getExpiryDate();

    void setExpiryDate(Date expiryDate);

    Integer getId();

    void setId(Integer id);

    String getName();

    void setName(String name);

    Date getPurchaseDate();

    void setPurchaseDate(Date purchaseDate);

    String getShelfLife();

    void setShelfLife(String shelfLife);

    String getStorageState();

    void setStorageState(String storageState);

}
