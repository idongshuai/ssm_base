package ds.service;

import ds.po.JsonMessage;
import ds.po.PersonalAccount;
import ds.utils.PageUtils;

import java.util.List;

/**
 * 个人账号service层接口
 *
 * @author 董帅
 */
public interface PersonalAccountService {

    /**
     * 查询所有分类
     * @return
     */
    List<String> getAllCategorys();

    /**
     * 根据分类查询总记录数
     * @param accountCategory
     * @return
     */
    int getAccountsCountByCategory(String accountCategory);

    /**
     * 根据分类获取所有账号, 带分页
     * @param currPage
     * @param eachPageRows
     * @param accountCategory
     * @return
     */
    PageUtils<PersonalAccount> getAllAccountsByCategoryPage(Integer currPage, Integer eachPageRows, String accountCategory);

    /**
     * 添加个人账号
     * @param personalAccount
     */
    void savePersonalAccount(PersonalAccount personalAccount);

    /**
     * 编辑个人账号
     * @param personalAccount
     */
    void editPersonalAccountById(PersonalAccount personalAccount);

    /**
     * 根据id删除个人账号
     * @param id
     */
    void deletePersonalAccountById(Integer id);

    /**
     * 批量删除个人账号
     * @param jsonMessages
     */
    void batchDeletePersonalAccountsByIds(JsonMessage[] jsonMessages);
}
