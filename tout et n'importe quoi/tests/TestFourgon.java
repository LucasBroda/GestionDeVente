package fr.univartois.butinfo.ihm.test;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.univartois.butinfo.ihm.conducteur.Livreur;
import fr.univartois.butinfo.ihm.vehicule.Fourgon;


@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class TestFourgon {
	@Mock
	Livreur livreur;
	
	@Mock
	Livreur livreur2;
	
	Fourgon fourgonTest;
	
	@BeforeEach
	public void initFourgon() {
		fourgonTest = new Fourgon("555-555-555","Celica","Toyota",172.2,1995,45.5,32.2,livreur);
	}
	
	@AfterEach
	public void delFourgon() {
		fourgonTest = null;
	}
	
	@Test
	@Order(1)
	@DisplayName("Test du constructeur")
	public void testConstructeur(){
		//Given
		String matricule = "999-999-99";
		String modele = "509";
		String marque = "Fiat";
		Double kilom = 999.99;
		int annee = 1927;
		Double poids = 40.5;
		Double volume = 30.2;
		//When
		Fourgon gastonMobile = new Fourgon(matricule,modele,marque,kilom,annee,poids,volume,livreur);
		//Then
		assertThat(gastonMobile.getNum_immatriculation()).isEqualTo(matricule);
		assertThat(gastonMobile.getModele()).isEqualTo(modele);
		assertThat(gastonMobile.getMarque()).isEqualTo(marque);
		assertThat(gastonMobile.getKilometrage()).isEqualTo(kilom);
		assertThat(gastonMobile.getMise_circulation()).isEqualTo(annee);
		assertThat(gastonMobile.getPoids_max()).isEqualTo(poids);
		assertThat(gastonMobile.getVolume_max()).isEqualTo(volume);
		assertThat(gastonMobile.getLivreur()).isEqualTo(livreur);
	}
	
	@Test
	@Order(2)
	@DisplayName("Test du setLivreur")
	public void testSetLivreur() {
		//Given + When
		fourgonTest.setLivreur(livreur2);
		//Then
		assertThat(fourgonTest.getLivreur()).isEqualTo(livreur2);
	}
	
	@Test
	@Order(3)
	@DisplayName("test du enleverLivreur")
	public void testEneleveLivreur() {
		//Given + When
		fourgonTest.enleverLivreur();
		//Then
		assertThat(fourgonTest.getLivreur()).isEqualTo(null);
	}
	
	@Test
	@Order(4)
	@DisplayName("Test du toString")
	public void testToString() {
		//Given
		when(livreur.toString()).thenReturn("Livreur");
		//When
		String string = fourgonTest.toString();
		
		//Then Toyota",172.2,1995,45.5,32.2,livreur);
		assertThat(string).isEqualTo("[Fourgon]\nnuméro d'immatriculation : 555-555-555 Modele : Celica Marque : Toyota Kilométrage : 172.2 mise en circulation : 1995 poids max : 45.5 volume max : 32.2\nLivreur");
	}
	
}
