package com.li.knowledge.sys.user.service;

import com.li.knowledge.common.model.LayuiTableResult;
import com.li.knowledge.common.model.Result;
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

    /**
     * @Description: 新增user用户
     * @Param:  userDTO 用户数据
     * @return:  返回结果信息
     * @Author: lifh
     * @Date: 2020/8/10 0010 上午 9:52
     */
    Result insert(UserDTO userDTO);

    /**
     * @Description: 修改user用户
     * @Param:  userDTO 用户数据
     * @return:  返回结果信息
     * @Author: lifh
     * @Date: 2020/8/10 0010 上午 11:02
     */
    Result update(UserDTO userDTO);

    /**
     * @Description: 根据Id删除一条用户信息
     * @Param:  id 用户id
     * @return:  返回结果信息
     * @Author: lifh
     * @Date: 2020/8/10 0010 上午 11:08
     */
    Result delete(String id);

    /**
     * @Description: 根据Id查询用户信息
     * @Param:  id 用户id
     * @return:  返回结果信息
     * @Author: lifh
     * @Date: 2020/8/10 0010 上午 11:20
     */
    UserVO findById(String id);

    /**
    * @Description: 根据登录用户名查找用户信息
    * @Param:  loginName 用户登录名
    * @return:  返回结果信息
    * @Author: lifh
    * @Date: 2020/8/10 0010 下午 2:19
    */
    UserVO findByLoginName(String loginName);
}
