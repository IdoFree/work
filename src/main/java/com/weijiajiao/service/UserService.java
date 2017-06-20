package com.weijiajiao.service;

import com.weijiajiao.model.table.UserInfo;
import com.weijiajiao.repository.UserInfoRepository;
import com.weijiajiao.utils.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fly on 2017/6/20.
 */
@Component
public class UserService {
    @Autowired
    UserInfoRepository userInfoRepository;

    public UserInfo updateUserProfile(UserInfo userInfo){
        if (userInfo==null){
            Logger.error("userInfo cannot be null");
            return null;
        }

        if (!isUserExist(userInfo.getId())){
            return null;
        }
        return userInfoRepository.save(userInfo);
    }

    public boolean isUserExist(long userId){
        return userInfoRepository.exists(userId);
    }
}
