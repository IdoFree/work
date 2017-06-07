package com.weijiajiao.dao.custom;

import com.weijiajiao.dao.dto.AreaModel;
import com.weijiajiao.model.table.Area;

import java.util.List;

/**
 * Created by fly on 2017/6/6.
 */
public interface AreaRepositoryCustom {
    List<AreaModel> queryAreaByTeacherId(long teacherId);
}
