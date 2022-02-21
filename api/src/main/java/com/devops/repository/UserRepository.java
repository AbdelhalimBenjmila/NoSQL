package com.devops.repository;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.devops.entity.UserTable;

import java.util.List;

public interface UserRepository extends CrudRepository<UserTable, String> {

    @Query("Select * from user")
    List<UserTable> findAll();

    @Query("Select * from user where name=?0")
	UserTable findByName(String name);

}

