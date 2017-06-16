package com.weijiajiao.repository;

import com.weijiajiao.model.table.Area;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Cacheable;

/**
 * Created by junli on 2017/6/5.
 */
public interface AreaRepository extends CrudRepository<Area, Long> {
//     @org.springframework.cache.annotation.Cacheable(value = "activity_city")
     Area[] findByIdIn(Long[] ids);

     @Query(value = "select distinct a.parentID from TeacherTeachingArea t inner join t.area a")
//     @org.springframework.cache.annotation.Cacheable(value = "activity_district_parent_ids")
     Long[] findActivityCityIds();
}
