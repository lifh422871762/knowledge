package com.li.knowledge.common.model;

import java.util.List;

/**
 * @description:
 * @author: wyp
 * @create: 2019-08-11
 **/
public class LayuiTableResult<T> {
    private Integer code;//响应码
    private Integer count;//总条目
    private String msg;//消息
    private List<T> data;//结果集

    public LayuiTableResult() {
    }

    public LayuiTableResult(Integer code, Integer count, String msg, List<T> data){
        this.code=code;
        this.count=count;
        this.msg=msg;
        this.data=data;

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
