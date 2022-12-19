package fr.univartois.butinfo.ihm.test;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.univartois.butinfo.ihm.conducteur.Commercial;
import fr.univartois.butinfo.ihm.conducteur.Permis;

@TestMethodOrder(OrderAnnotation.class)
class TestCommercial {
	Commercial commercialTest;
	
	@BeforeEach
	public void initCommercial() {
		commercialTest = new Commercial("Pernaut","Jean-Pierre","4123",Permis.B);
	}
	
	@AfterEach
	public void delCommercial() {
		commercialTest = null;
	}
	
	@Test
	@Order(1)
	@DisplayName("Test du constructeur")
	public void testConstructeur() {
		//Given
		String nom = "Bidule";
		String prenom = "Pierre-Paul-Jacques";
		String numPermis = "1234";
		Permis typePermis = Permis.A;
		//When
		Commercial bidule = new Commercial(nom,prenom,numPermis,typePermis);
		//Then
		assertThat(bidule.getNom()).isEqualTo(nom);
		assertThat(bidule.getPrenom()).isEqualTo(prenom);
		assertThat(bidule.getNum_permis()).isEqualTo(numPermis);
		assertThat(bidule.getType()).isEqualTo(typePermis);
		assertThat(bidule.getNbVisites()).isEqualTo(0);
	}
	
	@Test
	@Order(2)
	@DisplayName("Test du setNbVisites")
	public void testSetNbVisites() {
		//Given + When
		commercialTest.setNbVisites(15);
		//Then
		assertThat(commercialTest.getNbVisites()).isEqualTo(15);
	}
	
	@Test
	@Order(3)
	@DisplayName("Test du toString")
	public void testToString() {
		//Given + When
		String string = commercialTest.toString();
		//Then
		assertThat(string).isEqualTo("[Commercial]\nNombres Visites : 0\nnom = Pernaut\nprenom = Jean-Pierre\nnum_permis = 4123\ntype= B");
	}
}
