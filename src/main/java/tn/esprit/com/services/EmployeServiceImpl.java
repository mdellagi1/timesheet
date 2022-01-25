package tn.esprit.com.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.com.Entities.Employe;

import tn.esprit.com.repositories.EmployeRepository;

public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;
	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);
	
	
	@Override
	public List<Employe> retrieveAllEmploye() {
		List<Employe>employes=null;
		
			try {
			
			l.info("In Method retrieveAllEmploye :");
			employes = (List<Employe>) employeRepository.findAll(); 
			l.debug("connexion à la DB Ok :"); 
			for (Employe employe : employes) {
				l.debug("user :" + employe.getNom()); 
			} 
			l.info("Out of Method retrieveAllUsers with Success" + employes.size());
		}catch (Exception e) {
			l.error("Out of Method retrieveAllUsers with Errors : " + e); 
		}

		return employes;
	}
	

	@Override
	public Employe addEmploye(Employe emp) {

	Employe emp_add = null; 
		
		try {
			l.info(" Methode addUser"); 
			emp_add = employeRepository.save(emp); 
			
			l.info("employee ajouter avec succes"+emp.getNom()); 
			
		} catch (Exception e) {

			l.error("error in addUser() : " + e);
		}
		
		return emp_add; 
	}

	@Override
	public void deleteEmploye(String id) {
		try {
			l.info("in method delete user");
			employeRepository.deleteById(Long.parseLong(id)); 
            l.info("user deleted successfully"+id);
			
		} catch (Exception e) {
			 
			 l.error("error in deleteUser() : ", e);
		}
		
	}

	@Override
	public Employe updateEmploye(Employe employes) {

		return null;
	}

	@Override
	public Employe retrieveEmploye(String id) {
		Employe emp1=null;
		try {
			l.info("methode recuperation de l'utilisateur");
			emp1 =  employeRepository.findById(Long.parseLong(id)).get(); 
			l.info("utilisateur retrouvé"+id);
			
		} catch (Exception e) {
			// TODO log ici : 
			l.error("error in retrieveUser() : " + e);
		}

		return emp1; 
	}

}
