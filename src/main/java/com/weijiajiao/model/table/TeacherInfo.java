package com.weijiajiao.model.table;

import com.weijiajiao.configuration.WJJConst;
import com.weijiajiao.model.enum_type.EducationDegreeType;
import com.weijiajiao.model.enum_type.SubjectType;
import org.hibernate.annotations.ColumnDefault;

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
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL})
    private UserInfo userInfo;

    @ManyToOne
    private University university;

    private String majorName;

    @Enumerated(EnumType.STRING)
    private EducationDegreeType degreeType;

    //个人简介
    private String introduce;

    private Boolean isTeacherMajor;

    @Enumerated(EnumType.STRING)
    private SubjectType subjectType;

    private Float gaokaoScore;
    private Float chineseScore;
    private Float mathScore;
    private Float englishScore;
    private Float wenzongScore;
    private Float lizongScore;
    private Float musicScore;
    private Float sportScore;
    private Float paintingScore;

    //信息价格默认10元
    private Float infoPrice;

    //授课说明
    private String teachInstruction;

    public TeacherInfo(){
        super();
    }

    public TeacherInfo(Long id){
       this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
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

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public Boolean getTeacherMajor() {
        return isTeacherMajor;
    }

    public void setTeacherMajor(Boolean teacherMajor) {
        isTeacherMajor = teacherMajor;
    }

    public Float getGaokaoScore() {
        return gaokaoScore;
    }

    public void setGaokaoScore(Float gaokaoScore) {
        this.gaokaoScore = gaokaoScore;
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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Float getPaintingScore() {
        return paintingScore;
    }

    public void setPaintingScore(Float paintingScore) {
        this.paintingScore = paintingScore;
    }

    public String getTeachInstruction() {
        return teachInstruction;
    }

    public void setTeachInstruction(String teachInstruction) {
        this.teachInstruction = teachInstruction;
    }

    public Float getInfoPrice() {
        return WJJConst.CONTACT_TEACHER_PRICE;
    }

    public void setInfoPrice(Float infoPrice) {
        this.infoPrice = WJJConst.CONTACT_TEACHER_PRICE;
    }
}
