package com.weijiajiao.dao.impl;

import com.weijiajiao.dao.custom.TeacherRepositoryCustom;
import com.weijiajiao.dao.dto.TeacherModel;
import com.weijiajiao.repository.AreaRepository;
import com.weijiajiao.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by fly on 2017/6/2.
 */
public class TeacherRepositoryImpl implements TeacherRepositoryCustom {
    private final  static Logger logger = LoggerFactory.getLogger(TeacherRepositoryImpl.class);

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private AreaRepository areaRepository;


    /**
     * phone字段没有值，需要付费
     * tid uid aid avatar nickname realname gender university iduniversitymajor degreeType major               gaokao chinese math english lizong music sport wenzong                                courseid areaid
     * 2	14	14	http://tva2.sinaimg.cn/crop.0.0.180.180.180/8a8109e2jw1e8qgp5bmzyj2050050aa8.jpg	微信名1	真实名1	female	北京大学		college			141	144	137					11	440105
     * 4	16	16	http://tva2.sinaimg.cn/crop.0.0.180.180.180/8a8109e2jw1e8qgp5bmzyj2050050aa8.jpg	微信名3	真实名3	female	北京大学		college			124	123	130					11	440105
     *
     * @param areaId    为空时传id=0
     * @param subjectId 为空时传id=0
     * @return
     */
    @Override
    public List<TeacherModel> searchTeacherByAreaAndSubject(long areaId, long subjectId, int page, int pageSize) {
        List<TeacherModel> teacherModelList = null;
        String teacherSql = "";
        teacherSql = generateSearchTeacherByAreaAndSubjectSql(areaId, subjectId, page, pageSize);

        logger.debug(teacherSql.toString());

        Query query = entityManager.createNativeQuery(teacherSql);
        if (subjectId != 0) {
            query.setParameter("subjectId", subjectId);
        }
        if (areaId != 0) {
            query.setParameter("areaId", areaId);
        }
        List resultSet = query.getResultList();
        if (resultSet == null || resultSet.size() == 0) {
            return teacherModelList;
        }
        teacherModelList = new ArrayList<>();

        TeacherModel teacherModel = null;
        for (Object obj : resultSet) {
            Object[] arr = (Object[]) obj;
            teacherModel = new TeacherModel();
            teacherModel.setTeacherId(((BigInteger) arr[0]).longValue());
            teacherModel.setUid(((BigInteger) arr[1]).longValue());
            teacherModel.setAid(((BigInteger) arr[2]).longValue());
            teacherModel.setAvatar((String) arr[3]);
            teacherModel.setNickname((String) arr[4]);
            teacherModel.setRealname((String) arr[5]);
            teacherModel.setGender((String) arr[6]);
            teacherModel.setUniversity((String) arr[7]);
            teacherModel.setIntroduce((String) arr[8]);
            teacherModel.setTeacherMajor(arr[9] != null && ((Integer) arr[9]) != 0);
            teacherModel.setDegreeType((String) arr[10]);
            teacherModel.setMajor((String) arr[11]);
            if (arr[12] != null) {
                teacherModel.setGaokao((Float) (arr[12]));
            }
            if (arr[13] != null) {
                teacherModel.setChinese((Float) arr[13]);
            }
            if (arr[14] != null) {
                teacherModel.setMath((Float) arr[14]);
            }
            if (arr[15] != null) {
                teacherModel.setEnglish((Float) arr[15]);
            }
            if (arr[16] != null) {
                teacherModel.setLizong((Float) arr[16]);
            }
            if (arr[17] != null) {
                teacherModel.setMusic((Float) arr[17]);
            }
            if (arr[18] != null) {
                teacherModel.setSport((Float) arr[18]);
            }
            if (arr[19] != null) {
                teacherModel.setWenzong((Float) arr[19]);
            }
            if (arr[20] != null) {
                teacherModel.setPainting((Float) arr[20]);
            }
            teacherModel.setTeachInstruction((String) arr[21]);
            if (arr[22] != null) {
                teacherModel.setInfoPrice((Float) arr[22]);
            }
            teacherModel.setSubjectType((String) arr[23]);
            // TODO: 2017/6/5  添加授课区域和授课科目、价格等
            teacherModel.setTeachAreas(areaRepository.queryAreaByTeacherId(((BigInteger) arr[0]).longValue()));
            teacherModel.setTeachCourses(courseRepository.queryCourseByTeacherId((((BigInteger) arr[0]).longValue())));
            teacherModelList.add(teacherModel);
        }
        return teacherModelList;
    }

    /**
     * 用于查询已付费学生的老师，phone字段有值
     *
     * @param studentId
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public List<TeacherModel> queryTeacherByStudentId(long studentId, int page, int pageSize) {
        List<TeacherModel> teacherModelList = null;
        String studentPayedSql = generateQueryTeacherByStudentIdSql(page, pageSize);
        Query query = entityManager.createNativeQuery(studentPayedSql);
        query.setParameter("studentId", studentId);
        List resultSet = query.getResultList();
        if (resultSet == null || resultSet.size() == 0) {
            return teacherModelList;
        }
        teacherModelList = new ArrayList<>();
        TeacherModel teacherModel = null;
        for (Object obj : resultSet) {
            Object[] arr = (Object[]) obj;
            teacherModel = new TeacherModel();
            teacherModel.setTeacherId(((BigInteger) arr[0]).longValue());
            if (arr[1] != null) {
                teacherModel.setChinese((Float) arr[1]);
            }
            teacherModel.setDegreeType((String) arr[2]);
            if (arr[3] != null) {
                teacherModel.setEnglish((Float) arr[3]);
            }
            teacherModel.setTeacherMajor(arr[4] != null && ((Integer) arr[4]) != 0);
            if (arr[5] != null) {
                teacherModel.setLizong((Float) arr[5]);
            }
            teacherModel.setMajor((String) arr[6]);
            if (arr[7] != null) {
                teacherModel.setMath((Float) arr[7]);
            }
            if (arr[8] != null) {
                teacherModel.setMusic((Float) arr[8]);
            }
            if (arr[9] != null) {
                teacherModel.setSport((Float) arr[9]);
            }
            if (arr[10] != null) {
                teacherModel.setWenzong((Float) arr[10]);
            }
            if (arr[11] != null) {
                teacherModel.setGaokao((Float) arr[11]);
            }
            if (arr[12] != null) {
                teacherModel.setPainting((Float) arr[12]);
            }
            teacherModel.setUid(((BigInteger) arr[13]).longValue());
            teacherModel.setIntroduce((String) arr[14]);
            if (arr[15] != null) {
                teacherModel.setInfoPrice((Float) arr[15]);
            }
            teacherModel.setTeachInstruction((String) arr[16]);
            teacherModel.setUniversity((String) arr[17]);
            teacherModel.setAvatar((String) arr[18]);
            teacherModel.setGender((String) arr[19]);
            teacherModel.setNickname((String) arr[20]);
            teacherModel.setPhone((String) arr[21]);
            teacherModel.setRealname((String) arr[22]);
            teacherModel.setAid(((BigInteger) arr[23]).longValue());
            teacherModel.setTeachAreas(areaRepository.queryAreaByTeacherId(((BigInteger) arr[0]).longValue()));
            teacherModel.setTeachCourses(courseRepository.queryCourseByTeacherId((((BigInteger) arr[0]).longValue())));
            teacherModelList.add(teacherModel);
        }
        return teacherModelList;
    }

    private String generateQueryTeacherByStudentIdSql(int page, int pageSize) {
        return "select distinct " +
                "        ti.id," +
                "        ti.chinese_score," +
                "        ti.degree_type," +
                "        ti.english_score," +
                "        ti.is_teacher_major," +
                "        ti.lizong_score," +
                "        ti.major_name," +
                "        ti.math_score," +
                "        ti.music_score," +
                "        ti.sport_score," +
                "        ti.wenzong_score," +
                "        ti.gaokao_score," +
                "        ti.painting_score," +
                "        ti.user_info_id," +
                "        ti.introduce," +
                "        ti.info_price," +
                "        ti.teach_instruction," +
                "        su.name," +
                "        ui.avatar," +
                "        ui.gender," +
                "        ui.nick_name," +
                "        ui.phone," +
                "        ui.real_name," +
                "        ui.account_id" +
                "   from wjj_dev.wjj_teacher_info as ti" +
                "   inner join wjj_dev.wjj_student_teacher_payed_mapping as stpm ON ti.id = stpm.teacher_id" +
                "   inner join wjj_dev.wjj_user_info as ui ON ti.user_info_id = ui.id" +
                "   inner join wjj_dev.core_sys_university as su ON su.id = ti.university_id" +
                "   where stpm.student_id = :studentId limit " + pageSize + " offset " + page * pageSize;
    }

    /**
     * 搜索老师
     * 根据条件生成查询语句
     *
     * @param areaId
     * @param subjectId
     * @return
     */
    private String generateSearchTeacherByAreaAndSubjectSql(long areaId, long subjectId, int page, int pageSize) {
        StringBuilder teacherSql = new StringBuilder();
        teacherSql.append("select distinct" +
                "    tea.id as teacherid," +
                "    usr.id as uid," +
                "    usr.account_id as aid," +
                "    usr.avatar as avatar," +
                "    usr.nick_name as nickname," +
                "    usr.real_name as realname," +
                "    usr.gender as gender," +
                "    univ.name as university," +
                "    tea.introduce as introduce," +
                "    tea.is_teacher_major as isteachermajor," +
                "    tea.degree_type as degree_type," +
                "    tea.major_name as major," +
                "    tea.gaokao_score as gaokao," +
                "    tea.chinese_score as chinese," +
                "    tea.math_score as math," +
                "    tea.english_score as english," +
                "    tea.lizong_score as lizong," +
                "    tea.music_score as music," +
                "    tea.sport_score as sport," +
                "    tea.wenzong_score as wenzong," +
                "    tea.painting_score as painting," +
                "    tea.teach_instruction as teach_instruct," +
                "    tea.info_price as info_price," +
                "    tea.subject_type as subject_type"
        );
        teacherSql.append("    from wjj_dev.wjj_user_info as usr" +
                "    inner join wjj_dev.wjj_teacher_info as tea ON usr.id = tea.user_info_id" +
                "    inner join wjj_dev.core_sys_university as univ ON univ.id = tea.university_id");

        if (subjectId != 0) {
            teacherSql.append("    inner join wjj_dev.wjj_teacher_teaching_course as ttc ON ttc.teacher_id = tea.id");
        }
        if (areaId != 0) {
            teacherSql.append("    inner join wjj_dev.wjj_teacher_teaching_area as tta ON tta.teacher_id = tea.id");
        }
        if (subjectId != 0 && areaId != 0) {
            teacherSql.append("    where ttc.course_id = :subjectId" +
                    "    AND tta.area_id = :areaId");
        } else if (subjectId != 0) {
            teacherSql.append("    where ttc.course_id = :subjectId");
        } else if (areaId != 0) {
            teacherSql.append("    where tta.area_id = :areaId");
        }
        teacherSql.append(" limit " + pageSize);
        teacherSql.append(" offset " + pageSize * page);
        teacherSql.append(";");
        return teacherSql.toString();
    }


}
