package com.voucher.manage2.dto.page;
import java.util.List;

/**
 * 分页信息
 *
 * @author chaohui.yan
 * @date 2019-06-10
 *
 */
public class Pagefenye<T> {
    // 你页面需要展示的集合
    private List<T> list;
    // 总页数
    private int totalPage;

    // 当前页
    private int pageIndex;
    // 每页显示的数目 (为了防止硬编码可以写在配置文件中)
    private int pageSize;

    public Pagefenye(int totalNum, int currentPage, int pageSize, int pageNo) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        /*this.pageNo = pageNo;*/

        // 计算总页数
        if (totalNum % this.pageSize == 0)
            this.totalPage = totalNum / this.pageSize;
        else
            this.totalPage = (totalNum / this.pageSize) + 1;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int currentPage) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}