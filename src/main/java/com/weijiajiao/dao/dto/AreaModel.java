package com.weijiajiao.dao.dto;

/**
 * Created by fly on 2017/6/6.
 */
public class AreaModel extends BaseModel {
    private Long id;
    private String name;
    private Long parentID;
    private Byte level;
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

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
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
        return "AreaModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentID=" + parentID +
                ", level=" + level +
                ", pinyin='" + pinyin + '\'' +
                '}';
    }
}
