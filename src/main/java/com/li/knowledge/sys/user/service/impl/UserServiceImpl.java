package com.li.knowledge.sys.user.service.impl;

import com.li.knowledge.common.model.LayuiTableResult;
import com.li.knowledge.sys.user.model.dto.UserDTO;
import com.li.knowledge.sys.user.model.vo.UserVO;
import com.li.knowledge.sys.user.repository.UserRepositroy;
import com.li.knowledge.sys.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: knowledge
 * @description: 用户业务层实现类
 * @author: lifh
 * @create: 2020-08-07 15:48
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositroy userRepositroy;

    @Override
    public LayuiTableResult<UserVO> search(UserDTO userDTO) {
        LayuiTableResult<UserVO> tableResult = new LayuiTableResult<>();
        List<UserVO> appinList = userRepositroy.search(userDTO);
        int total = userRepositroy.countByModel(userDTO);
        tableResult.setCode(0);
        tableResult.setMsg("success");
        tableResult.setCount(total);
        tableResult.setData(appinList);
        return tableResult;
    }

}
