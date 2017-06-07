package com.weijiajiao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weijiajiao.dao.dto.CourseModel;
import com.weijiajiao.dao.dto.TeacherModel;
import com.weijiajiao.dao.repository.CourseRepository;
import com.weijiajiao.dao.repository.TeacherRepository;
import com.weijiajiao.model.enum_type.CouponType;
import com.weijiajiao.model.enum_type.EducationDegreeType;
import com.weijiajiao.model.enum_type.GenderType;
import com.weijiajiao.model.enum_type.UserType;
import com.weijiajiao.model.table.*;
import com.weijiajiao.repository.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.lang.invoke.MethodHandles;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by junli on 2017/6/1.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockAccountData {

    @Autowired
    private AccountReponsitory accountReponsitory;

    @Autowired
    private UserInfoReponsitory userInfoReponsitory;

    @Autowired
    private TeacherRepository teacherInfoReponsitory;

    @Autowired
    private CourseRepository courseReponsitory;

    @Autowired
    private TeacherTeachingAreaRepository teacherTeachingAreaRepository;

    @Autowired
    private TeacherTeachingCourseRepository teacherTeachingCourseRepository;

    @Autowired
    private ShareRecordReponsitory shareRecordReponsitory;

    @Autowired
    private CouponReponsitory couponReponsitory;

    private final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void addAccountData() {
        for (Integer i = 0; i < 10; i++) {
            Account account = mockAccountData();
            accountReponsitory.save(account);
        }
    }

    private Account mockAccountData() {
        Account account = new Account();
        String testOpenId = RandomStringUtils.randomAlphabetic(20);
        String testWechatSessionKey = RandomStringUtils.randomAlphabetic(20);
        account.setOpenId(testOpenId);
        account.setWechatSessionKey(testWechatSessionKey);
        return account;
    }

    @Test
    public void addUserInfoData() {

        String[] testNames = {"测试用户1", "测试用户2", "测试用户3",
                "测试用户4", "测试用户5", "测试用户6",
                "测试用户7", "测试用户8", "测试用户8",
                "测试用户10"
        };

        String[] testCities = {"广州市", "珠海市", "深圳市"};

        for (Integer i = 0; i < 10; i++) {
            UserInfo userInfo = new UserInfo();
            String testAvatarUrl = "http://tva2.sinaimg.cn/crop.0.0.180.180.180/8a8109e2jw1e8qgp5bmzyj2050050aa8.jpg";
            String testCity = testCities[(new Random()).nextInt(3)];
            GenderType testGender = i % 2 == 0 ? GenderType.female : GenderType.male;
            userInfo.setAvatar(testAvatarUrl);
            userInfo.setCountry("中国");
            userInfo.setProvince("广东省");
            userInfo.setCity(testCity);
            userInfo.setGender(testGender);
            userInfo.setNickName(testNames[i]);
            userInfo.setUserType(UserType.student);

            Account account = mockAccountData();
            userInfo.setAccount(account);

            userInfoReponsitory.save(userInfo);
        }

        System.out.println("插入十条用户信息数据");

    }

    @Test
    public void addTeacherData() {
        TeacherInfo teacher = new TeacherInfo();

        UserInfo userInfo = new UserInfo();
        userInfo.setNickName("微信名4");
        userInfo.setCountry("中国");
        userInfo.setProvince("广东省");
        userInfo.setCity("广州市");
        userInfo.setGender(GenderType.female);
        userInfo.setRealName("真实名4");
        userInfo.setUserType(UserType.teacher);
        String testAvatarUrl = "http://tva2.sinaimg.cn/crop.0.0.180.180.180/8a8109e2jw1e8qgp5bmzyj2050050aa8.jpg";
        userInfo.setAvatar(testAvatarUrl);


        Account account = mockAccountData();
        userInfo.setAccount(account);

        float chineseScore = (new Random()).nextInt(30) + 120;
        float mathScore = (new Random()).nextInt(30) + 120;
        float englishScore = (new Random()).nextInt(30) + 120;


        teacher.setUserInfo(userInfo);
        teacher.setChineseScore(chineseScore);
        teacher.setMathScore(mathScore);
        teacher.setEnglishScore(englishScore);
        teacher.setDegreeType(EducationDegreeType.college);

        University university = new University();
        university.setId(new Long(2));

        teacher.setUniversity(university);

        teacherInfoReponsitory.save(teacher);
    }

    @Test
    public void addTeacherTeachingArea() {

        for (Integer i = 0; i < 5; i++) {
            TeacherTeachingArea teachingArea = new TeacherTeachingArea();

            TeacherInfo teacherInfo = new TeacherInfo();
            teacherInfo.setId(new Long(5));
            teachingArea.setTeacher(teacherInfo);

            long[] randomAreaIds = {440303, 440304, 440305, 440306, 440307, 440308, 440309};
            long testAreaId = randomAreaIds[(new Random()).nextInt(7)];

            Area area = new Area();
            area.setId(testAreaId);
            teachingArea.setArea(area);

            teachingArea.setCreateTime(new Date());

            teacherTeachingAreaRepository.save(teachingArea);
        }

    }

    @Test
    public void addTeacherTeachingCourse() {

        for (Integer i = 0; i < 5; i++) {
            TeacherTeachingCourse teachingCourse = new TeacherTeachingCourse();

            TeacherInfo teacherInfo = new TeacherInfo();
            teacherInfo.setId(new Long(4));
            teachingCourse.setTeacher(teacherInfo);

            Course course = new Course();
            Integer testCourseId = new Random().nextInt(7) + 7;
            course.setId(new Long(testCourseId));
            teachingCourse.setCourse(course);

            teachingCourse.setCreateTime(new Date());

            teacherTeachingCourseRepository.save(teachingCourse);
        }


    }

    @Test
    public void addShareRecord() {
        for (Integer i = 0; i < 5; i++) {
            ShareRecord shareRecord = new ShareRecord();

            UserInfo user = new UserInfo();
            user.setId(new Long(3));
            shareRecord.setUser(user);

            String shareTicket = RandomStringUtils.randomAlphabetic(20);

            shareRecord.setShareTicket(shareTicket);
            shareRecord.setTime(new Date());

            shareRecordReponsitory.save(shareRecord);
        }
    }

    @Test
    public void addCoupon() {
        for (Integer i = 0; i < 5; i++) {

            Coupon coupon = new Coupon();

            UserInfo user = new UserInfo();
            user.setId(new Long(3));
            coupon.setUser(user);

            coupon.setTitle("免费劵");
            coupon.setDetail("每天登陆自动获取");

            Date now = new Date();
            coupon.setBeginTime(now);
            Date nextDayDate = new Date(now.getTime() + (1000 * 60 * 60 * 24));
            coupon.setExpiredTime(nextDayDate);

            coupon.setType(CouponType.free);

            couponReponsitory.save(coupon);

            logger.info("{}{}", 123, 345);

        }
    }

    @Test
    public void queryTeacherByAreaIdAndCourseId() throws JsonProcessingException {
        List<TeacherModel> teacherModelList = teacherInfoReponsitory.searchTeacherByAreaAndSubject(440105, 11, 0, 10);
        ObjectMapper mapper = new ObjectMapper();
        Assert.hasText("", mapper.writeValueAsString(teacherModelList));
    }

    @Test
    public void queryCoursesByTeacherId() throws JsonProcessingException {
        List<CourseModel> courseInterf = courseReponsitory.queryCourseByTeacherId(2);
        ObjectMapper mapper = new ObjectMapper();
        Assert.hasText("", mapper.writeValueAsString(courseInterf));
    }

}
