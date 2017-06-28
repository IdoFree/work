package com.weijiajiao.model.table;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by junli on 2017/5/31.
 */

@Entity
@Table(name = "wjj_share_record")
public class ShareRecord {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private UserInfo user;

    //微信分享里分享群聊的标识
    private String shareTicket;

    private Date time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public String getShareTicket() {
        return shareTicket;
    }

    public void setShareTicket(String shareTicket) {
        this.shareTicket = shareTicket;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
