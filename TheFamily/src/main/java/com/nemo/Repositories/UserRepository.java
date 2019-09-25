package com.nemo.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.nemo.Models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
