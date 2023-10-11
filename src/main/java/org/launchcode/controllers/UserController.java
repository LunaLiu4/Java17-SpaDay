package org.launchcode.controllers;


import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    private static List<User> userList = new ArrayList<>(){{
        add(new User("Luna","luna.liu829@gmail.com","123"));
        add(new User("Hui","huisen.wu@gmail.com","1234"));
    }};

//    static {
//        userList.add()
//    }
//    private static final User user = new User("Luna","luna.liu829@gmail.com","123");
    @GetMapping("/add")
    public String displayAddUserForm(){
        return "user/add";
    }

    @PostMapping("/add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
    // add form submission handling code here
//        user = new User("Luna","luna.liu829@gmail.com","123");
        for (User userdata: userList){

        }
        if (user.getPassword().equals(verify)) {
            model.addAttribute("user", user);
            return "user/index";
        }
        else return "user/add";
    }

}
