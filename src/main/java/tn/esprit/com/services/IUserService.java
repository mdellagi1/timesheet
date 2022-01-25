package tn.esprit.com.services;

import java.util.List;

import tn.esprit.com.Entities.User;

public interface IUserService {
	List<User> retrieveAllUsers(); 
	User addUser(User u);
	void deleteUser(String id);
	User updateUser(User u);
	User retrieveUser(String id);

}
