package ds.service.impl;

import ds.mapper.PersonalAccountMapper;
import ds.po.JsonMessage;
import ds.po.PersonalAccount;
import ds.po.PersonalAccountQueryVo;
import ds.service.PersonalAccountService;
import ds.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 个人账号的service层实现类
 *
 * @author 董帅
 */
@Service("personalAccount")
public class PersonalAccountServiceImpl implements PersonalAccountService {

    @Autowired
    private PersonalAccountMapper personalAccountMapper;

    /**
     * 查询所有分类
     * @return
     */
    @Override
    public List<String> getAllCategorys() {
        return personalAccountMapper.getAllCategorys();
    }

    /**
     * 根据分类查询总记录数
     * @param accountCategory
     * @return
     */
    @Override
    public int getAccountsCountByCategory(String accountCategory) {
        return personalAccountMapper.getAccountsCountByCategory(accountCategory);
    }

    /**
     * 根据分类获取所有账号, 带分页
     * @param currPage
     * @param eachPageRows
     * @param accountCategory
     * @return
     */
    @Override
    public PageUtils<PersonalAccount> getAllAccountsByCategoryPage(Integer currPage, Integer eachPageRows, String accountCategory) {

        PageUtils<PersonalAccount> pageUtils = new PageUtils<>();

        PersonalAccountQueryVo personalAccountQueryVo = new PersonalAccountQueryVo();
        personalAccountQueryVo.setAccountCategory(accountCategory);
        personalAccountQueryVo.setStart((currPage - 1) * eachPageRows);
        personalAccountQueryVo.setEnd(eachPageRows);

        // 查询每页的数据
        List<PersonalAccount> personalAccountList = personalAccountMapper.getAccountsByCategoryPage(personalAccountQueryVo);
        pageUtils.setResultsList(personalAccountList);

        // 根据分类查询总记录数
        int totalRows = personalAccountMapper.getAccountsCountByCategory(accountCategory);
        pageUtils.setTotalRows(totalRows);

        return pageUtils;
    }

    /**
     * 添加个人账号
     * @param personalAccount
     */
    @Override
    public void savePersonalAccount(PersonalAccount personalAccount) {
        personalAccountMapper.savePersonalAccount(personalAccount);
    }

    /**
     * 编辑个人账号
     * @param personalAccount
     */
    @Override
    public void editPersonalAccountById(PersonalAccount personalAccount) {
        personalAccountMapper.editPersonalAccountById(personalAccount);
    }

    /**
     * 根据id删除个人账号
     * @param id
     */
    @Override
    public void deletePersonalAccountById(Integer id) {
        personalAccountMapper.deletePersonalAccountById(id);
    }

    /**
     * 批量删除个人账号
     * @param jsonMessages
     */
    @Override
    public void batchDeletePersonalAccountsByIds(JsonMessage[] jsonMessages) {
        personalAccountMapper.batchDeletePersonalAccountsByIds(jsonMessages);
    }
}
