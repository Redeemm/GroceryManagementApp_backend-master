/**
 *
 */
package com.nishant.services;

import com.nishant.entities.RepoItemEntity;

import java.util.List;

/**
 * @author nishant.b.grover
 *
 */
public interface RepoItemService {

    List<RepoItemEntity> findAllRepoItems();

    /**
     * @param repoItem
     * @return
     */
    RepoItemEntity saveRepoItem(RepoItemEntity repoItem);

}
