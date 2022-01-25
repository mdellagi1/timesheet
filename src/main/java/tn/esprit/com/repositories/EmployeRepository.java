package tn.esprit.com.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.com.Entities.Employe;

public interface EmployeRepository extends CrudRepository<Employe, Long> {

}
