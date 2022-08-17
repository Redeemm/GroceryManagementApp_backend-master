package com.nishant.services;

import com.nishant.daos.ItemDao;
import com.nishant.entities.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public Integer deleteItemById(Integer id) {
        return this.itemDao.deleteItemById(id);
    }

    @Override
    public List<ItemEntity> findAllItems() {
        return this.itemDao.findAllItems();
    }

    @Override
    public ItemEntity findById(Integer id) {
        return this.itemDao.findById(id);
    }

    @Override
    public ItemEntity findByName(String name) {
        return this.itemDao.findByName(name);
    }

    @Override
    public Boolean isItemExist(ItemEntity itemEntity) {
        return this.itemDao.isItemExist(itemEntity);
    }

    @Override
    public ItemEntity saveItem(ItemEntity itemEntity) {
        return this.itemDao.saveItem(itemEntity);
    }

    @Override
    public ItemEntity updateItem(ItemEntity itemEntity) {
        return this.itemDao.updateItem(itemEntity);
    }

}
