package com.weijiajiao.repository;

import com.weijiajiao.model.table.StudentInfo;
import com.weijiajiao.model.table.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by fly on 2017/6/23.
 */
public interface StudentRepository extends CrudRepository<StudentInfo,Long> {
    StudentInfo findByUserInfo(UserInfo userInfo);

}
