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

import fr.univartois.butinfo.ihm.conducteur.Commercial;
import fr.univartois.butinfo.ihm.vehicule.Voiture;


@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class TestVoiture {
	@Mock
	Commercial commercial;
	
	@Mock
	Commercial commercial2;
	
	Voiture voitureTest;
	
	@BeforeEach
	public void initvoiture() {
		voitureTest = new Voiture("555-555-555","Celica","Toyota",172.2,1995,commercial);
	}
	
	@AfterEach
	public void delvoiture() {
		voitureTest = null;
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
		//When
		Voiture gastonMobile = new Voiture(matricule,modele,marque,kilom,annee,commercial);
		//Then
		assertThat(gastonMobile.getNum_immatriculation()).isEqualTo(matricule);
		assertThat(gastonMobile.getModele()).isEqualTo(modele);
		assertThat(gastonMobile.getMarque()).isEqualTo(marque);
		assertThat(gastonMobile.getKilometrage()).isEqualTo(kilom);
		assertThat(gastonMobile.getMise_circulation()).isEqualTo(annee);
		assertThat(gastonMobile.getCommercial()).isEqualTo(commercial);
	}
	
	@Test
	@Order(2)
	@DisplayName("Test du setCommercial")
	public void testSetCommercial() {
		//Given + When
		voitureTest.setCommercial(commercial2);
		//Then
		assertThat(voitureTest.getCommercial()).isEqualTo(commercial2);
	}
	
	@Test
	@Order(3)
	@DisplayName("test du enleverCommercial")
	public void testEneleveCommercial() {
		//Given + When
		voitureTest.enleverCommercial();
		//Then
		assertThat(voitureTest.getCommercial()).isEqualTo(null);
	}
	
	@Test
	@Order(4)
	@DisplayName("Test du toString")
	public void testToString() {
		//Given
		when(commercial.toString()).thenReturn("Commercial");
		//When
		String string = voitureTest.toString();
		
		//Then
		assertThat(string).isEqualTo("[Voiture]\nnuméro d'immatriculation : 555-555-555 Modele : Celica Marque : Toyota Kilométrage : 172.2 mise en circulation : 1995\nCommercial");
	}
	
}

