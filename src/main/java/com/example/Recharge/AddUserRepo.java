package com.example.Recharge;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddUserRepo extends JpaRepository<User,String> {

	@Query("select username,password from User where username=?1 and password=?2")
	public List<Object[]> gotuserverification(String username,String password);

	
	
}
