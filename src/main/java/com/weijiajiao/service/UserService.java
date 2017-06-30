package com.weijiajiao.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.weijiajiao.model.table.UserInfo;
import com.weijiajiao.repository.UserInfoRepository;

/**
 * Created by fly on 2017/6/20.
 */
@Component
public class UserService {
    @Autowired
    UserInfoRepository userInfoRepository;
    
    private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public UserInfo updateUserProfile(UserInfo userInfo){
        if (userInfo==null){
        	LOGGER.error("userInfo cannot be null");
            return null;
        }

        if (!isUserExist(userInfo.getId())){
        	LOGGER.error("user not found");
            return null;
        }
        return userInfoRepository.save(userInfo);
    }

    public boolean isUserExist(long userId){
        return userInfoRepository.exists(userId);
    }
    
    
    public UserInfo getUserByOpenId(String openid){
    	if(openid == null){
    		return null;
    	}
    	return userInfoRepository.findUserInfoByOpenId(openid);
    }
}
