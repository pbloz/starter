package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.User;
import com.example.repository.UserDao;

import java.util.List;

@Controller
public class UserController {

	@RequestMapping("/create")
	@ResponseBody
	public ResponseEntity<User> create(String email, String name) {
		try {
			user.setEmail(email);
			user.setName(name);
			userDao.save(user);
		} catch (Exception ex) {
			return new ResponseEntity<User>(user,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}

	@RequestMapping("/delete")
	public ResponseEntity<User> delete(long id) {
		try {
			User user = new User(id);
			userDao.delete(user);
		} catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	/**
	 * GET /get-by-email --> Return the id for the user having the passed email.
	 */
	@RequestMapping("/get-by-email")
	@ResponseBody
	public ResponseEntity<User> getByEmail(String email) {
		try {
			User user = userDao.findByEmail(email);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	/**
	 * GET /update --> Update the email and the name for the user in the
	 * database having the passed id.
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResponseEntity<User> updateUser(long id, String email, String name) {
		try {
			User user = userDao.findOne(id);
			user.setEmail(email);
			user.setName(name);
			userDao.save(user);
		} catch (Exception ex) {
			return new ResponseEntity<User>(user,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	@RequestMapping(name = "/users",method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> all = (List<User>) userDao.findAll();
		return new ResponseEntity<List<User>>(all, HttpStatus.OK);
	}

	// Private fields
	@Autowired
	private User user;
	@Autowired
	private UserDao userDao;

}