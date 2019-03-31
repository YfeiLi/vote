package com.soar.vote.common.dto;

/**
 * <strong>分页请求实体</strong>
 * date: 1/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
public class PageRequestDTO {

    /** 当前页 */
    private Integer pageNum=1;

    /** 分页大小 */
    private Integer pageSize=10;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
