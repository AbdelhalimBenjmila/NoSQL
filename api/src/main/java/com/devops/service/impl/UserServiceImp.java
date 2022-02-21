package com.devops.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.devops.dto.UserDTO;
import com.devops.entity.UserTable;
import com.devops.repository.UserRepository;
import com.devops.service.UserService;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository ExampleTableRepository) {
        this.userRepository = ExampleTableRepository;
    }

    @Override
    public Collection<UserDTO> findAll() {
        return this.userRepository.findAll()
                .stream()
                .map(UserDTO::instanceOf)
                .collect(Collectors.toList());
    }

	@Override
	public UserTable save(UserDTO user) {
		// TODO Auto-generated method stub
		UserTable userTable = new UserTable(user.getName(),user.getAddress(),user.getAge(),user.getPhone());
		return userRepository.save(userTable);
	}

	@Override
	public UserTable update(String name, UserDTO user) {
		// TODO Auto-generated method stub
		UserTable userTable = userRepository.findByName(name);
		if (userTable != null) {
		userTable.getUserPrimaryKey().setName(user.getName());
		userTable.getUserPrimaryKey().setAddress(user.getAddress());
		userTable.getUserPrimaryKey().setAge(user.getAge());
		userTable.getUserPrimaryKey().setPhone(user.getPhone());
		}
		return userRepository.save(userTable);
	}
	
	@Override
	public Boolean delete(String name) {
		UserTable userTable = userRepository.findByName(name);
		if (userTable != null) {
			userRepository.delete(userTable);
			return true;
		}
		return false;
	}
}
