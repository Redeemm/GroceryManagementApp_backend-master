/**
 *
 */
package com.nishant.services;

import com.nishant.daos.RepoItemDao;
import com.nishant.entities.RepoItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author nishant.b.grover
 *
 */
@Service
@Transactional
public class RepoItemServiceImpl implements RepoItemService {

    @Autowired
    private RepoItemDao repoItemDao;

    @Override
    public List<RepoItemEntity> findAllRepoItems() {
        return this.repoItemDao.findAllRepoItems();
    }

    @Override
    public RepoItemEntity saveRepoItem(RepoItemEntity repoItem) {
        return this.repoItemDao.saveRepoItem(repoItem);
    }

}
