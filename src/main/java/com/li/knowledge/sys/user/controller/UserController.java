package com.li.knowledge.sys.user.controller;

import com.li.knowledge.common.model.LayuiTableResult;
import com.li.knowledge.sys.user.model.dto.UserDTO;
import com.li.knowledge.sys.user.model.vo.UserVO;
import com.li.knowledge.sys.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: knowledge
 * @description: 用户控制层
 * @author: lifh
 * @create: 2020-08-07 15:47
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
    * @Description:  查询用户数据集合列表
    * @Param:  userDTO
    * @return:  用户数据集合
    * @Author: lifh
    * @Date: 2020/8/7 0007 下午 4:00
    */
    @RequestMapping(value = "/search" , method = RequestMethod.GET)
    public LayuiTableResult<UserVO> search(UserDTO userDTO){
        LayuiTableResult<UserVO> search = userService.search(userDTO);
        return search;
    }

}
