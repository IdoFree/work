package com.weijiajiao.model.table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by junli on 2017/5/31.
 */

@Entity
@Table(name = "wjj_share_record")
public class ShareRecord {

    @Id
    @GeneratedValue
    protected Long id;

    private Long userId;

    //微信分享里分享群聊的标识
    private String shareTicket;

    private Date time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
