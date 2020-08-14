package com.li.knowledge.sys.user.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @program: knowledge
 * @description: 用户实体，用于接收数据库数据
 * @author: lifh
 * @create: 2020-08-07 15:37
 **/
@Data
@Entity
@Table(name = "li_user")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
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

}
