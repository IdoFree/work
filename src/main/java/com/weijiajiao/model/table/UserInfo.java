package com.weijiajiao.model.table;

import com.weijiajiao.model.enum_type.GenderType;
import com.weijiajiao.model.enum_type.UserType;

import javax.persistence.*;

/**
 * Created by junli on 2017/5/31.
 */

@Entity
@Table(name = "wjj_user_info")
public class UserInfo {

    @Id
    @GeneratedValue
    protected Long id;

    private Long accountId;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "nick_name")
    private String nickName;

    private String avatar;
    private String phone;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
