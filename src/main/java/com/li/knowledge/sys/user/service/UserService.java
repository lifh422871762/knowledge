package com.li.knowledge.sys.user.service;

import com.li.knowledge.common.model.LayuiTableResult;
import com.li.knowledge.sys.user.model.dto.UserDTO;
import com.li.knowledge.sys.user.model.vo.UserVO;

/**
 * @program: knowledge
 * @description: 用户业务层接口
 * @author: lifh
 * @create: 2020-08-07 15:47
 **/
public interface UserService {

    /**
     * @Description:  查询用户数据集合列表
     * @Param:  userDTO
     * @return:  用户数据集合
     * @Author: lifh
     * @Date: 2020/8/7 0007 下午 4:00
     */
    LayuiTableResult<UserVO> search(UserDTO userDTO);
}
