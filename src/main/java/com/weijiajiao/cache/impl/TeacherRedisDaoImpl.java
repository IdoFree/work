package com.weijiajiao.cache.impl;

import com.weijiajiao.cache.RedisGenerateDao;
import com.weijiajiao.cache.inteface.ITeacherRedisDao;
import com.weijiajiao.dao.dto.TeacherModel;
import org.springframework.data.redis.connection.RedisConnection;
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
    public boolean add(TeacherModel teacherModel) {
        redisTemplate.opsForValue().set("id: "+teacherModel.getTeacherId(),teacherModel);
        return true;
//        boolean ret = redisTemplate.execute((RedisConnection connection) -> {
//            byte[] key = getRedisSerializer().serialize(String.valueOf(teacherModel.getTeacherId()));
//            byte[] value = getRedisSerializer().serialize(teacherModel);
//            return connection.setNX(key, value);
//        });
//        return ret;
    }

    @Override
    public boolean add(List<TeacherModel> teacherModels) {
        Assert.notEmpty(teacherModels,"List can not be null or empty");
        boolean result = redisTemplate.execute((RedisConnection connection) -> {
            RedisSerializer serializer = redisTemplate.getDefaultSerializer();
            for (TeacherModel member : teacherModels) {
                byte[] key = serializer.serialize(String.valueOf(member.getTeacherId()));
                byte[] name = serializer.serialize(member);
                connection.setNX(key, name);
            }
            return true;
        }, false, true);
        return result;
    }

    @Override
    public void delete(Long teacherId) {
        redisTemplate.delete(String.valueOf(teacherId));
    }

    @Override
    public TeacherModel get(Long teacherId) {
        TeacherModel result = redisTemplate.execute((RedisConnection connection) -> {
            RedisSerializer serializer = redisTemplate.getDefaultSerializer();
            byte[] key = serializer.serialize(String.valueOf(teacherId));
            byte[] value = connection.get(key);
            if (value == null) {
                return null;
            }
            TeacherModel teacherModel = (TeacherModel) serializer.deserialize(value);
            return teacherModel;
        });
        return result;
    }

    @Override
    public boolean update(TeacherModel teacherModel) {
        long teacherId = teacherModel.getTeacherId();
        if (get(teacherId) == null) {
            throw new NullPointerException("数据行不存在, teacherId = " + teacherId);
        }
        boolean result = redisTemplate.execute((RedisConnection connection) -> {
            byte[] key = getRedisSerializer().serialize(String.valueOf(teacherId));
            byte[] name = getRedisSerializer().serialize(teacherId);
            connection.set(key, name);
            return true;
        });
        return result;
    }


    public ListOperations setList(String key, List<TeacherModel> dataList) {
        ListOperations listOperation = redisTemplate.opsForList();
        if (null != dataList) {
            int size = dataList.size();
            for (TeacherModel model : dataList) {
                listOperation.rightPush(key, model);
            }
        }
        return listOperation;
    }

    public List<TeacherModel> getList(String key) {
        List<TeacherModel> dataList = new ArrayList<TeacherModel>();
        ListOperations<String, TeacherModel> listOperation = redisTemplate.opsForList();
        Long size = listOperation.size(key);
        for (int i = 0; i < size; i++) {
            dataList.add((TeacherModel) listOperation.leftPop(key));
        }
        return dataList;
    }


}
