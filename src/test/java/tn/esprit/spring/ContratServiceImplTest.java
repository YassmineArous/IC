package tn.esprit.spring;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ContratServiceImplTest {
	@Autowired 
	IContratService cs; 
	IEmployeService es; 

	@Test
	public void testAddContrat() throws ParseException {
	   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date d = dateFormat.parse("2020-03-23");
		Employe e = new Employe(1,"yassmine", "yassmine", "employee@esprit.tn", null, true, Role.CHEF_DEPARTEMENT);
		Contrat c = new Contrat(d, "CDI" ,21234567,e,1500); 
		Contrat contratAdded =cs.addContrat(c); 
		assertEquals(c.getReference(), contratAdded.getReference());
	}
	@Test
	public void testModifyContrat() throws ParseException   {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2020-03-23");
		Employe e = new Employe(1,"yassmine", "yassmine", "employee@esprit.tn", null, true, Role.CHEF_DEPARTEMENT);
		Contrat c = new Contrat(45,d, "CDI" ,22345678,e,2000);  
		Contrat contratAdded =cs.updateContrat(c);
		assertEquals(c.getReference(), contratAdded.getReference());
	}
	@Test
	public void testRetrieveAllContrats() {
		List<Contrat> listContrats = cs.getAllContrats(); 
		assertEquals(2, listContrats.size());
	}
	
	@Test
	public void testRetrieveContrat() {
		Contrat contratRetrieved = cs.retrieveContrat(46); 
		assertEquals(46, contratRetrieved.getReference());
	}
	@Test
	public void testDeleteContrat(){
		cs.deleteContrat(48);
		assertNull(cs.retrieveContrat(47));
		
	}
	
	


}
