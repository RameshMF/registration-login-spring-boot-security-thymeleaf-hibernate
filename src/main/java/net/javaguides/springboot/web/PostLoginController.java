package net.javaguides.springboot.web;

import net.javaguides.springboot.model.Slot;
import net.javaguides.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.Date;

@Controller
@RequestMapping("/filter")
public class PostLoginController {

    @PostMapping
    public String postLogin(@ModelAttribute("user") User user, Model model){
        model.addAttribute("Slot",new Slot("asw", new Date(), user.getEmail()));
        LocalDate minDate = LocalDate.now();
        LocalDate maxDate = LocalDate.now().plusDays(7);
        model.addAttribute("minDate", minDate);
        model.addAttribute("maxDate", maxDate);
        return "index";
    }
}
