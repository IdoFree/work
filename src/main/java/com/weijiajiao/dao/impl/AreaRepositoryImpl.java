package com.weijiajiao.dao.impl;

import com.weijiajiao.dao.custom.AreaRepositoryCustom;
import com.weijiajiao.dao.custom.CourseRepositoryCustom;
import com.weijiajiao.dao.dto.AreaModel;
import com.weijiajiao.dao.dto.CourseModel;
import com.weijiajiao.logcat.LogUtil;
import com.weijiajiao.model.table.Area;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fly on 2017/6/5.
 */
public class AreaRepositoryImpl implements AreaRepositoryCustom {
    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<AreaModel> queryAreaByTeacherId(long teacherId) {
        String areaSql = "select distinct " +
                "   t.area_id as id," +
                "    a.name as name," +
                "    a.parentid as parentid," +
                "    a.level as level," +
                "    a.pinyin as pinyin " +
                "    from wjj_dev.wjj_teacher_teaching_area as t inner join wjj_dev.core_sys_area as a ON t.area_id = a.id" +
                "    where t.teacher_id = ?1";
        LogUtil.debug("AreaRepositoryImpl",areaSql);
        Query query = entityManager.createNativeQuery(areaSql);
        query.setParameter(1, teacherId);
        List objectArrayList = query.getResultList();
        if (objectArrayList==null||objectArrayList.size() == 0){
            return null;
        }
        List<AreaModel> retList = new ArrayList();
        for (Object objects:objectArrayList){
            Object[] arrays = (Object[]) objects;
            AreaModel area = new AreaModel();
            area.setId(((BigInteger) arrays[0]).longValue());
            area.setName((String) arrays[1]);
            area.setParentID(((Integer) arrays[2]).longValue());
            area.setLevel((Byte) arrays[3]);
            area.setPinyin((String) arrays[4]);
            retList.add(area);
        }
        return retList;
    }
}
