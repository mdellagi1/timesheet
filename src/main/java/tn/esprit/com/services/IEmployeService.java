package tn.esprit.com.services;

import java.util.List;

import tn.esprit.com.Entities.Employe;
import tn.esprit.com.Entities.User;

public interface IEmployeService {
	List<Employe>  retrieveAllEmploye();
	Employe addEmploye(Employe e);
	void deleteEmploye(String id);
	Employe updateEmploye(Employe e);
	Employe retrieveEmploye(String id);
}
