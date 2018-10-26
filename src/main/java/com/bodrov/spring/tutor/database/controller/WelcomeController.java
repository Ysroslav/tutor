package com.bodrov.spring.tutor.database.controller;

import com.bodrov.spring.tutor.database.entity.Staff;
import com.bodrov.spring.tutor.database.entity.User;
import com.bodrov.spring.tutor.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class WelcomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/welcome")
    public String login(){
        return "/welcome";
    }

    @RequestMapping(value = "/welcomeAction" , method = RequestMethod.POST)
    public String loginProcess(
            final HttpServletRequest request,
            final HttpServletResponse response,
            @ModelAttribute("login") String login,
            @ModelAttribute("password") String password,
            Map<String, Object> model
    ){
        if(login == null || password == null) return "redirect:/welcome";
        if(login.isEmpty() || password.isEmpty()) return "redirect:/welcome";

        final User user = userService.findByLogin(login).get();
        if(user == null) return "redirect:/welcome";

        final Staff staff=user.getStaff();
        model.put("staff", staff);
        final HttpSession session = request.getSession();
        session.setAttribute("auth", true);
        session.setAttribute("userId", user.getId());
        return "redirect:/staff-card";
    }
}
