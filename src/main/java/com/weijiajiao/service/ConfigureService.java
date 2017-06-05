package com.weijiajiao.service;

import com.weijiajiao.model.table.Area;
import com.weijiajiao.repository.AreaReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by junli on 2017/6/5.
 */
@Service
public class ConfigureService {

    @Autowired
    private AreaReponsitory areaReponsitory;

    public Area[] getActivityCity(){
        Long[] ids = areaReponsitory.findActivityCity();
        Area[] areas = areaReponsitory.findByIdIn(ids);
        return areas;
    }

}
