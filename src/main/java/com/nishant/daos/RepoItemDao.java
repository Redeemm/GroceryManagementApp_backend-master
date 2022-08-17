/**
 *
 */
package com.nishant.daos;

import com.nishant.entities.RepoItemEntity;

import java.util.List;

/**
 * @author nishant.b.grover
 *
 */
public interface RepoItemDao {

    List<RepoItemEntity> findAllRepoItems();

    /**
     * @param repoItem
     * @return
     */
    RepoItemEntity saveRepoItem(RepoItemEntity repoItem);

}
