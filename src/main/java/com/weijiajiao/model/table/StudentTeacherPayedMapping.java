package com.weijiajiao.model.table;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "wjj_student_teacher_payed_mapping")
public class StudentTeacherPayedMapping {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private StudentInfo student;

    @ManyToOne
    private TeacherInfo teacher;


    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentInfo getStudent() {
        return student;
    }

    public void setStudent(StudentInfo student) {
        this.student = student;
    }

    public TeacherInfo getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherInfo teacher) {
        this.teacher = teacher;
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
