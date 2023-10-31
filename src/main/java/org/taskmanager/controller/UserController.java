
package org.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.taskmanager.error.ResponseMessage;
import org.taskmanager.model.ChangeUserPassword;
import org.taskmanager.model.User;
import org.taskmanager.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/taskmanager/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public User addNewUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@GetMapping
	public @ResponseBody User getUser(@RequestParam Integer id) {
		return userService.getUser(id);
	}
	
	/*@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)*/
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		User loggedInUser = userService.loginUser(user);
		
		if (loggedInUser != null) {
			return ResponseEntity.ok(loggedInUser);
		} else {
			ResponseMessage errorMessage = new ResponseMessage();
            errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
            errorMessage.setMessage("Invalid Credentials");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}	
	}
	
	@PostMapping("/changepassword")
	public ResponseEntity<?> changePassword(@RequestBody ChangeUserPassword changeUserPassword) {
		
		User loggedInUser = userService.getUser(changeUserPassword.getUserId());
		ResponseMessage responseMessage = null;
		if (loggedInUser != null) {
			responseMessage = userService.updatePassword(loggedInUser, changeUserPassword);
			if (responseMessage != null && responseMessage.getMessage().equals("success"))
				return ResponseEntity.ok(responseMessage);
			else {
				return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);		
			}
		}
		responseMessage = new ResponseMessage();
        responseMessage.setStatus(HttpStatus.BAD_REQUEST.value());
        responseMessage.setMessage("User not found");
		return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
	}
}
