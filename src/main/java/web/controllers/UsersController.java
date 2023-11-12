package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping()
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/allusers";
    }

//    @GetMapping("/{id}")
//    public String getUserById(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("user", userService.getById(id));
//        return "users/show";
//    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        //либо так: в параметры пишем Model model + ниже строчка
        //        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit") //разлочь сверху
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
