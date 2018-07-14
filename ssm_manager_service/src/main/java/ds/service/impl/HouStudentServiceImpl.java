package ds.service.impl;

import ds.mapper.HouStudentMapper;
import ds.po.HouStudent;
import ds.service.HouStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 侯侯, 学生service层实现类
 * @author 董帅
 */
@Service("houStudentService")
public class HouStudentServiceImpl implements HouStudentService {

    @Autowired
    private HouStudentMapper houStudentMapper;

    /**
     * 查询所有学生
     * @return
     */
    @Override
    public List<HouStudent> getAllStudents() {
        return houStudentMapper.getAllStudents();
    }

    /**
     * 按学生姓名排序
     * @return
     */
    @Override
    public List<HouStudent> sortStudentByName() {
        return houStudentMapper.sortStudentByName();
    }

    /**
     * 按学生姓名倒序排序
     * @return
     */
    @Override
    public List<HouStudent> sortStudentByNameDesc() {
        return houStudentMapper.sortStudentByNameDesc();
    }

    /**
     * 查找全部男生
     * @return
     */
    @Override
    public List<HouStudent> getSchoolboys() {
        return houStudentMapper.getSchoolboys();
    }

    /**
     * 查找全部女生
     * @return
     */
    @Override
    public List<HouStudent> getSchoolgirls() {
        return houStudentMapper.getSchoolgirls();
    }
}
