package org.taskmanager.service;

import java.util.List;

import org.taskmanager.model.Board;
import org.taskmanager.model.Task;

public interface DashboardService {
	public Board createBoard(Board board);
	public List<Board> getBoards(Integer userId);
	public Task createTask(Task task);
	public Task updateTask(Task task);
	public List<Task> getAllTasks(Integer boardId, Integer userId);
}
