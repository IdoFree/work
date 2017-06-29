package com.weijiajiao.model.request;

/**
 * Created by junli on 2017/5/27.
 */
public class UniversityTeacherRegisterRequest {
    //TODO need to add more field to store the teacher information
    //是否师范专业
    private Boolean isTeacherMajor;

    //授课说明
    private String courseSpecification;

    private Float gaokaoScore;
    private Float chineseScore;
    private Float mathScore;
    private Float englishScore;
    private Float wenzongScore;
    private Float lizongScore;
    private Float musicScore;
    private Float sportScore;


    public Boolean getTeacherMajor() {
        return isTeacherMajor;
    }

    public void setTeacherMajor(Boolean teacherMajor) {
        isTeacherMajor = teacherMajor;
    }

    public String getCourseSpecification() {
        return courseSpecification;
    }

    public void setCourseSpecification(String courseSpecification) {
        this.courseSpecification = courseSpecification;
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
}
