package com.example.SpringBoot.Controller;

import com.example.SpringBoot.model.User;
import com.example.SpringBoot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/")
  public String showUsersTable(Model model){
    model.addAttribute("users", userService.getUsersList());
    return "users";
  }

  @GetMapping("/new")
  public String createNewUser(Model model) {
    model.addAttribute("user", new User());
    return "new_user";
  }

  @PostMapping()
  public String addUser(@ModelAttribute("user") User user) {
    userService.addUser(user);
    return "redirect:/";
  }

  @GetMapping("/{id}/edit")
  public String editUser(Model model, @PathVariable("id") int id) {
    model.addAttribute("user", userService.getUser(id));
    return "edit_user";
  }

  @PatchMapping("/{id}")
  public String updateUser(@ModelAttribute("user")  User user) {
    userService.editUser(user);
    return "redirect:/";
  }

  @DeleteMapping("/{id}")
  public String deleteUser(@PathVariable("id") int id) {
    userService.deleteUser(id);
    return "redirect:/";
  }

}
