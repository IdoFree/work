package com.weijiajiao.model.enum_type;

/**
 * Created by junli on 2017/5/31.
 */
public enum AreaLevel {
    country(0),
    province(1),
    city(2),
    district(3);


    private int level;
    private AreaLevel(int value){
        this.level = value;
    }

    public int getLevel() {
        return level;
    }
}
