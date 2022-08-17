/**
 *
 */
package com.nishant.controllers;

import com.nishant.entities.RepoItemEntity;
import com.nishant.managers.RepoItemManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nishant.b.grover
 *
 */
@RestController
@RequestMapping(value = "/GroceryManagementApp/repo")
public class RepoItemController {

    private static final Logger LOGGER = LogManager.getLogger(RepoItemController.class);

    @Autowired
    private RepoItemManager repoItemManager;


    @RequestMapping(value = "/addRepoItem", method = RequestMethod.POST)
    public ResponseEntity<RepoItemEntity> addRepoItem(@RequestBody RepoItemEntity repoItemEntity) {
        repoItemEntity = this.repoItemManager.saveItem(repoItemEntity);
        return new ResponseEntity<>(repoItemEntity, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/listAllRepoItems", method = RequestMethod.GET)
    public ResponseEntity<List<RepoItemEntity>> listAllRepoItems() {
        List<RepoItemEntity> repoItems = this.repoItemManager.findAllRepoItems();
        LOGGER.debug(String.valueOf(repoItems.size()));
        return new ResponseEntity<>(repoItems, HttpStatus.OK);
    }

}
