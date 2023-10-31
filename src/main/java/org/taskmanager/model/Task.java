package org.taskmanager.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name="task")
@Entity
public class Task {

	@Id
	@Column(name="task_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="task_name")
	private String taskName;
	
	@Column(name="task_desc")
	private String taskDescription;
	
	@ManyToOne(fetch = FetchType.EAGER,
		    cascade = CascadeType.ALL)
	@JoinColumn(name="board_id")
	private Board board;
	
	@Column(name="task_status_id")
	private int taskStatusId;
	
	@Column(name="task_due_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Timestamp taskDueDate;
	
	@LastModifiedDate
	@CreationTimestamp
	@Column(name="task_status_modified_date")
	private Timestamp taskStatusModifiedDate;
	
	@LastModifiedDate
	@CreationTimestamp
	@Column(name="last_modified")
	private Timestamp lastModified;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Timestamp getTaskDueDate() {
		return taskDueDate;
	}
	public void setTaskDueDate(Timestamp taskDueDate) {
		this.taskDueDate = taskDueDate;
	}
	public Timestamp getLastModified() {
		return lastModified;
	}
	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}
	public int getTaskStatusId() {
		return taskStatusId;
	}
	public void setTaskStatusId(int taskStatusId) {
		this.taskStatusId = taskStatusId;
	}
	public Timestamp getTaskStatusModifiedDate() {
		return taskStatusModifiedDate;
	}
	public void setTaskStatusModifiedDate(Timestamp taskStatusModifiedDate) {
		this.taskStatusModifiedDate = taskStatusModifiedDate;
	}
}
