package com.weijiajiao.repository;

import com.weijiajiao.model.enum_type.CouponSourceType;
import com.weijiajiao.model.enum_type.CouponStatus;
import com.weijiajiao.model.table.Coupon;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

/**
 * Created by junli on 2017/6/2.
 */
public interface CouponRepository extends CrudRepository<Coupon, Long> {

    Coupon[] findByUser_IdAndStatus(Long userId, CouponStatus status);
    Boolean existsById(Long id);
}
