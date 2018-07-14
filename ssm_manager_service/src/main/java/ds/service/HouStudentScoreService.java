package ds.service;

import ds.po.HouStudentAvgMaxScore;
import ds.po.HouStudentScore;
import ds.po.JsonMessage;
import ds.utils.PageUtils;

import java.util.List;

/**
 * 侯侯的学生成绩service层接口
 *
 * @author 董帅
 */
public interface HouStudentScoreService {

    /**
     * 查询所有考试时间,平均分,最高分
     * @return
     */
    List<HouStudentAvgMaxScore> getAvgMaxScoreExamTime();

    /**
     * 查询所有学生
     * @return
     */
    List<String> getAllStudents();

    /**
     * 按学生姓名顺序排序
     * @return
     */
    List<String> sortStudentByName();

    /**
     * 按学生姓名倒序排序
     * @return
     */
    List<String> sortStudentByNameDesc();

    /**
     * 根据学生姓名查询所有成绩
     * @param studentName
     * @return
     */
    List<HouStudentScore> getSingleStudentAllScoresByStudentName(String studentName);

    /**
     * 按最近一次考试的学生总分由高到低排序
     * @return
     */
    List<String> sortStudentByTotalScore();

    /**
     * 按最近一次考试的学生总分由低到高排序
     * @return
     */
    List<String> sortStudentByTotalScoreDesc();

    /**
     * 保存学生成绩
     * @param houStudentScore
     */
    void saveStudentScore(HouStudentScore houStudentScore);

    /**
     * 查询所有学生成绩
     * @return
     */
    List<HouStudentScore> getAllStudentsScore();

    /**
     * 查询所有考试时间
     * @return
     */
    List<String> getAllExamsTime();

    /**
     * 查询总记录数
     */
     int getStudentsScoreCount(String[] studentNames, String examTime);

    /**
     * 分页获取学生成绩
     * @param currPage
     * @param eachPageRows
     * @return
     */
    PageUtils<HouStudentScore> getStudentsScoreByPage(Integer currPage, Integer eachPageRows, String[] studentNames, String examTime);

    /**
     * 编辑学生成绩
     * @param houStudentScore
     */
    void editStudentScoreById(HouStudentScore houStudentScore);

    /**
     * 删除学生成绩
     * @param id
     */
    void deleteStudentScoreById(Integer id);

    /**
     * 批量删除学生成绩
     * @param jsonMessages
     */
    void batchDeleteStudentScoresByIds(JsonMessage[] jsonMessages);

    /**
     * 分页获取所有考试时间
     * @param currPage
     * @param eachPageRows
     * @return
     */
    PageUtils<HouStudentScore> getAllExamTimes(Integer currPage, Integer eachPageRows);

    /**
     * 根据id编辑考试时间
     * @param examTime
     */
    void editExamTimeByOriginalExamTime(String originalExamTime, String examTime);

    /**
     * 根据原来的考试时间删除记录
     * @param originalExamTime
     */
    void deleteExamTimeByOriginalExamTime(String originalExamTime);
}
