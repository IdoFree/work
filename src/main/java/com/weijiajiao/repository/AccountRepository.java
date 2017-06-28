package com.weijiajiao.repository;

import com.weijiajiao.model.table.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by junli on 2017/6/1.
 */
public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByOpenId(String openId);
}
