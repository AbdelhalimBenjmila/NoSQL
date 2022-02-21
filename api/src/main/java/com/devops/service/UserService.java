package com.devops.service;

import java.util.Collection;

import com.devops.dto.UserDTO;
import com.devops.entity.UserTable;

public interface UserService {

    public Collection<UserDTO> findAll();
    
    public UserTable save(UserDTO user);
    
    public UserTable update(String name, UserDTO user);

	Boolean delete(String name);

}
