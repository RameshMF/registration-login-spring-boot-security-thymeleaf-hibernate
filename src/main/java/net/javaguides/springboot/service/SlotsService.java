package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Slot;
import net.javaguides.springboot.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class SlotsService {


    private Map<String, Set<String>> myAppKeysMap;


    @Value("${myapp.keys.Cricket}")
    private String cricketTimes;

    @Value("${myapp.keys.TableTennis}")
    private String tableTennisTimes;

    @Value("${myapp.keys.Squash}")
    private String squash;

    @Value("${myapp.keys.Badminton}")
    private String badminton;
    @Autowired
    private SlotRepository slotRepository;

    @PostConstruct
    private void init() {
        myAppKeysMap = new HashMap<>();
        myAppKeysMap.put("Cricket", convertToSet(cricketTimes));
        myAppKeysMap.put("TableTennis", convertToSet(tableTennisTimes));
        myAppKeysMap.put("Squash", convertToSet(squash));
        myAppKeysMap.put("Badminton", convertToSet(badminton));
    }

    private Set<String> convertToSet(String commaSeparatedValues) {
        return new LinkedHashSet<>(Arrays.asList(commaSeparatedValues.split(",")));
    }

    public Set<String> getAvailableSlots(Slot slot) {
       Set<String> slots =  myAppKeysMap.get(slot.getSport());
        Set<String> options = new HashSet<>();
       if(!CollectionUtils.isEmpty(slotRepository.getBookedSlots(slot.getBirthDate(), slot.getSport()))) {
           List<Slot> bookedSlots = slotRepository.getBookedSlots(slot.getBirthDate(), slot.getSport());
           for(Slot ss:bookedSlots) {
               options.add(ss.getSelectedOption());
               }
           Set<String> retSet = new HashSet<>();
           for(String s: slots){
               if(!options.contains(s)) {
                   retSet.add(s);
               }
           }
           return retSet;
           }
        return slots;
       }

    public boolean getBooked(String sport,String username,Date date) {
        if(!CollectionUtils.isEmpty(slotRepository.isBooked(date,sport,username))) {
            return true;
        }
        return false;
    }


    }
