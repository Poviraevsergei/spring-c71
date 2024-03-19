package com.spring.controller;

import com.spring.model.User;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView getAllUsers(ModelAndView modelAndView) {
        List<User> users = userService.getAllUsers();
        modelAndView.setViewName(users.isEmpty() ? "empty" : "get_users");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Long id, ModelMap modelMap) { //@PathVariable если мы хотим достать из пути
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            modelMap.addAttribute("user", user.get());
            return "get_user_by_id";
        }
        return "empty";
    }

    @PostMapping
    public String createUser(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("age") Integer age) {
        return userService.createUser(username, password, age) ? "success" : "failure";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("id") Long id,
                             @RequestParam("age") Integer age) {
        return userService.updateUser(id, username, password, age) ? "success" : "failure";
    }

    @PostMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        return userService.deleteUserById(id) ? "success" : "failure";
    }
}