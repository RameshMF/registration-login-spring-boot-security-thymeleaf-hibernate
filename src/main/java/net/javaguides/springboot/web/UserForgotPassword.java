package net.javaguides.springboot.web;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.model.UserName;
import net.javaguides.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/password")
public class UserForgotPassword {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping
    public String showRegistrationForm() {
        return "forpassword";
    }

    @PostMapping()
    public String getPassword(@ModelAttribute("username") UserName username) {
         int i =userRepository.setNewPassword(bCryptPasswordEncoder.encode(username.getPassword()),username.getUsername());
        if(i == 1){
           return "redirect:/forpassword?success";
        }
        return "redirect:/forpassword?success";
    }

}
