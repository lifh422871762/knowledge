package com.li.knowledge.sys.user.repository;

import com.li.knowledge.sys.user.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @program: knowledge
 * @description: 用户持久层接口
 * @author: lifh
 * @create: 2020-08-07 15:48
 **/
public interface UserRepositroy extends CrudRepository<User,String>, UserRepositroyCustomr {
}
