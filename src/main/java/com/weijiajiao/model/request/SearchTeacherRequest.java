package com.weijiajiao.model.request;

/**
 * Created by junli on 2017/5/27.
 */
public class SearchTeacherRequest {
   public Integer areaId;
   public Integer subjectId;
   public Integer page;
   public Integer pageSize;

   public Integer getAreaId() {
      return areaId;
   }

   public void setAreaId(Integer areaId) {
      this.areaId = areaId;
   }

   public Integer getSubjectId() {
      return subjectId;
   }

   public void setSubjectId(Integer subjectId) {
      this.subjectId = subjectId;
   }

   public Integer getPage() {
      return page;
   }

   public void setPage(Integer page) {
      this.page = page;
   }

   public Integer getPageSize() {
      return pageSize;
   }

   public void setPageSize(Integer pageSize) {
      this.pageSize = pageSize;
   }

   public SearchTeacherRequest() {
   }

   public SearchTeacherRequest(Integer areaId, Integer subjectId, Integer page, Integer pageSize) {
      this.areaId = areaId;
      this.subjectId = subjectId;
      this.page = page;
      this.pageSize = pageSize;
   }
}
