package net.javaguides.springboot.web;

import net.javaguides.springboot.model.Slot;
import net.javaguides.springboot.model.UserName;
import net.javaguides.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/slots")
public class SlotsController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping()
    public void getSlot(Model model, @ModelAttribute("Slot") Slot slot) {
        model.addAttribute("Slot", slot);
    }
}
