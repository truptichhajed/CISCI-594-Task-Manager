package org.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taskmanager.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByMail(String mail);
}
