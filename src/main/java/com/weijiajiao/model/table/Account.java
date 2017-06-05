package com.weijiajiao.model.table;

import io.swagger.models.auth.In;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Created by junli on 2017/5/27.
 */

@Entity
@Table(name = "wjj_account")
public class Account {
    @Id
    @GeneratedValue
    protected Long id;

    @Size(min = 2, max = 64)
    private String name;

    @Size(min = 6)
    private String password;

    private String openId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
