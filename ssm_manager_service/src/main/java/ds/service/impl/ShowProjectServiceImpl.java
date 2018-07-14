package ds.service.impl;

import ds.mapper.ShowProjectMapperCustom;
import ds.po.ShowProjectCustom;
import ds.po.ShowProjectQueryVo;
import ds.service.ShowProjectService;
import ds.po.PageQueryVo;
import ds.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页展示项目的service层实现类
 * @author 董帅
 */
@Service("showProjectService")
public class ShowProjectServiceImpl implements ShowProjectService {

    @Autowired
    private ShowProjectMapperCustom showProjectMapperCustom;

    /**
     * 分页查询所有项目
     * @return
     */
    @Override
    public PageUtils<ShowProjectCustom> getAllProjects(int currPage) {

        PageUtils<ShowProjectCustom> pageUtils = new PageUtils<>();
        pageUtils.setEachPageRows(5);

        PageQueryVo pageQueryVo = new PageQueryVo();
        pageQueryVo.setStart((currPage - 1) * 5);
        pageQueryVo.setEnd(5);

        //查询每页的数据列表
        List<ShowProjectCustom> showProjectCustomList =  showProjectMapperCustom.getAllProjects(pageQueryVo);
        pageUtils.setResultsList(showProjectCustomList);

        //查询总记录数
        int totalRows = showProjectMapperCustom.getProjectsCount();
        pageUtils.setTotalRows(totalRows);

        return pageUtils;
    }

    /**
     * 添加项目
     * @param showProjectCustom
     */
    @Override
    public void saveProject(ShowProjectCustom showProjectCustom) {
        showProjectMapperCustom.saveProject(showProjectCustom);
    }

    /**
     * 编辑项目
     * @param showProjectCustom
     */
    @Override
    public void editProject(ShowProjectCustom showProjectCustom) {
        showProjectMapperCustom.editProject(showProjectCustom);
    }

    /**
     * 删除项目
     * @param id
     */
    @Override
    public void deleteProject(Integer id) {
        showProjectMapperCustom.deleteProject(id);
    }

    /**
     * 批量删除项目
     * @param showProjectQueryVo
     */
    @Override
    public void batchDeleteProjects(ShowProjectQueryVo showProjectQueryVo) {
        showProjectMapperCustom.batchDeleteProjects(showProjectQueryVo);
    }

    /**
     * 前端查询所有项目
     * @return
     */
    @Override
    public List<ShowProjectCustom> getAllProjectsPortal() {
        return showProjectMapperCustom.getAllProjectsPortal();
    }

    /**
     * 根据id查询出项目
     * @param id
     * @return
     */
    @Override
    public ShowProjectCustom getProjectSavePathById(int id) {
        return showProjectMapperCustom.getProjectSavePathById(id);
    }
}
