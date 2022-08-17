package com.nishant.managers;

import com.nishant.views.ItemView;

import java.util.List;

public interface ItemManager {

    Integer deleteItemById(Integer id);

    List<ItemView> findAllItems();

    ItemView findById(Integer id);

    ItemView findByName(String name);

    Boolean isItemExist(ItemView item);

    ItemView saveItem(ItemView item);

    void updateItem(ItemView item);

}