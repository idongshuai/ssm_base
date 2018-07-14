package ds.service.impl;

import ds.mapper.HouStudentScoreMapper;
import ds.po.HouStudentAvgMaxScore;
import ds.po.HouStudentScore;
import ds.po.JsonMessage;
import ds.po.PageQueryVo;
import ds.service.HouStudentScoreService;
import ds.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 侯侯的学生成绩service层实现类
 *
 * @author 董帅
 */
@Service("houStudentScoreService")
public class HouStudentScoreServiceImpl implements HouStudentScoreService {

    @Autowired
    private HouStudentScoreMapper houStudentScoreMapper;

    /**
     * 查询所有考试时间,平均分,最高分
     * @return
     */
    @Override
    public List<HouStudentAvgMaxScore> getAvgMaxScoreExamTime() {
        return houStudentScoreMapper.getAvgMaxScoreExamTime();
    }

    /**
     * 查询所有学生
     * @return
     */
    @Override
    public List<String> getAllStudents() {
        return houStudentScoreMapper.getAllStudents();
    }

    /**
     * 按学生姓名顺序排序
     * @return
     */
    @Override
    public List<String> sortStudentByName() {
        return houStudentScoreMapper.sortStudentByName();
    }

    /**
     * 按学生姓名倒序排序
     * @return
     */
    @Override
    public List<String> sortStudentByNameDesc() {
        return houStudentScoreMapper.sortStudentByNameDesc();
    }

    /**
     * 根据学生姓名查询所有成绩
     * @param studentName
     * @return
     */
    @Override
    public List<HouStudentScore> getSingleStudentAllScoresByStudentName(String studentName) {
        return houStudentScoreMapper.getSingleStudentAllScoresByStudentName(studentName);
    }

    /**
     * 按最近一次考试的学生总分由高到低排序
     * @return
     */
    @Override
    public List<String> sortStudentByTotalScore() {
        return houStudentScoreMapper.sortStudentByTotalScore();
    }

    /**
     * 按最近一次考试的学生总分由低到高排序
     * @return
     */
    @Override
    public List<String> sortStudentByTotalScoreDesc() {
        return houStudentScoreMapper.sortStudentByTotalScoreDesc();
    }

    /**
     * 保存学生成绩
     * @param houStudentScore
     */
    @Override
    public void saveStudentScore(HouStudentScore houStudentScore) {
        houStudentScoreMapper.saveStudentScore(houStudentScore);
    }

    /**
     * 查询所有学生成绩
     * @return
     */
    @Override
    public List<HouStudentScore> getAllStudentsScore() {
        return houStudentScoreMapper.getAllStudentsScore();
    }

    /**
     * 查询所有考试时间
     * @return
     */
    @Override
    public List<String> getAllExamsTime() {
        return houStudentScoreMapper.getAllExamsTime();
    }

    /**
     * 查询总记录数
     * @return
     */
    @Override
    public int getStudentsScoreCount(String[] studentNames, String examTime) {

        int studentNamesLength = 0;
        if (studentNames != null && studentNames.length > 0) {
            studentNamesLength = studentNames.length;
        }

        return houStudentScoreMapper.getStudentsScoreCount(studentNames, examTime,studentNamesLength);
    }

    /**
     * 分页获取学生成绩
     * @param currPage
     * @param eachPageRows
     * @return
     */
    @Override
    public PageUtils<HouStudentScore> getStudentsScoreByPage(
            Integer currPage,
            Integer eachPageRows,
            String[] studentNames,
            String examTime) {

        PageUtils<HouStudentScore> pageUtils = new PageUtils<>();


        int start = (currPage - 1) * eachPageRows;

        int studentNamesLength = 0;
        if (studentNames != null && studentNames.length > 0) {
            studentNamesLength = studentNames.length;

        }

        //分页查询记录
        List<HouStudentScore> houStudentScoreList = houStudentScoreMapper
                .getStudentsScoreByPage(start, eachPageRows,studentNames,examTime,studentNamesLength);
        pageUtils.setResultsList(houStudentScoreList);



        //查询总记录数, 用于测试
        int count = houStudentScoreMapper.getStudentsScoreCount(studentNames, examTime, studentNamesLength);
        pageUtils.setTotalRows(count);


        return pageUtils;
    }

    /**
     * 编辑学生成绩
     * @param houStudentScore
     */
    @Override
    public void editStudentScoreById(HouStudentScore houStudentScore) {
        houStudentScoreMapper.editStudentScoreById(houStudentScore);
    }

    /**
     * 删除学生成绩
     * @param id
     */
    @Override
    public void deleteStudentScoreById(Integer id) {
        houStudentScoreMapper.deleteStudentScoreById(id);
    }

    /**
     * 批量删除学生成绩
     * @param jsonMessages
     */
    @Override
    public void batchDeleteStudentScoresByIds(JsonMessage[] jsonMessages) {
        houStudentScoreMapper.batchDeleteStudentScoresByIds(jsonMessages);
    }

    /**
     * 分页获取所有考试时间
     * @param currPage
     * @param eachPageRows
     * @return
     */
    @Override
    public PageUtils<HouStudentScore> getAllExamTimes(Integer currPage, Integer eachPageRows) {

        PageUtils<HouStudentScore> pageUtils = new PageUtils<>();

        PageQueryVo pageQueryVo = new PageQueryVo();
        pageQueryVo.setStart((currPage - 1) * eachPageRows);
        pageQueryVo.setEnd(eachPageRows);

        List<HouStudentScore> examTimeList = houStudentScoreMapper.getAllExamTimesByPage(pageQueryVo);
        pageUtils.setResultsList(examTimeList);

        int count = houStudentScoreMapper.getAllExamsTime().size();
        pageUtils.setTotalRows(count);
        return pageUtils;
    }

    /**
     * 根据原来的考试时间编辑考试时间
     * @param examTime
     */
    @Override
    public void editExamTimeByOriginalExamTime(String originalExamTime, String examTime) {

        Map<String, String> map = new HashMap<>();
        map.put("original", originalExamTime);
        map.put("new", examTime);

        houStudentScoreMapper.editExamTimeByOriginalExamTime(map);
    }

    /**
     * 根据原来的考试时间删除记录
     * @param originalExamTime
     */
    @Override
    public void deleteExamTimeByOriginalExamTime(String originalExamTime) {
        houStudentScoreMapper.deleteExamTimeByOriginalExamTime(originalExamTime);
    }
}
