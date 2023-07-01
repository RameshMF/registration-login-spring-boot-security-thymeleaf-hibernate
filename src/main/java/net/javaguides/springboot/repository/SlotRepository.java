package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface SlotRepository extends JpaRepository<Slot,String> {
    @Query(value = "select s from Slot s where s.birthDate = ?1 and s.sport = ?2")
    List<Slot> getBookedSlots(Date birthDate, String sport);
}
