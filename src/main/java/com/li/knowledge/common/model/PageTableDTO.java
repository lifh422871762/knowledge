package com.li.knowledge.common.model;

import org.springframework.data.domain.PageRequest;

/**
 * Created by dsy on 2016/12/05.
 * 分页的查询参数VO
 */
public class PageTableDTO {
    private int page = 1;//页码
    private int size = 15;//每页条目数
    private String field ;//排序字段
    private String order ;//升序降序
    private int total;//总条目数

    public PageTableDTO() {
    }

    public PageTableDTO(int page, int size) {
        this.page = page;
        setSize(size);
    }

    public PageRequest toPageRequest() {
        return PageRequest.of(this.page - 1, this.size);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPageNumber(int pageNumber) {
        setPage(pageNumber);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size <= 0) return;
        this.size = size;
    }

    public void setPageSize(int pageSize) {
        setSize(pageSize);
    }

    public void setLimit(int limit) {
        setSize(limit);
    }

    public int getOffset() {
        int page_index = page - 1;
        page_index = page_index >= 0 ? page_index : 0;
        return page_index * getSize();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
