package tn.esprit.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.com.Entities.Employe;
import tn.esprit.com.Entities.Role;

import tn.esprit.com.services.IEmployeService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EmployeServiceImplTest {
	@Autowired
	IEmployeService es;
	@Test
	@Order(1)
	public void testretrieveAllEmploye() {
		List<Employe> listEmplooyes =es.retrieveAllEmploye();
		Assertions.assertEquals(0,listEmplooyes.size());
	}
	@Test
	@Order(2)
	public void testaddEmploye() throws ParseException {
		Employe e1= new Employe("mongi","dellagi","mongi.dellagi@esprit.tn","123456",true,Role.ADMINISTRATEUR);
		Employe empadded= es.addEmploye(e1);
		Assertions.assertEquals(e1.getNom(),empadded.getNom());
	}
	@Test
	@Order(3)
	public void testretrieveAllEmployeSeconf() {
		List<Employe> listEmplooyes =es.retrieveAllEmploye();
		Assertions.assertEquals(1,listEmplooyes.size());
	}
	@Test
	@Order(4)
	public void testUpdateEmploye() throws ParseException{
		Employe e1 = new Employe(1L,"mongi","dell","mongi.dell@gmail.com","123123",false,Role.INGENIEUR);
		Employe empadded= es.addEmploye(e1);
		Assertions.assertEquals(e1.getNom(),empadded.getNom());
		
	}
	@Order(5)
	public void testRetrieveEmploye(){
		Employe userRetieved = es.retrieveEmploye("1");
		Assertions.assertEquals(1L, userRetieved.getId());
	}
	@Test
	@Order(6)
	public void testDeletEmploye(){
		es.deleteEmploye("1");
	
		List<Employe> listUserss = es.retrieveAllEmploye();
		Assertions.assertEquals(0, listUserss.size());
	}
}
