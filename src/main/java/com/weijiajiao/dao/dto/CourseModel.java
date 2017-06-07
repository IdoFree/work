package com.weijiajiao.dao.dto;

/**
 * Created by fly on 2017/6/5.
 */
public class CourseModel extends BaseModel{
    long id;
    long subjectId;
    long gradeId;
    String gradeName;
    String subjectName;

    public CourseModel() {
    }

    public CourseModel(long id, long subjectId, long gradeId, String gradeName, String subjectName) {
        this.id = id;
        this.subjectId = subjectId;
        this.gradeId = gradeId;
        this.gradeName = gradeName;
        this.subjectName = subjectName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public long getGradeId() {
        return gradeId;
    }

    public void setGradeId(long gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "CourseModel{" +
                "id=" + id +
                ", subjectId=" + subjectId +
                ", gradeId=" + gradeId +
                ", gradeName='" + gradeName + '\'' +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
