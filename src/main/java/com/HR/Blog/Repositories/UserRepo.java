package com.HR.Blog.Repositories;


import java.util.Optional;

import com.HR.Blog.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer>{
		
	
	Optional<User> findByEmail(String email);
}
