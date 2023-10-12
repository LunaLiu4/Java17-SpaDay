package org.launchcode.controllers;


import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

//    private static List<User> userList = new ArrayList<>(){{
//        add(new User("Luna","luna.liu829@gmail.com","123"));
//        add(new User("Hui","huisen.wu@gmail.com","1234"));
//    }};
    @GetMapping("/add")
    public String displayAddUserForm(){
        return "user/add";
    }

    @PostMapping("/add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
    // add form submission handling code here
        model.addAttribute("user", user);
        model.addAttribute("verify",verify);
        model.addAttribute("userName",user.getUserName());
        model.addAttribute("email",user.getEmail());
        if (user.getPassword().equals(verify)) {
            return "user/index";
        }
        else {
            String error = "Passwords do not match! Please change!";
            model.addAttribute("error",error);
            return "user/add";
        }
    }

}
