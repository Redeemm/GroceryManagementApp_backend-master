/**
 *
 */
package com.nishant.managers;

import com.nishant.entities.RepoItemEntity;

import java.util.List;

/**
 * @author nishant.b.grover
 *
 */
public interface RepoItemManager {

    List<RepoItemEntity> findAllRepoItems();

    /**
     * @param repoItem
     * @return
     */
    RepoItemEntity saveItem(RepoItemEntity repoItem);

}
