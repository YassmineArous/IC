package tn.esprit.spring;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.EmployeServiceImpl;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeServiceIMPLtest {
	@Autowired
	EmployeServiceImpl ESER;
	@Autowired
	EmployeRepository empreppo;
	@Test
	public void authtest(){
		Assert.assertEquals("firos@live.be",ESER.auth2("firos@live.be","firo123"));
		
	}
	
	@Test
	public void addtest(){
	int id=	ESER.addOrUpdateEmploye(new Employe(1,"firas", "trabelsi", "firos@live.be", "firo123", true, Role.ADMINISTRATEUR));
	Assert.assertEquals(1, id);
	}
	
	

}
