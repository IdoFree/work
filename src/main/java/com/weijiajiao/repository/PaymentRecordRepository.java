package com.weijiajiao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.weijiajiao.model.table.PaymentRecord;


/**
 * Created by junli on 2017/6/9.
 */
public interface PaymentRecordRepository extends CrudRepository<PaymentRecord, Long> {
	@Query(value = "select p from PaymentRecord p where p.teacher.id = :teacherId and p.user.id = :userId")
	List<PaymentRecord> findUserIdAndTeacherId(@Param("teacherId") Long teacherId, @Param("userId") Long userId);
}
