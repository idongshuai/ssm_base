package ds.utils;

import java.util.List;

/**
 * 分页工具类
 *
 * @author 董帅
 */
public class PageUtils<T> {

    private int currPage;       //当前页
    private int eachPageRows;   //每页记录数
    private int totalRows;      //总记录数
    private List<T> resultsList;//查询结果集

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getEachPageRows() {
        return eachPageRows;
    }

    public void setEachPageRows(int eachPageRows) {
        this.eachPageRows = eachPageRows;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public List<T> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<T> resultsList) {
        this.resultsList = resultsList;
    }
}
