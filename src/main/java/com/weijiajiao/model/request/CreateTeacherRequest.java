package com.weijiajiao.model.request;

import com.weijiajiao.configuration.WJJConst;
import com.weijiajiao.model.enum_type.SubjectType;
import com.weijiajiao.model.table.TeacherInfo;

/**
 * Created by junli on 2017/6/23.
 */
public class CreateTeacherRequest {
    //授课说明
    private String teachInstruction;
    private SubjectType subjectType;
    private Boolean isTeacherMajor;

    private Float gaokaoScore;
    private Float chineseScore;
    private Float mathScore;
    private Float englishScore;
    private Float wenzongScore;
    private Float lizongScore;
    private Float musicScore;
    private Float sportScore;
    private Float paintingScore;

    public String getTeachInstruction() {
        return teachInstruction;
    }

    public void setTeachInstruction(String teachInstruction) {
        this.teachInstruction = teachInstruction;
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

    public Float getPaintingScore() {
        return paintingScore;
    }

    public void setPaintingScore(Float paintingScore) {
        this.paintingScore = paintingScore;
    }

    public TeacherInfo convertToTeacherInfo(){
        TeacherInfo teacher = new TeacherInfo();
        teacher.setTeachInstruction(this.getTeachInstruction());
        teacher.setSubjectType(this.getSubjectType());
        teacher.setTeacherMajor(this.getTeacherMajor());
        teacher.setGaokaoScore(this.getGaokaoScore());
        teacher.setChineseScore(this.getChineseScore());
        teacher.setMathScore(this.getMathScore());
        teacher.setEnglishScore(this.getEnglishScore());
        teacher.setWenzongScore(this.getWenzongScore());
        teacher.setLizongScore(this.getLizongScore());
        teacher.setMusicScore(this.getMusicScore());
        teacher.setSportScore(this.getSportScore());
        teacher.setPaintingScore(this.getPaintingScore());

        return teacher;
    }

}
