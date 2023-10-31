package org.taskmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taskmanager.model.Board;
import org.taskmanager.model.Task;
import org.taskmanager.repository.BoardRepository;
import org.taskmanager.repository.TaskRepository;
import org.taskmanager.repository.UserRepository;

@Service
public class DashboardServiceImpl implements DashboardService {
	
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	public Board createBoard(Board board) {
		/*
		 * why saveAndFlush not returning User object in side Board object after persisting into DB
		 * */
		Board createdBoard = boardRepository.saveAndFlush(board);
		System.out.println(board.getUser().getId());
		System.out.println(board.getUser().getName());
		createdBoard.setUser(userRepository.findById(board.getUser().getId()).get());
		return createdBoard;
	}
	
	public List<Board> getBoards(Integer userId) {
		
		return boardRepository.findByUser(userRepository.findById(userId).get());
	}
	
	public Task createTask(Task task) {
		return taskRepository.saveAndFlush(task);
	}
	
	public Task updateTask(Task task) {
		Task updatedTask = taskRepository.getById(task.getId());
		updatedTask.setTaskStatusId(task.getTaskStatusId());
		return taskRepository.saveAndFlush(updatedTask);
	}
	
	public List<Task> getAllTasks(Integer boardId, Integer userId) {
		Board board = boardRepository.findById(boardId).get();
		return taskRepository.findByBoard(board);
	}

}
