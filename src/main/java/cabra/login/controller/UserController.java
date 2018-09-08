package cabra.login.controller;


import cabra.login.enity.User;
import cabra.login.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.alibaba.fastjson.JSONObject;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @CrossOrigin(origins="*")//允许跨域请求
    @RequestMapping(value="/login")
    public JSONObject login(String username,String password,HttpServletRequest request){


        log.info("登录请求...username="+username+"  pwd=" + password);
        JSONObject r = new JSONObject();
        User user=new User();
        user.setLoginName(username);
        User getuser=userService.selectByLoginname(user);
        if(getuser.getLoginName().equals(username) && getuser.getPassword().equals(password))	{
            r.put("code", "200");
            r.put("msg", "登录成功");
            r.put("token", username);
        }else{
            r.put("code", "500");
            r.put("msg", "登录失败");
        }
        return r;
    }


}
