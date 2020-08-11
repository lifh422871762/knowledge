package com.li.knowledge.sys;

import com.li.knowledge.sys.user.model.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: knowledge
 * @description: 通用控制层
 * @author: lifh
 * @create: 2020-08-10 11:14
 **/
@Component
public class BaseController {

    @Autowired
    private HttpServletRequest request;

    @Value("${session.user}")
    private String sessionUserKey;

    /**
    * @Description: 获取当前登录人的登录用户名
    * @return:  用户名
    * @Author: lifh
    * @Date: 2020/8/10 0010 下午 2:51
    */
    public String getLoginName(){
        UserVO userVO = (UserVO) request.getSession().getAttribute(sessionUserKey);
        return userVO.getLoginName();
    }

    /**
     * @Description: 获取当前登录人的真实名
     * @return:  用户名
     * @Author: lifh
     * @Date: 2020/8/10 0010 下午 2:51
     */
    public String getName(){
        UserVO userVO = (UserVO) request.getSession().getAttribute(sessionUserKey);
        return userVO.getName();
    }



}
