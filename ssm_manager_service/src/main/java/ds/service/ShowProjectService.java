package ds.service;

import ds.po.ShowProjectCustom;
import ds.po.ShowProjectQueryVo;
import ds.utils.PageUtils;

import java.util.List;

/**
 * 首页展示项目的service层接口
 *
 * @author 董帅
 */
public interface ShowProjectService {

    /**
     * 分页查询所有项目
     * @return
     */
    PageUtils<ShowProjectCustom> getAllProjects(int currPage);

    /**
     * 添加项目
     * @param showProjectCustom
     */
    void saveProject(ShowProjectCustom showProjectCustom);

    /**
     * 编辑项目
     * @param showProjectCustom
     */
    void editProject(ShowProjectCustom showProjectCustom);

    /**
     * 删除项目
     * @param id
     */
    void deleteProject(Integer id);

    /**
     * 批量删除项目
     * @param showProjectQueryVo
     */
    void batchDeleteProjects(ShowProjectQueryVo showProjectQueryVo);

    /**
     * 前端查询所有项目
     * @return
     */
    List<ShowProjectCustom> getAllProjectsPortal();

    /**
     * 根据id查询出项目
     * @param id
     * @return
     */
    ShowProjectCustom getProjectSavePathById(int id);
}
