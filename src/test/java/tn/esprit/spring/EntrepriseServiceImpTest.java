package tn.esprit.spring;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.DepartementServiceImpl;
import tn.esprit.spring.services.EntrepriseServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EntrepriseServiceImpTest {
	@Autowired
	EntrepriseServiceImpl entreprise;
	@Autowired
	DepartementServiceImpl departement;

	@Test
	public void TestAjouterEntreprise() {
		Entreprise ent = new Entreprise("esprit", "aaaa");
		int ajoutEntreprise = entreprise.ajouterEntreprise(ent);
		assertEquals(ent.getId(), ajoutEntreprise);
	}

	/*
	 * @Test public void TestdeleteDepartementById(){
	 * System.out.println(entreprise.getEntrepriseById(3));
	 * entreprise.deleteEntrepriseById(3);
	 * assertNull(entreprise.getEntrepriseById(3));
	 * 
	 * }
	 */

	@Test
	public void TestUpdateEntrepriseNomById() {
		Entreprise ent = new Entreprise("esprit", "aaaa");
		ent.setId(1);
		String nomEntreprise = "Test";
		Entreprise entUpdated = entreprise.UpdateNomEntrepriseById(nomEntreprise, ent.getId());
		assertEquals("Test", entUpdated.getName());
	}

	@Test
	public void TestgetAllEntreprise() {
		List<Entreprise> ents = entreprise.getAllEntreprise();
		assertEquals(39, ents.size());
	}

	@Test
	public void TestgetEntrepriseById() {
		Entreprise ent = entreprise.getEntrepriseById(6);
		assertEquals(6, ent.getId());

	}
}
