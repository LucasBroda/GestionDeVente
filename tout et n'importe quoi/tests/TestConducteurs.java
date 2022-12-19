package fr.univartois.butinfo.ihm.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import static org.junit.Assert.assertThrows;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.univartois.butinfo.ihm.conducteur.Commercial;
import fr.univartois.butinfo.ihm.conducteur.Conducteur;
import fr.univartois.butinfo.ihm.conducteur.Conducteurs;
import fr.univartois.butinfo.ihm.conducteur.ExceptionConducteurDejaPresent;
import fr.univartois.butinfo.ihm.conducteur.ExceptionConducteurPasPresent;
import fr.univartois.butinfo.ihm.conducteur.Livreur;
import fr.univartois.butinfo.ihm.conducteur.Permis;



@TestMethodOrder(OrderAnnotation.class)
class TestConducteurs {
	Conducteurs conducteursTest;
	Livreur liv1 = new Livreur("Pernaut","Jean-Pierre","4123",Permis.B);
	Commercial com1 = new Commercial("Chirac","Jacques","1234",Permis.C);
	Livreur liv2 = new Livreur("Kujo","Jotaro","2145",Permis.A);
	Commercial com2 = new Commercial("Philibert","Jostophe","8787",Permis.B);
	
	@BeforeEach
	public void initConducteurs() throws ExceptionConducteurDejaPresent{
		conducteursTest = new Conducteurs();
		conducteursTest.addConducteur(liv1);
		conducteursTest.addConducteur(com1);
		conducteursTest.addConducteur(liv2);
		conducteursTest.addConducteur(com2);
	}
	
	@AfterEach
	public void delConducteurs() {
		conducteursTest = null;
	}
	
	@Test
	@Order(1)
	@DisplayName("Test du constructeur")
	public void testConstructeur() {
		//Given + When
		Conducteurs conds = new Conducteurs();
		List<Conducteur> listConds = conds.getList();
		//Then
		assertThat(listConds.size()).isEqualTo(0);
	}
	@Test
	@Order(2)
	@DisplayName("Test du tri de la liste")
	public void testTriArrayList() {
		//Given + When
		conducteursTest.trierNom();
		List<Conducteur> listeCond = conducteursTest.getList();
		//Then
		assertThat(listeCond.get(0)).isEqualTo(com1);
		assertThat(listeCond.get(1)).isEqualTo(liv2);
		assertThat(listeCond.get(2)).isEqualTo(liv1);
		assertThat(listeCond.get(3)).isEqualTo(com2);
	}
	
	@Test
	@Order(3)
	@DisplayName("Test de l'ajout (personne déjà présente)")
	public void testAddDejaPres(){
		assertThrows(ExceptionConducteurDejaPresent.class, () -> conducteursTest.addConducteur(com2));
	}
	
	@Test
	@Order(4)
	@DisplayName("Test de la supression (personne présente)")
	public void testDelDejaPres() throws ExceptionConducteurPasPresent {
		//Given
		List<Conducteur> listeCond = conducteursTest.getList();
		assertThat(listeCond.size()).isEqualTo(4);
		//When
		conducteursTest.supConducteur(com1);
		listeCond = conducteursTest.getList();
		//Then
		assertThat(listeCond.size()).isEqualTo(3);
	}
	
	@Test
	@Order(5)
	@DisplayName("Test de la supression (personne non présente)")
	public void testDelNonPres() {
		assertThrows(ExceptionConducteurPasPresent.class, () -> conducteursTest.supConducteur(new Livreur("Test","Teste","AAAA",Permis.A)));
	}
	
	@Test
	@Order(6)
	@DisplayName("Test de la liste de livreurs uniquement")
	public void testLivreurs() {
		//Given + When
		ArrayList<Livreur> listeLivreurs = conducteursTest.onlyLivreur();
		//Then
		assertThat(listeLivreurs.size()).isEqualTo(2);
	}
	
	@Test
	@Order(7)
	@DisplayName("Test de la liste de commerciaux uniquement")
	public void testCommerciaux() {
		//Given + When
		ArrayList<Commercial> listeCom = conducteursTest.onlyCommercial();
		//Then
		assertThat(listeCom.size()).isEqualTo(2);
	}
}
