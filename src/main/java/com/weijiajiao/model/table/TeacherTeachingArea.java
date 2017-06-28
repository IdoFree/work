package com.weijiajiao.model.table;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by junli on 2017/6/1.
 */

@Entity
@Table(name = "wjj_teacher_teaching_area")
public class TeacherTeachingArea {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private TeacherInfo teacher;

    @ManyToOne
    private Area area;

    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TeacherInfo getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherInfo teacher) {
        this.teacher = teacher;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
