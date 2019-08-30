package com.linminrui.blog.web.admin;

import com.linminrui.blog.po.User;
import com.linminrui.blog.service.UserService;
import com.linminrui.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {


    @Autowired
    UserService userService;

    @GetMapping
    public String loginUI(){
        return "admin/login";
    }


    @RequestMapping("login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes){

        User user = userService.findUserByUserNameAndPassword(username,  MD5Utils.code(password) );
        if(user != null){
            user.setPassword(null);
            session.setAttribute("user", user);
            return "admin" +
                    "/index";
        }else {
            attributes.addFlashAttribute("message", "用户名或者密码不正确");
            return "redirect:/admin";
        }
    }


    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }

}
