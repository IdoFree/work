package com.weijiajiao.repository;

import com.weijiajiao.model.table.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by junli on 2017/6/1.
 */
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
    UserInfo findByAccountId(Long accountId);
}
