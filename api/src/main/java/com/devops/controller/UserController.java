package com.devops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devops.dto.UserDTO;
import com.devops.entity.UserTable;
import com.devops.service.UserService;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Iterable<UserDTO>> returnAllUser() {
        Collection<UserDTO> UserDTOs = this.userService.findAll();
        return new ResponseEntity<>(UserDTOs, HttpStatus.OK);
    }
    
	@PostMapping("/add")
	@ResponseBody
	public UserTable add(@RequestBody UserDTO user) {
		return userService.save(user);
	}
	
	@PutMapping("/update/{name}")
	@ResponseBody
	public UserTable update(@PathVariable String name, @RequestBody UserDTO user) {
		return userService.update(name, user);
	}
	
	@DeleteMapping("/delete/{name}")
	@ResponseBody
	public Boolean delete(@PathVariable String name) {
		return userService.delete(name);
	}

}
