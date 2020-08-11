package com.li.knowledge.common.model;

import lombok.Data;

/**
 * @program: knowledge
 * @description: 消息实体类
 * @author: lifh
 * @create: 2020-08-10 09:48
 **/
@Data
public class Result {
    private int code;
    private boolean success;
    private String message;
    private String data;

    public Result(boolean success , String message , String data){
        this.success=success;
        this.message=message;
        this.data=data;
    }

    public Result(boolean success , String message){
        this.success=success;
        this.message=message;
    }

}
