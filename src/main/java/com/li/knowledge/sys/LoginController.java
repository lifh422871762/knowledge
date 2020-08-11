package com.li.knowledge.sys;

import com.li.knowledge.common.constant.Message;
import com.li.knowledge.common.model.Result;
import com.li.knowledge.sys.user.model.vo.UserVO;
import com.li.knowledge.sys.user.service.UserService;
import com.li.knowledge.utils.json.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @Value("${session.user}")
    private String sessionUserKey;

    @RequestMapping("/login")
    public Result login(String loginName, String loginPassword){
        UserVO userVO = userService.findByLoginName(loginName);
        if(null != userVO && StringUtils.isNoneBlank(userVO.getId())){
            if(!userVO.getLoginPassword().equals(loginPassword)){
                return new Result(false, Message.LOGIN_MESSAGE_PASSWORD, JsonUtils.toJSONString(userVO));
            }
            HttpSession session = request.getSession();
            session.setAttribute(sessionUserKey,userVO);
            return new Result(true,Message.LOGIN_MESSAGE_SUCCESS, JsonUtils.toJSONString(userVO));
        }else{
            return new Result(false,Message.LOGIN_MESSAGE_NAME, JsonUtils.toJSONString(loginName));
        }
    }

    @RequestMapping("loginout")
    public Result loginout(){
        HttpSession session = request.getSession();
        session.removeAttribute(sessionUserKey);
        return new Result(true,Message.LOGINOUT_MESSAGE_SUCCESS);
    }

}
