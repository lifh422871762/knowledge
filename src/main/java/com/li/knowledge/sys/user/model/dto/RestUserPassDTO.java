package com.li.knowledge.sys.user.model.dto;

import lombok.Data;

/**
 * @program: knowledge
 * @description: 重置密码实体
 * @author: lifh
 * @create: 2020-08-17 10:51
 **/
@Data
public class RestUserPassDTO {

    private String id;//主键id
    private String usedPass;//旧密码
    private String newPass;//新密码

}
