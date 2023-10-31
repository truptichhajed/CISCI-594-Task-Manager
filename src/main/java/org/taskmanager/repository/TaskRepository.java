package org.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taskmanager.model.Board;
import org.taskmanager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	public List<Task> findByBoard(Board board);
}
