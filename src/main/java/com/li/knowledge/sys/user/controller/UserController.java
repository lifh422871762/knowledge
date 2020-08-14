package com.li.knowledge.sys.user.controller;

import com.li.knowledge.common.model.LayuiTableResult;
import com.li.knowledge.common.model.Result;
import com.li.knowledge.sys.BaseController;
import com.li.knowledge.sys.user.model.dto.UserDTO;
import com.li.knowledge.sys.user.model.vo.UserVO;
import com.li.knowledge.sys.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: knowledge
 * @description: 用户控制层
 * @author: lifh
 * @create: 2020-08-07 15:47
 **/
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

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
        return userService.search(userDTO);
    }

    /**
    * @Description: 新增user用户
    * @Param:  userDTO 用户数据
    * @return:  返回结果信息
    * @Author: lifh
    * @Date: 2020/8/10 0010 上午 9:52
    */
    @RequestMapping(value = "/insert" , method = RequestMethod.POST)
    public Result insert(@RequestBody UserDTO userDTO){
        userDTO.setCreatedBy("lifuhao");
        return userService.insert(userDTO);
    }

    /**
    * @Description: 修改user用户
    * @Param:  userDTO 用户数据
    * @return:  返回结果信息
    * @Author: lifh
    * @Date: 2020/8/10 0010 上午 11:02
    */
    @RequestMapping(value = "/update" , method = RequestMethod.POST)
    public Result update(@RequestBody UserDTO userDTO){
        userDTO.setModifiedBy("lifuhao");
        return userService.update(userDTO);
    }

    /**
    * @Description: 根据Id删除一条用户信息
    * @Param:  id 用户id
    * @return:  返回结果信息
    * @Author: lifh
    * @Date: 2020/8/10 0010 上午 11:08
    */
    @RequestMapping(value = "/delete" , method = RequestMethod.GET)
    public Result delete(String id){
        return userService.delete(id);
    }

    /**
    * @Description: 根据Id查询用户信息
    * @Param:  id 用户id
    * @return:  返回结果信息
    * @Author: lifh
    * @Date: 2020/8/10 0010 上午 11:20
    */
    @RequestMapping(value = "/findById" , method = RequestMethod.GET)
    public UserVO findById(String id){
        return userService.findById(id);
    }

}
