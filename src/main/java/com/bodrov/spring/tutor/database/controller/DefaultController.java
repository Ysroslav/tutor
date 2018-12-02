package com.bodrov.spring.tutor.database.controller;

import com.bodrov.spring.tutor.database.entity.User;
import com.bodrov.spring.tutor.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class DefaultController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_SUPERADMIN")) {
            return "redirect:/secure/admin-main.xhtml";
        } else if(request.isUserInRole("ROLE_ADMIN")){
            return "redirect:/teacher/teacher-main.xhtml";
        } else {
            Optional<User> optional = userRepository.findByLogin(request.getRemoteUser());
            User user = optional.get();
            System.out.println(user.getStaff().getFirstName());
            return "redirect:/staff/staff-main.xhtml?id=" + user.getStaff().getId();
        }
    }
}
