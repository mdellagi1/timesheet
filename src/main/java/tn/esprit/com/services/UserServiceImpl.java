package tn.esprit.com.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.com.Entities.User;
import tn.esprit.com.repositories.UserRepository;



@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
 	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
			
			l.info("In Method retrieveAllUsers :");
			users = (List<User>) userRepository.findAll(); 
			l.debug("connexion à la DB Ok :"); 
			for (User user : users) {
				l.debug("user :" + user.getLastName()); 
			} 
			l.info("Out of Method retrieveAllUsers with Success", users.size());
		}catch (Exception e) {
			l.error("Out of Method retrieveAllUsers with Errors : " + e); 
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		
		User u_saved = null; 
		
		try {
			l.info(" Methode addUser"); 
			u_saved = userRepository.save(u); 
			
			l.info("user ajouter avec succes",u.getLastName()); 
			
		} catch (Exception e) {

			l.error("error in addUser() : " , e);
		}
		
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) {
		
		User userUpdated = null; 
		
		try {
			l.info("in method UpdateUser");
			userUpdated = userRepository.save(u); 
			l.info("modification effectue"+u.getLastName());
			
		} catch (Exception e) {
			  l.error("error in updateUser() : ", e);
		}
		
		return userUpdated; 
	}

	@Override
	public void deleteUser(String id) {
		
		try {
			l.info("in method delete user");
			userRepository.deleteById(Long.parseLong(id)); 
            l.info("user deleted successfully",id);
			
		} catch (Exception e) {
			 
			 l.error("error in deleteUser() : " , e);
		}
		
	}

	@Override
	public User retrieveUser(String id) {
		User u = null; 
		try {
			l.info("methode recuperation de l'utilisateur");
			u =  userRepository.findById(Long.parseLong(id)).get(); 
			l.info("utilisateur retrouvé",id);
			
		} catch (Exception e) {
			// TODO log ici : 
			l.error("error in retrieveUser() : ", e);
		}

		return u; 
	}

}
