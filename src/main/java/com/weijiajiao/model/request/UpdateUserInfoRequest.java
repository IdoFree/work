package com.weijiajiao.model.request;


import com.weijiajiao.model.enum_type.GenderType;
import com.weijiajiao.model.enum_type.UserType;
import com.weijiajiao.model.table.UserInfo;

/**
 * Created by fly on 2017/6/19.
 */
public class UpdateUserInfoRequest {
    long userId;

    private String realName;

    private String nickName;

    private String avatar;
    private String phone;

    private String gender;

    private String userType;

    private String country;
    private String province;
    private String city;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public UserInfo parseUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(this.userId);
        userInfo.setAvatar(this.avatar);
        userInfo.setCity(this.city);
        userInfo.setCountry(this.country);
        userInfo.setGender(this.gender.equalsIgnoreCase("female")? GenderType.female:GenderType.male);
        userInfo.setNickName(this.nickName);
        userInfo.setRealName(this.realName);
        userInfo.setPhone(this.phone);
        userInfo.setProvince(this.province);
        userInfo.setUserType(this.userType.equalsIgnoreCase("teacher")? UserType.teacher:
                this.userType.equalsIgnoreCase("student")?UserType.student:UserType.all);
        return userInfo;
    }
}
