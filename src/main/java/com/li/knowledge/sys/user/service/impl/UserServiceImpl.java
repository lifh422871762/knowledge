package com.li.knowledge.sys.user.service.impl;

import com.li.knowledge.common.constant.Message;
import com.li.knowledge.common.model.LayuiTableResult;
import com.li.knowledge.common.model.Result;
import com.li.knowledge.sys.user.model.User;
import com.li.knowledge.sys.user.model.dto.UserDTO;
import com.li.knowledge.sys.user.model.vo.UserVO;
import com.li.knowledge.sys.user.repository.UserRepositroy;
import com.li.knowledge.sys.user.service.UserService;
import com.li.knowledge.utils.json.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: knowledge
 * @description: 用户业务层实现类
 * @author: lifh
 * @create: 2020-08-07 15:48
 **/
@Slf4j
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

    @Override
    public Result insert(UserDTO userDTO) {
        User user = null;
        try {
            if(null != userDTO){
                userDTO.setCreatedAt(new Date());
                user = new User();
                BeanUtils.copyProperties(userDTO,user);
                user = userRepositroy.save(user);
                return new Result(true, Message.SUCCESS_MESSAGE_SUBMIT, JsonUtils.toJSONString(user));
            }
            return new Result(false, Message.ERROR_MESSAGE_SUBMIT, JsonUtils.toJSONString(user));
        }catch (Exception e){
            log.error("{}",Message.ERROR_MESSAGE_SUBMIT,e.getLocalizedMessage());
            return new Result(false, Message.ERROR_MESSAGE_SUBMIT, JsonUtils.toJSONString(user));
        }
    }

    @Override
    public Result update(UserDTO userDTO) {
        User user = null;
        try {
            if(null != userDTO && StringUtils.isNotEmpty(userDTO.getId())){
                String [] excludeCol = {"createdBy","createdAt"};
                userDTO.setModifiedAt(new Date());
                user = new User();
                BeanUtils.copyProperties(userDTO,user,excludeCol);
                user = userRepositroy.save(user);
                return new Result(true, Message.SUCCESS_MESSAGE_SUBMIT, JsonUtils.toJSONString(user));
            }
            return new Result(false, Message.ERROR_MESSAGE_SUBMIT, JsonUtils.toJSONString(user));
        }catch (Exception e){
            log.error("{}",Message.ERROR_MESSAGE_SUBMIT,e.getLocalizedMessage());
            return new Result(false, Message.ERROR_MESSAGE_SUBMIT, JsonUtils.toJSONString(user));
        }
    }

    @Override
    public Result delete(String id) {
        try {
            userRepositroy.deleteById(id);
            return new Result(true, Message.SUCCESS_MESSAGE_DELETE, id);
        }catch (Exception e){
            log.error("{}",Message.ERROR_MESSAGE_DELETE,e.getLocalizedMessage());
            return new Result(false, Message.ERROR_MESSAGE_DELETE, id);
        }
    }

    @Override
    public UserVO findById(String id) {
        User user = userRepositroy.findById(id).orElse(new User());
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user,userVO);
        return userVO;
    }

    @Override
    public UserVO findByLoginName(String loginName) {
        List<User> userVOList = userRepositroy.findByLoginName(loginName);
        UserVO userVO = new UserVO();
        if(null != userVOList && !userVOList.isEmpty()){
            BeanUtils.copyProperties(userVOList.get(0),userVO);
            return userVO;
        }
        return userVO;
    }

}
