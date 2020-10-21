package com.init.loginusers.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.init.loginusers.dto.User;

public interface IUserDAO extends JpaRepository<User, Integer>{

}
