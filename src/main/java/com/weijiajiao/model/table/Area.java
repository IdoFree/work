package com.weijiajiao.model.table;

import com.weijiajiao.model.enum_type.AreaLevel;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by junli on 2017/5/31.
 */

@Entity
@Table(name = "core_sys_area")
public class Area implements Serializable {
    @Id
    private Long id;

    private String name;
    private Long parentID;

    @Enumerated(EnumType.ORDINAL)
    private AreaLevel level;

    private String pinyin;

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

    public Long getParentID() {
        return parentID;
    }

    public void setParentID(Long parentID) {
        this.parentID = parentID;
    }

    public AreaLevel getLevel() {
        return level;
    }

    public void setLevel(AreaLevel level) {
        this.level = level;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentID=" + parentID +
                ", level=" + level +
                ", pinyin='" + pinyin + '\'' +
                '}';
    }
}
