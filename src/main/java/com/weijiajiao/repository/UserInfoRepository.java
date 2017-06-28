package com.weijiajiao.repository;

import com.weijiajiao.model.table.UserInfo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by junli on 2017/6/1.
 */
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
	 @Query(value = "select u from UserInfo u where u.account.openId = :openid")
	 UserInfo findUserInfoByOpenId(@Param("openid") String openid);
}
