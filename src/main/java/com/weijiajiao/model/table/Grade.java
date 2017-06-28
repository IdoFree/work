package com.weijiajiao.model.table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by junli on 2017/6/2.
 */

@Entity
@Table(name = "core_grade")
public class Grade {

    @Id
    private Long id;
    private String name;

}
