package fr.univartois.butinfo.ihm.test;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import fr.univartois.butinfo.ihm.client.ClientEntreprise;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
class TestClientEntreprise {
	private ClientEntreprise clientTest;
	
	@BeforeEach
	public void initClientTest(){
		clientTest = new ClientEntreprise("ZKTV","2 rue des huitres",20,"AAA");
	}
	
	@AfterEach
	public void delClientTest() {
		clientTest = null;
	}
	
	@Test
	@Order(1)
	@DisplayName("Test du constructeur")
	public void testConstructeur() {
		//Given
		String nom = "Umbrella";
		String adresse = "3 rue de la Boustifaille";
		int points = 15;
		String contact = "Non";
		//When
		ClientEntreprise UmbrellaCorp = new ClientEntreprise(nom,adresse,points,contact);
		//Then
		assertThat(UmbrellaCorp.getPointsFidelite()).isEqualTo(15 );
		assertThat(UmbrellaCorp.getNom()).isEqualTo("Umbrella");
		assertThat(UmbrellaCorp.getAdresse()).isEqualTo("3 rue de la Boustifaille");
		assertThat(UmbrellaCorp.getReference()).isEqualTo(1);
		assertThat(UmbrellaCorp.getContact()).isEqualTo("Non");
	}

	@Test
	@Order(2)
	@DisplayName("Test du setContact")
	public void testSetPrenom() {
		//Given + When
		clientTest.setContact("Oui!");
		//Then
		assertThat(clientTest.getContact()).isEqualTo("Oui!");
	}
	
	
	@Test
	@Order(3)
	@DisplayName("Test du toString")
	public void testToString() {
		//Given + When
		String texte = clientTest.toString();
		//Then
		assertThat(texte).isEqualTo("Référence :\t\t"+clientTest.getReference()+"\nNom :\t\t\tZKTV\nAdresse :\t\t2 rue des huitres\nPoints Fidélité :\t20\nRistourne (%) :\t\t0\nContact :\t\tAAA");
	}
}
