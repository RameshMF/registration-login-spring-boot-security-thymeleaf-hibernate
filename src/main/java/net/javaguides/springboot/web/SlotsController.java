package net.javaguides.springboot.web;

import net.javaguides.springboot.model.*;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.SlotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/slots")
public class SlotsController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SlotsService slotsService;

    @PostMapping()
    public String getSlot(Model model, @ModelAttribute("Slot") Slot slot) {
       if(!slotsService.getBooked(slot.getSport(),slot.getUsername(),slot.getBirthDate())){
           Set<String> availableSlots = slotsService.getAvailableSlots(slot);
           model.addAttribute("options", availableSlots);
           Slot slot1 = new Slot();
           slot1.setOptions(availableSlots);
           slot1.setBirthDate(slot.getBirthDate());
           slot1.setSport(slot.getSport());
           slot1.setUsername(slot.getUsername());
           slot1.setPerson(new Person("uewkoi12345@gmail.com","name"));
           model.addAttribute("Slot",slot1);
           return "TimeSlots";
       }
        model.addAttribute("booked",true);
        return "error";
    }


}
