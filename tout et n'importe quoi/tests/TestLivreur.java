package fr.univartois.butinfo.ihm.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.univartois.butinfo.ihm.conducteur.Livreur;
import fr.univartois.butinfo.ihm.conducteur.Permis;

@TestMethodOrder(OrderAnnotation.class)
class TestLivreur {
	Livreur livreurTest;
	
	@BeforeEach
	public void initLivreur() {
		livreurTest = new Livreur("Pernaut","Jean-Pierre","4123",Permis.B);
	}
	
	@AfterEach
	public void suprLivreur() {
		livreurTest = null;
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
		Livreur bidule = new Livreur(nom,prenom,numPermis,typePermis);
		//Then
		assertThat(bidule.getNom()).isEqualTo(nom);
		assertThat(bidule.getPrenom()).isEqualTo(prenom);
		assertThat(bidule.getNum_permis()).isEqualTo(numPermis);
		assertThat(bidule.getType()).isEqualTo(typePermis);
		assertThat(bidule.getNbHeures()).isEqualTo(0);
	}
	
	@Test
	@Order(2)
	@DisplayName("Test du setNbHeures")
	public void testSetNbHeures() {
		//Given + When
		livreurTest.setNbHeures(150);
		//Then
		assertThat(livreurTest.getNbHeures()).isEqualTo(150);
	}
	
	@Test
	@Order(3)
	@DisplayName("Test du toString")
	public void testToString() {
		//Given + When
		String string = livreurTest.toString();
		//Then
		assertThat(string).isEqualTo("[Livreur]\nNombres Heures : 0\nnom = Pernaut\nprenom = Jean-Pierre\nnum_permis = 4123\ntype= B");
	}
}
