package com.nishant.controllers;

import com.nishant.managers.ItemManager;
import com.nishant.views.ItemView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/GroceryManagementApp/data")
public class ItemController {

    private static final Logger LOGGER = LogManager.getLogger(ItemController.class);

    @Autowired
    private ItemManager itemManager;

    @RequestMapping(value = "/createItem", method = RequestMethod.POST)
    public ResponseEntity<ItemView> createItem(@RequestBody ItemView itemView) {
        LOGGER.debug("Creating Item " + itemView.getName());

        if (this.itemManager.isItemExist(itemView)) {
            LOGGER.debug("A Item with name " + itemView.getName() + " already exist");
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }

        itemView = this.itemManager.saveItem(itemView);

        return new ResponseEntity<>(itemView, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/deleteItem/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Integer> deleteItem(@PathVariable("id") Integer id) {
        LOGGER.debug("Fetching & Deleting Item with id " + id);

        ItemView itemView = this.itemManager.findById(id);
        if (itemView == null) {
            LOGGER.debug("Unable to delete. Item with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Integer deletedCountInteger = this.itemManager.deleteItemById(id);
        LOGGER.debug("Number of Ztems deleted :" + deletedCountInteger);
        return new ResponseEntity<>(deletedCountInteger, HttpStatus.OK);
    }


    @RequestMapping(value = "/listAllItems", method = RequestMethod.GET)
    public ResponseEntity<List<ItemView>> listAllItems(@RequestHeader HttpHeaders header) {
        LOGGER.debug(header.get(HttpHeaders.USER_AGENT).toString());
        List<ItemView> items = this.itemManager.findAllItems();
        LOGGER.debug("fetched " + items.size() + " items.");
        if (items.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(items, HttpStatus.OK);
    }


    @RequestMapping(value = "/updateItem/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ItemView> updateItem(@PathVariable("id") Integer id, @RequestBody ItemView itemView) {
        LOGGER.debug("Updating Item " + id);

        ItemView currentItem = this.itemManager.findById(id);

        if (currentItem == null) {
            LOGGER.debug("Item with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        this.itemManager.updateItem(itemView);
        return new ResponseEntity<>(itemView, HttpStatus.OK);
    }

}
