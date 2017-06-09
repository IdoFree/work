package com.weijiajiao.cache.impl;

import com.weijiajiao.cache.RedisGenerateDao;
import com.weijiajiao.cache.inteface.ITeacherRedisDao;
import com.weijiajiao.dao.dto.TeacherModel;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fly on 2017/6/7.
 */
@Component
public class TeacherRedisDaoImpl extends RedisGenerateDao<String, TeacherModel> implements ITeacherRedisDao {
    private static final String SEED = TeacherRedisDaoImpl.class.getName();
    @Override
    public void add(TeacherModel teacherModel) {
        String key = "id: " + teacherModel.getTeacherId();
        redisTemplate.boundHashOps(SEED).put(key,teacherModel);
    }

    @Override
    public void add(List<TeacherModel> teacherModels) {
        Assert.notEmpty(teacherModels,"List can not be null or empty");
        for (TeacherModel model:teacherModels){
            String key = "id: " + model.getTeacherId();
            redisTemplate.boundHashOps(SEED).put(key,model);
        }
    }

    @Override
    public void delete(Long teacherId) {
        String key = "id: " + teacherId;
        redisTemplate.boundHashOps(SEED).delete(key);
    }

    @Override
    public TeacherModel get(Long teacherId) {
        String key = "id: " + teacherId;
        return (TeacherModel) redisTemplate.boundHashOps(SEED).get(key);
    }

    public void setList(String key, List<TeacherModel> dataList) {
        BoundListOperations<String,TeacherModel> listOperation = redisTemplate.boundListOps(key);
        if (null != dataList) {
            for (TeacherModel model : dataList) {
                listOperation.rightPush(model);
            }
        }
    }

    public List<TeacherModel> getList(String key) {
        List<TeacherModel> dataList = new ArrayList<TeacherModel>();
        BoundListOperations<String, TeacherModel> listOperation = redisTemplate.boundListOps(key);
        Long size = listOperation.size();
        for (int i = 0; i < size; i++) {
            dataList.add((TeacherModel) listOperation.leftPop());
        }
        return dataList;
    }


}
