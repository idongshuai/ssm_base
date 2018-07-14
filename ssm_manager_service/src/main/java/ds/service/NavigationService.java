package ds.service;

import ds.po.*;
import ds.utils.PageUtils;

import java.util.List;

/**
 * 导航的service层接口
 *
 * @author 董帅
 */
public interface NavigationService {

    /**
     * 随机获取一句诗词
     * @return
     */
    Poem getRandomPoem();

    /**
     * 根据分类获取链接
     * @param category
     * @return
     */
    List<Navigation> getLinkByCategory(String category);

    /**
     * 根据分类获取链接, 带分页
     * @param currPage
     * @param linkCategory
     * @return
     */
    PageUtils<NavigationCustom> getAllLinksByCategoryPage(Integer currPage, Integer eachPageRows, String linkCategory);

    /**
     * 根据的总记录数
     * @return
     */
    int getLinksCountByCategory(String linkCategory);

    /**
     * 查询所有分类
     * @return
     */
    List<NavigationCategory> getAllCategorys();

    /**
     * 添加链接
     */
    void saveLink(NavigationCustom navigationCustom);

    /**
     * 编辑链接
     * @param navigationCustom
     */
    void editLinkById(NavigationCustom navigationCustom);

    /**
     * 删除链接
     * @param id
     */
    void deleteLinkById(Integer id);

    /**
     * 批量删除链接
     * @param jsonMessages
     */
    void batchDeleteLinksByIds(JsonMessage[] jsonMessages);
}
