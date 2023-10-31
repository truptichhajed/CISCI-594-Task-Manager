package org.taskmanager.reponses;

import java.util.List;

import org.springframework.stereotype.Component;
import org.taskmanager.model.Board;
import org.taskmanager.model.User;

@Component
public class BoardsListResponse {
	private List<Board> boardsList;
	private User user;
	
	public List<Board> getBoardsList() {
		return boardsList;
	}
	public void setBoardsList(List<Board> boardsList) {
		this.boardsList = boardsList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
