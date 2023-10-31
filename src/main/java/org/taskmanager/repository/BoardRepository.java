package org.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taskmanager.model.Board;
import org.taskmanager.model.User;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	public List<Board> findByUser(User user);
}
