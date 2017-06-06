package com.weijiajiao.dao.dto;

import com.weijiajiao.model.table.Area;

import java.util.List;

/**
 * Created by fly on 2017/6/5.
 */
public class TeacherModel extends BaseModel {
    long teacherId;
    long uid;
    long aid;
    String avatar;
    String nickname;
    String realname;
    String gender;
    String university;

    List<CourseModel> teachCourses;
    List<AreaModel> teachAreas;

    boolean isTeacherMajor;
    String degreeType;
    String major;
    float gaokao;
    float chinese;
    float math;
    float english;
    float lizong;
    float wenzong;
    float music;
    float sport;

    public TeacherModel() {
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public boolean isTeacherMajor() {
        return isTeacherMajor;
    }

    public void setTeacherMajor(boolean teacherMajor) {
        isTeacherMajor = teacherMajor;
    }

    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public float getGaokao() {
        return gaokao;
    }

    public void setGaokao(float gaokao) {
        this.gaokao = gaokao;
    }

    public float getChinese() {
        return chinese;
    }

    public void setChinese(float chinese) {
        this.chinese = chinese;
    }

    public float getMath() {
        return math;
    }

    public void setMath(float math) {
        this.math = math;
    }

    public float getEnglish() {
        return english;
    }

    public void setEnglish(float english) {
        this.english = english;
    }

    public float getLizong() {
        return lizong;
    }

    public void setLizong(float lizong) {
        this.lizong = lizong;
    }

    public float getWenzong() {
        return wenzong;
    }

    public void setWenzong(float wenzong) {
        this.wenzong = wenzong;
    }

    public float getMusic() {
        return music;
    }

    public void setMusic(float music) {
        this.music = music;
    }

    public float getSport() {
        return sport;
    }

    public void setSport(float sport) {
        this.sport = sport;
    }



    public List<CourseModel> getTeachCourses() {
        return teachCourses;
    }

    public void setTeachCourses(List<CourseModel> teachCourses) {
        this.teachCourses = teachCourses;
    }


    public List<AreaModel> getTeachAreas() {
        return teachAreas;
    }

    public void setTeachAreas(List<AreaModel> teachAreas) {
        this.teachAreas = teachAreas;
    }

    @Override
    public String toString() {
        return "TeacherModel{" +
                "teacherId=" + teacherId +
                ", uid=" + uid +
                ", aid=" + aid +
                ", avatar='" + avatar + '\'' +
                ", nickname='" + nickname + '\'' +
                ", realname='" + realname + '\'' +
                ", gender='" + gender + '\'' +
                ", university='" + university + '\'' +
                ", teachCourses=" + teachCourses +
                ", teachAreas=" + teachAreas +
                ", isTeacherMajor=" + isTeacherMajor +
                ", degreeType='" + degreeType + '\'' +
                ", major='" + major + '\'' +
                ", gaokao=" + gaokao +
                ", chinese=" + chinese +
                ", math=" + math +
                ", english=" + english +
                ", lizong=" + lizong +
                ", wenzong=" + wenzong +
                ", music=" + music +
                ", sport=" + sport +
                '}';
    }
}
