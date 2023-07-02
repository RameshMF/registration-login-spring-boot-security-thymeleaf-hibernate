package net.javaguides.springboot.web;

import net.javaguides.springboot.model.Person;
import net.javaguides.springboot.model.Slot;
import net.javaguides.springboot.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/BookSlot")
public class BookingController {

    @Autowired
    private SlotRepository slotRepository;

    @PostMapping
    @ResponseBody
    public ResponseEntity<String> bookSlot(@ModelAttribute("Slot") Slot slot){
        slot.setBooked(true);
        slotRepository.save(slot);
        return ResponseEntity.ok("Success");
    }

}
