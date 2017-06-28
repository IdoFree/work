package com.weijiajiao.model.table;


import javax.persistence.*;

/**
 * Created by junli on 2017/6/6.
 */

@Entity
@Table(name = "core_categories")
public class CourseCategory {
    @Id
    private Long id;

    @ManyToOne
    private Grade grade;

    private String categoryName;

    @ManyToOne
    private Area area;

    @ManyToOne
    private CourseCategory parent;

    private Integer sort;

    private Boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public CourseCategory getParent() {
        return parent;
    }

    public void setParent(CourseCategory parent) {
        this.parent = parent;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CourseCategory{" +
                "id=" + id +
                ", grade=" + grade +
                ", categoryName='" + categoryName + '\'' +
                ", area=" + area +
                ", parent=" + parent +
                ", sort=" + sort +
                ", status=" + status +
                '}';
    }

}
