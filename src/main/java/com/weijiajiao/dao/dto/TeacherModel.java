package com.weijiajiao.dao.dto;

import com.weijiajiao.model.enum_type.EducationDegreeType;
import com.weijiajiao.model.enum_type.GenderType;
import com.weijiajiao.model.table.Area;
import com.weijiajiao.model.table.TeacherInfo;
import com.weijiajiao.model.table.UserInfo;
import org.hibernate.Hibernate;

import java.util.List;

/**
 * Created by fly on 2017/6/5.
 */
public class TeacherModel extends BaseModel {
    Long teacherId;
    Long uid;
    Long aid;
    String avatar;
    String nickname;
    String realname;
    String gender;
    String university;
    String phone;

    Float infoPrice;

    List<CourseModel> teachCourses;
    List<AreaModel> teachAreas;

    Boolean isTeacherMajor;
    String introduce;
    String teachInstruction;
    String degreeType;
    String major;
    Float gaokao;
    Float chinese;
    Float math;
    Float english;
    Float lizong;
    Float wenzong;
    Float music;
    Float sport;
    Float painting;

    public TeacherModel() {
    }

    public static TeacherModel parseFrom(TeacherInfo info) {
        TeacherModel model = new TeacherModel();
        model.teacherId = info.getId();
        UserInfo userInfo = info.getUserInfo();
        model.uid = userInfo.getId();
        model.aid = userInfo.getAccount().getId();
        model.avatar = userInfo.getAvatar();
        model.nickname = userInfo.getNickName();
        model.realname = userInfo.getRealName();
        model.gender = userInfo.getGender() == GenderType.female ? "female" : "male";
        model.university = info.getUniversity().getName();
        model.isTeacherMajor = info.getTeacherMajor() != null ? info.getTeacherMajor() : false;
        model.degreeType = generateDegreeTypeStr(info.getDegreeType());
        model.major = info.getMajorName();
        model.gaokao = info.getGaokaoScore();
        model.chinese = info.getChineseScore();
        model.math = info.getMathScore();
        model.english = info.getEnglishScore();
        model.lizong = info.getLizongScore();
        model.wenzong = info.getWenzongScore();
        model.music = info.getMusicScore();
        model.sport = info.getSportScore();
        model.painting = info.getPaintingScore();
        model.introduce = info.getIntroduce();
        model.infoPrice = info.getInfoPrice();
        model.teachInstruction = info.getTeachInstruction();

        return model;
    }

    public static TeacherModel parseFrom(TeacherInfo info, boolean hasPhone) {
        TeacherModel model = parseFrom(info);
        if (hasPhone) {
            model.phone = info.getUserInfo().getPhone();
        }
        return model;
    }

    private static String generateDegreeTypeStr(EducationDegreeType degreeType) {
        String degree = "";
        switch (degreeType) {
            case doctor:
                degree = "doctor";
                break;
            case master:
                degree = "master";
                break;
            case middleSchool:
                degree = "middleSchool";
                break;
            case highSchool:
                degree = "highSchool";
                break;
            case college:
                degree = "college";
                break;
            case bachelor:
                degree = "bachelor";
                break;
            case secondarySchool:
                degree = "secondarySchool";
                break;
        }
        return degree;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
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

    public Boolean getTeacherMajor() {
        return isTeacherMajor;
    }

    public void setTeacherMajor(Boolean teacherMajor) {
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

    public Float getGaokao() {
        return gaokao;
    }

    public void setGaokao(Float gaokao) {
        this.gaokao = gaokao;
    }

    public Float getChinese() {
        return chinese;
    }

    public void setChinese(Float chinese) {
        this.chinese = chinese;
    }

    public Float getMath() {
        return math;
    }

    public void setMath(Float math) {
        this.math = math;
    }

    public Float getEnglish() {
        return english;
    }

    public void setEnglish(Float english) {
        this.english = english;
    }

    public Float getLizong() {
        return lizong;
    }

    public void setLizong(Float lizong) {
        this.lizong = lizong;
    }

    public Float getWenzong() {
        return wenzong;
    }

    public void setWenzong(Float wenzong) {
        this.wenzong = wenzong;
    }

    public Float getMusic() {
        return music;
    }

    public void setMusic(Float music) {
        this.music = music;
    }

    public Float getSport() {
        return sport;
    }

    public void setSport(Float sport) {
        this.sport = sport;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Float getInfoPrice() {
        return infoPrice;
    }

    public void setInfoPrice(Float infoPrice) {
        this.infoPrice = infoPrice;
    }

    public String getTeachInstruction() {
        return teachInstruction;
    }

    public void setTeachInstruction(String teachInstruction) {
        this.teachInstruction = teachInstruction;
    }

    public Float getPainting() {
        return painting;
    }

    public void setPainting(Float painting) {
        this.painting = painting;
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
                ", phone='" + phone + '\'' +
                ", infoPrice=" + infoPrice +
                ", teachCourses=" + teachCourses +
                ", teachAreas=" + teachAreas +
                ", isTeacherMajor=" + isTeacherMajor +
                ", introduce='" + introduce + '\'' +
                ", teachInstruction='" + teachInstruction + '\'' +
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
                ", painting=" + painting +
                '}';
    }
}
