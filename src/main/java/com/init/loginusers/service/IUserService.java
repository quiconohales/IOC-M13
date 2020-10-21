package com.init.loginusers.service;

import java.util.ArrayList;
import java.util.List;

import com.init.loginusers.dto.User;

public interface IUserService {
	
	public List<User> listUsers();// Lista todos los Usuarios

	public ArrayList<User> UserPOSITIONALL();// Lista Usuarios con Position

	public User saveUser(User user); // Guarda un Usuario CREATE

	public User UserXID(Integer id); // Leer datos de un Usuario READ
	
	public User updateUser(User user); // Actualiza datos del Usuario UPDATE

	public void deleteUser(Integer id);// Elimina el Usuario DELETE

}
