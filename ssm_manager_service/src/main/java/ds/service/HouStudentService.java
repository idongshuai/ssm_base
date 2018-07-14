package ds.service;

import ds.po.HouStudent;

import java.util.List;

/**
 * 侯侯, 学生service接口
 * @author 董帅
 */
public interface HouStudentService {

    /**
     * 查询所有学生
     * @return
     */
    List<HouStudent> getAllStudents();

    /**
     * 按学生姓名排序
     * @return
     */
    List<HouStudent> sortStudentByName();

    /**
     * 按学生姓名倒序排序
     * @return
     */
    List<HouStudent> sortStudentByNameDesc();

    /**
     * 查找全部男生
     * @return
     */
    List<HouStudent> getSchoolboys();

    /**
     * 查找全部女生
     * @return
     */
    List<HouStudent> getSchoolgirls();
}
