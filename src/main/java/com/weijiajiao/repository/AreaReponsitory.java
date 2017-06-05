package com.weijiajiao.repository;

import com.weijiajiao.model.table.Area;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by junli on 2017/6/5.
 */
public interface AreaReponsitory extends CrudRepository<Area, Long> {
     Area[] findByIdIn(Long[] ids);

     @Query(value = "select DISTINCT a.parentid from wjj_teacher_teaching_area t inner join core_sys_area a on t.area_id = a.id", nativeQuery = true)
     Long[] findActivityCity();
}
