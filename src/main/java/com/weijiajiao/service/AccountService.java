package com.weijiajiao.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.weijiajiao.model.table.Account;
import com.weijiajiao.repository.AccountRepository;

//package com.weijiajiao.service;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
////import org.springframework.security.core.GrantedAuthority;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import com.weijiajiao.model.table.Account;
//import com.weijiajiao.repository.AccountRepository;
//
///**
// * Created by fly on 2017/6/14.
// */
//@Component
//public class AccountService implements UserDetailsService {
//    @Autowired
//    private AccountRepository accountRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        if (StringUtils.isBlank(s)){
//            throw new NullPointerException("账户为空");
//        }
//        Account account = accountRepository.findByOpenId(s);
//        Set<GrantedAuthority> authorities = new HashSet<>();
//
//        return new org.springframework.security.core.userdetails.User(
//                account.getOpenId(), account.getPassword(),
//                true,//是否可用
//                true,//是否过期
//                true,//证书不过期为true
//                true,//账户未锁定为true
//                authorities);
//    }
//}


@Component
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account getStudentByStuId(Long acountId){
        return accountRepository.findOne(acountId);
    }
    

}
