package com.sunjian.controller;

import com.sunjian.entity.User;
import com.sunjian.entity.UserVO;
import com.sunjian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(HttpServletResponse response, Integer page, Integer limit){
        response.setContentType("text/json;charset=UTF-8");
        return userService.findAll(page,limit);
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") int id){
        userService.deleteById(id);
        return "redirect:/main.jsp";
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update");
        modelAndView.addObject("user",userService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(User user){
        userService.update(user);
        return "redirect:/main.jsp";
    }

    @PostMapping("/save")
    public String save(User user){
        userService.save(user);
        return "redirect:/main.jsp";
    }
}
