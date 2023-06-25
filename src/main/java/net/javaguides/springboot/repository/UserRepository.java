package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.User;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);

	@Modifying
	@Transactional
	@Query("update User e set e.password = ?1 where e.email = ?2")
	int setNewPassword(String password, String email);

}
