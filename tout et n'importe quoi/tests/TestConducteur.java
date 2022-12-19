package fr.univartois.butinfo.ihm.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.univartois.butinfo.ihm.conducteur.DummyConducteur;
import fr.univartois.butinfo.ihm.conducteur.Permis;

@TestMethodOrder(OrderAnnotation.class)
class TestConducteur {
	DummyConducteur conducteurTest;
	
	@BeforeEach
	public void initConducteur() {
		conducteurTest  = new DummyConducteur("De C'est Pas Sorcier","Marcel","6845",Permis.C);
	}
	
	@AfterEach
	public void delConducteur() {
		conducteurTest = null;
	}
	
	@Test
	@Order(1)
	@DisplayName("Test du constructeur")
	void testConstructeur() {
		//Given
		String nom = "Bidule";
		String prenom = "Pierre-Paul-Jacques";
		String numPermis = "1234";
		Permis typePermis = Permis.A;
		//When
		DummyConducteur bidule = new DummyConducteur(nom,prenom,numPermis,typePermis);
		//Then
		assertThat(bidule.getNom()).isEqualTo(nom);
		assertThat(bidule.getPrenom()).isEqualTo(prenom);
		assertThat(bidule.getNum_permis()).isEqualTo(numPermis);
		assertThat(bidule.getType()).isEqualTo(typePermis);
	}
	
	@Test
	@Order(2)
	@DisplayName("Test du equals (noms différents")
	void testEqualsFalseNom() {
		//Given
		String nom = "Bidule";
		String prenom = "Marcel";
		String numPermis = "1234";
		Permis typePermis = Permis.A;
		DummyConducteur bidule = new DummyConducteur(nom,prenom,numPermis,typePermis);
		//When
		boolean meme = conducteurTest.equals(bidule, conducteurTest);
		//Then
		assertThat(meme).isEqualTo(false);
	}
	
	@Test
	@Order(3)
	@DisplayName("Test du equals (même personne)")
	void testEqualsTrue() {
		//Given + When
		boolean meme = conducteurTest.equals(conducteurTest,conducteurTest);
		//Then
		assertThat(meme).isEqualTo(true);
	}
	
	@Test
	@Order(4)
	@DisplayName("Test du equals (prénoms différents")
	void testEqualsFalsePren() {
		//Given
		String nom = "De C'est Pas Sorcier";
		String prenom = "Jean";
		String numPermis = "1234";
		Permis typePermis = Permis.A;
		DummyConducteur bidule = new DummyConducteur(nom,prenom,numPermis,typePermis);
		//When
		boolean meme = conducteurTest.equals(bidule, conducteurTest);
		//Then
		assertThat(meme).isEqualTo(false);
	}
	@Test
	@Order(5)
	@DisplayName("Test du toString")
	void testToString() {
		//Given + When
		String string = conducteurTest.toString();
		//Then
		assertThat(string).isEqualTo("nom = De C'est Pas Sorcier\nprenom = Marcel\nnum_permis = 6845\ntype= C");
	}
}
