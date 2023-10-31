package org.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.taskmanager.model.Board;
import org.taskmanager.model.Task;
import org.taskmanager.model.TaskStatus;
import org.taskmanager.service.DashboardService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/taskmanager/dashboard")
public class DashBoardController {

	@Autowired
	DashboardService dashBoardService;
	
	@PostMapping("/addboard")
	public Board createBoard(@RequestBody Board board) {
		System.out.println("In DBControler createBoard() : "+board.getBoardName()+"__"+board.getUser());
		return dashBoardService.createBoard(board);
	}
	
	@GetMapping("/getallboards")
	public List<Board> getBoards(@RequestParam Integer userId) {
		return dashBoardService.getBoards(userId);
	}
	
	@PostMapping("/createtaskstatus")
	public TaskStatus createTaskStatus(@RequestBody TaskStatus taskStatus) {
		return null;
	}
	
	@PostMapping("/createtask")
	public Task createTask(@RequestBody Task task) {
		return dashBoardService.createTask(task);
	}
	
	@PutMapping("/updatetask")
	public Task updateTask(@RequestBody Task task) {
		return dashBoardService.updateTask(task);
	}
	
	@GetMapping("/getalltasks")
	public List<Task> getTasks(@RequestParam Integer boardId, @RequestParam Integer userId) {
		return dashBoardService.getAllTasks(boardId, userId);
	}
	
}
