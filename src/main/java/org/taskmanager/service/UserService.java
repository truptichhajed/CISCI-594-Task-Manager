package org.taskmanager.service;

import org.taskmanager.error.ResponseMessage;
import org.taskmanager.model.ChangeUserPassword;
import org.taskmanager.model.User;

public interface UserService {
	public User getUser(Integer id);
	public User addUser(User user);
	public User loginUser(User user);
	public ResponseMessage updatePassword(User user, ChangeUserPassword changeUserPassword);
}
