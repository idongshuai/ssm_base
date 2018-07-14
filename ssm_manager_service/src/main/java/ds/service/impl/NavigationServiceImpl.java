package ds.service.impl;

import ds.mapper.NavigationCategoryMapperCustom;
import ds.mapper.NavigationMapperCustom;
import ds.mapper.PoemMapperCustom;
import ds.po.*;
import ds.service.NavigationService;
import ds.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 导航的service层实现类
 * @author 董帅
 */
@Service("navigationService")
public class NavigationServiceImpl implements NavigationService {

    @Autowired
    private PoemMapperCustom poemMapperCustom;

    @Autowired
    private NavigationMapperCustom navigationMapperCustom;

    @Autowired
    private NavigationCategoryMapperCustom navigationCategoryMapperCustom;

    /**
     * 随机获取一句诗词
     * @return
     */
    @Override
    public Poem getRandomPoem() {
        return poemMapperCustom.getRandomPoem();
    }

    /**
     * 根据分类获取链接
     * @param category
     * @return
     */
    @Override
    public List<Navigation> getLinkByCategory(String category) {
        return navigationMapperCustom.getLinkByCategory(category);
    }

    /**
     * 根据分类获取链接, 带分页
     * @param currPage
     * @param linkCategory
     * @return
     */
    @Override
    public PageUtils<NavigationCustom> getAllLinksByCategoryPage(Integer currPage, Integer eachPageRows, String linkCategory) {

        PageUtils<NavigationCustom> pageUtils = new PageUtils<>();

        NavigationQueryVo navigationQueryVo = new NavigationQueryVo();
        navigationQueryVo.setLinkCategory(linkCategory);
        navigationQueryVo.setStart((currPage - 1) * eachPageRows);
        navigationQueryVo.setEnd(eachPageRows);

        //查询每页的数据列表
        List<NavigationCustom> navigationCustomList =  navigationMapperCustom.getLinksByCategory(navigationQueryVo);
        pageUtils.setResultsList(navigationCustomList);

        //根据分类查询总记录数
        int totalRows = navigationMapperCustom.getLinksTotalRowsByCategory(linkCategory);
        pageUtils.setTotalRows(totalRows);

        return pageUtils;
    }

    /**
     * 根据分类总记录数
     * @return
     */
    @Override
    public int getLinksCountByCategory(String linkCategory) {
        return navigationMapperCustom.getLinksTotalRowsByCategory(linkCategory);
    }

    /**
     * 查询所有分类
     * @return
     */
    @Override
    public List<NavigationCategory> getAllCategorys() {
        return navigationCategoryMapperCustom.getAllCategorys();
    }

    /**
     * 添加链接
     * @param navigationCustom
     */
    @Override
    public void saveLink(NavigationCustom navigationCustom) {
        navigationMapperCustom.saveLink(navigationCustom);
    }

    /**
     * 编辑链接
     * @param navigationCustom
     */
    @Override
    public void editLinkById(NavigationCustom navigationCustom) {
        navigationMapperCustom.editLinkById(navigationCustom);
    }

    /**
     * 删除链接
     * @param id
     */
    @Override
    public void deleteLinkById(Integer id) {
        navigationMapperCustom.deleteLinkById(id);
    }

    /**
     * 批量删除链接
     * @param jsonMessages
     */
    @Override
    public void batchDeleteLinksByIds(JsonMessage[] jsonMessages) {
        navigationMapperCustom.batchDeleteLinksByIds(jsonMessages);
    }
}
