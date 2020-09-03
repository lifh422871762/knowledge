package com.li.knowledge.sys.user.repository;

import com.li.knowledge.sys.user.model.User;
import com.li.knowledge.sys.user.model.vo.UserVO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @program: knowledge
 * @description: 用户持久层jpa接口
 * @author: lifh
 * @create: 2020-08-07 15:48
 **/
public interface UserRepositroy extends CrudRepository<User,String>, UserRepositroyCustomr {

    /**
     * @Description: 根据登录用户名查找用户信息
     * @Param:  loginName 用户登录名
     * @return:  返回结果信息
     * @Author: lifh
     * @Date: 2020/8/10 0010 下午 2:19
     */
    List<User> findByLoginName(String loginName);
}
