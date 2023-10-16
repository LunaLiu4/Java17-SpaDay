package org.launchcode.controllers;

import org.launchcode.data.UserData;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("")
    public String displayAddUserForm(){
        return "user/add";
    }

    @PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
    // add form submission handling code here
        if (!user.getPassword().equals(verify)) {
            String error = "Passwords do not match! Please change!";
            model.addAttribute("error",error);
            model.addAttribute("verify",verify);
            model.addAttribute("userName",user.getUserName());
            model.addAttribute("email",user.getEmail());
            return "user/add";
        }
        UserData.add(user);
        model.addAttribute("user", user);
        model.addAttribute("users", UserData.getAll());
        return "user/index";
    }

    @GetMapping("/details/{id}")
    public String displayUserDetails(@PathVariable int id, Model model){
        model.addAttribute("user",UserData.getById(id));
        return "/user/details";
    }
}
