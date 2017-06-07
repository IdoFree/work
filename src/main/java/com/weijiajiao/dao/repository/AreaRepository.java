package com.weijiajiao.dao.repository;

import com.weijiajiao.dao.custom.AreaRepositoryCustom;
import com.weijiajiao.model.table.Area;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fly on 2017/6/5.
 */
public interface AreaRepository extends JpaRepository<Area,Long> ,AreaRepositoryCustom {
}
