package com.li.knowledge.sys.user.repository;

import com.li.knowledge.sys.user.model.dto.UserDTO;
import com.li.knowledge.sys.user.model.vo.UserVO;

import java.util.List;

/**
 * @program: knowledge
 * @description: 用户持久层自定义接口
 * @author: lifh
 * @create: 2020-08-07 15:48
 **/
public interface UserRepositroyCustomr {

    /**
    * @Description:  查询用户数据
    * @Param:  userDTO
    * @return:  用户数据集合
    * @Author: lifh
    * @Date: 2020/8/7 0007 下午 4:14
    */
    List<UserVO> search(UserDTO userDTO);

    /**
    * @Description: 查询用户数据总条数
    * @Param:  userDTO
    * @return:  用户数据总条数
    * @Author: lifh
    * @Date: 2020/8/7 0007 下午 4:14
    */
    int countByModel(UserDTO userDTO);
}
