package com.weijiajiao.service;

import com.weijiajiao.model.table.Account;
import com.weijiajiao.model.table.UserInfo;
import com.weijiajiao.repository.AccountRepository;
import com.weijiajiao.repository.UserInfoRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fly on 2017/6/14.
 */
@Component
public class AccountService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (StringUtils.isBlank(s)){
            throw new NullPointerException("账户为空");
        }
        Account account = accountRepository.findByOpenId(s);
        Set<GrantedAuthority> authorities = new HashSet<>();

        return new org.springframework.security.core.userdetails.User(
                account.getOpenId(), account.getPassword(),
                true,//是否可用
                true,//是否过期
                true,//证书不过期为true
                true,//账户未锁定为true
                authorities);
    }
}
