package com.li.knowledge.sys.user.model.dto;

import com.li.knowledge.common.model.PageTableDTO;
import lombok.Data;

import java.util.Date;

/**
 * @program: knowledge
 * @description: 用户实体，用于接收前端传递数据
 * @author: lifh
 * @create: 2020-08-07 15:37
 **/
@Data
public class UserDTO extends PageTableDTO {

    private String id;//主键
    private String loginName;//登录名
    private String loginPassword;//登录密码
    private String name;//用户名
    private String phone;//手机号
    private String email;//邮箱
    private int seq;//排序
    private int status;//状态 1可用 2不可用
    private String remarks;//描述
    private String createdBy;//创建人
    private Date createdAt;//创建时间
    private String modifiedBy;//修改人
    private Date modifiedAt;//修改时间

    /**
     * 查询逻辑字段
     */
    private String startDate;//开始时间日期查询。
    private String endDate;//结束时间日期查询。

}
