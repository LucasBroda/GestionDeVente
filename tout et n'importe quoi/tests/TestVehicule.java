package fr.univartois.butinfo.ihm.test;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.TestMethodOrder;

import fr.univartois.butinfo.ihm.vehicule.DummyVehicule;

@TestMethodOrder(OrderAnnotation.class)
class TestVehicule {
	DummyVehicule vehiculeTest; 
	
	@BeforeEach
	public void initVehicule() {
		vehiculeTest = new DummyVehicule("555-555-555","Celica","Toyota",172.2,1995);
	}
	
	@AfterEach
	public void delVehicule() {
		vehiculeTest = null;
	}
	
	@Test
	@Order(1)
	@DisplayName("Test du constructeur")
	public void testConstructeur() {
		//Given
		String matricule = "999-999-99";
		String modele = "509";
		String marque = "Fiat";
		Double kilom = 999.99;
		int annee = 1927;
		//When
		DummyVehicule gastonMobile = new DummyVehicule(matricule,modele,marque,kilom,annee);
		//Then
		assertThat(gastonMobile.getNum_immatriculation()).isEqualTo(matricule);
		assertThat(gastonMobile.getModele()).isEqualTo(modele);
		assertThat(gastonMobile.getMarque()).isEqualTo(marque);
		assertThat(gastonMobile.getKilometrage()).isEqualTo(kilom);
		assertThat(gastonMobile.getMise_circulation()).isEqualTo(annee);
	}
	
	@Test
	@Order(2)
	@DisplayName("Test du setter du kilometrage")
	public void testSetKilom() {
		//Given + When
		vehiculeTest.setKilometrage(50.50);
		//Then
		assertThat(vehiculeTest.getKilometrage()).isEqualTo(50.50);
	}

	@Test
	@Order(3)
	@DisplayName("Test du toString")
	public void testToString(){
		//Given + When
		String info = vehiculeTest.toString();
		//Then ("555-555-555","Celica","Toyota",172.2,1995);
		assertThat(info).isEqualTo("numéro d'immatriculation : 555-555-555 Modele : Celica Marque : Toyota Kilométrage : 172.2 mise en circulation : 1995");
	}
}
