package com.weijiajiao.model;

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
    private Integer id;

    @Size(min = 2, max = 64)
    private String name;

    @Size(min = 6)
    private String password;

    private String openId;

}
