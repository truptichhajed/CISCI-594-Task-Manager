package org.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taskmanager.error.ResponseMessage;
import org.taskmanager.model.ChangeUserPassword;
import org.taskmanager.model.User;
import org.taskmanager.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User getUser(Integer id) {
		System.out.println("Id:::: "+id);
		System.out.println(userRepository.findById(id));
		return userRepository.findById(id).get();
	}
	
	public User addUser(User user) {
		return userRepository.save(user);
	}

	public User loginUser(User user) {
		System.out.println("User email : "+user.getMail());
		User loggedInUser = userRepository.findByMail(user.getMail());
		if (loggedInUser != null && user.getPassword().equals(loggedInUser.getPassword()))
			return loggedInUser;
		else
			return null;
	}
	
	public ResponseMessage updatePassword(User user, ChangeUserPassword changeUserPassword) {
		ResponseMessage responseMessage = null;
		if (!changeUserPassword.getCurrentPassword().equals(user.getPassword())) {
			responseMessage = new ResponseMessage(400, "Incorrect Current password. Current Password provided does not match the old password");
			return responseMessage;
		} else if (!changeUserPassword.getNewPassword().equals(changeUserPassword.getConfirmPassword())) { 
			responseMessage = new ResponseMessage(400, "New Password & Confirm Password do not match");
			return responseMessage;
		} else if (changeUserPassword.getNewPassword().equals(changeUserPassword.getConfirmPassword())) {
			user.setPassword(changeUserPassword.getNewPassword());
			user.setConfirmPassword(changeUserPassword.getConfirmPassword());
			return new ResponseMessage(200, "success",userRepository.save(user));
		}
		return responseMessage;
	}
}
