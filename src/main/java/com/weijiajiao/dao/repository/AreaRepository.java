package com.weijiajiao.dao.repository;

import com.weijiajiao.dao.custom.AreaRepositoryCustom;
import com.weijiajiao.model.table.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by fly on 2017/6/5.
 */
public interface AreaRepository extends CrudRepository<Area,Long>,AreaRepositoryCustom {
}
