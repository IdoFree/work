package com.weijiajiao.model.table;

import com.weijiajiao.model.enum_type.EducationDegreeType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by junli on 2017/5/27.
 */

@Entity
@Table(name = "wjj_teacher_info")
public class TeacherInfo {

    @Id
    @GeneratedValue
    protected Long id;

    @NotNull
    private Long teacherId;

    private Long universityId;
    private String majorName;

    @Enumerated(EnumType.STRING)
    private EducationDegreeType degreeType;

    private Boolean isTeacherMajor;
    private Float chineseScore;
    private Float mathScore;
    private Float englishScore;
    private Float wenzongScore;
    private Float lizongScore;
    private Float musicScore;
    private Float sportScore;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public EducationDegreeType getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(EducationDegreeType degreeType) {
        this.degreeType = degreeType;
    }

    public Boolean getTeacherMajor() {
        return isTeacherMajor;
    }

    public void setTeacherMajor(Boolean teacherMajor) {
        isTeacherMajor = teacherMajor;
    }

    public Float getChineseScore() {
        return chineseScore;
    }

    public void setChineseScore(Float chineseScore) {
        this.chineseScore = chineseScore;
    }

    public Float getMathScore() {
        return mathScore;
    }

    public void setMathScore(Float mathScore) {
        this.mathScore = mathScore;
    }

    public Float getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(Float englishScore) {
        this.englishScore = englishScore;
    }

    public Float getWenzongScore() {
        return wenzongScore;
    }

    public void setWenzongScore(Float wenzongScore) {
        this.wenzongScore = wenzongScore;
    }

    public Float getLizongScore() {
        return lizongScore;
    }

    public void setLizongScore(Float lizongScore) {
        this.lizongScore = lizongScore;
    }

    public Float getMusicScore() {
        return musicScore;
    }

    public void setMusicScore(Float musicScore) {
        this.musicScore = musicScore;
    }

    public Float getSportScore() {
        return sportScore;
    }

    public void setSportScore(Float sportScore) {
        this.sportScore = sportScore;
    }
}
