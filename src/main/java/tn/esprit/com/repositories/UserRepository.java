package tn.esprit.com.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.com.Entities.User;

@Repository
public interface UserRepository extends  CrudRepository<User, Long> {

}
