package net.proselyte.trytesttask.controller;

import net.proselyte.trytesttask.model.User;
import net.proselyte.trytesttask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserService userService;

    @Autowired()
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public String listUsers(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUsers());

        return "users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        if(user.getId() == 0){
            this.userService.addUser(user);
        } else {
            this.userService.updateUser(user);
        }
        return "redirect:/users";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userService.removeUser(id);

        return "redirect:/users";
    }

    @RequestMapping("edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());

        return "users";
    }

    @RequestMapping("userdata/{id}")
    public String userData(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));

        return "userdata";
    }



    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String findListUsers (@RequestParam("name") String name, Model model){


        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.findUsers(name));

        return "users";
    }

    /*@RequestMapping(value = "users/find", method = RequestMethod.GET)
    public String findListUsers (@ModelAttribute("user") User user, Model model){


        String name = user.getName();
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.findUsers(name));

        return "users";
    }*/
}
