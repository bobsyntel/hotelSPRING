package com.bob.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bob.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	User findByEmail(String email);
}
