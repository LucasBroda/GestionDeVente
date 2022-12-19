package fr.univartois.butinfo.ihm.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.univartois.butinfo.ihm.client.ClientParticulier;
import fr.univartois.butinfo.ihm.client.Genre;
@TestMethodOrder(OrderAnnotation.class)
class TestClientParticulier {
	private ClientParticulier clientTest;
	
	@BeforeEach
	public void initClientTest(){
		clientTest = new ClientParticulier("Fawkes","2 rue des fleurs",20,"Guy",Genre.Homme);
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
		String nom = "Visal";
		String adresse = "3 rue de la Boustifaille";
		int points = 3;
		String prenom = "Jean-Phi";
		Genre genre = Genre.Homme;
		//When
		ClientParticulier Visal = new ClientParticulier(nom,adresse,points,prenom,genre);
		//Then
		assertThat(Visal.getPointsFidelite()).isEqualTo(3);
		assertThat(Visal.getNom()).isEqualTo("Visal");
		assertThat(Visal.getAdresse()).isEqualTo("3 rue de la Boustifaille");
		assertThat(Visal.getPrenom()).isEqualTo("Jean-Phi");
		assertThat(Visal.getGenre()).isEqualTo(Genre.Homme);
	}

	@Test
	@Order(2)
	@DisplayName("Test du setPrenom")
	public void testSetPrenom() {
		//Given + When
		clientTest.setPrenom("Nikole");
		//Then
		assertThat(clientTest.getPrenom()).isEqualTo("Nikole");
	}
	
	@Test
	@Order(3)
	@DisplayName("Test du setGenre")
	public void testSetGenre() {
		//Given + When
		clientTest.setGenre(Genre.Femme);
		//Then
		assertThat(clientTest.getGenre()).isEqualTo(Genre.Femme);
	}
	
	@Test
	@Order(4)
	@DisplayName("Test du toString")
	public void testToString() {
		//Given + When
		String texte = clientTest.toString();
		//Then
		assertThat(texte).isEqualTo("Référence :\t\t"+clientTest.getReference()+"\nNom :\t\t\tFawkes\nAdresse :\t\t2 rue des fleurs\nPoints Fidélité :\t20\nRistourne (%) :\t\t0\nPrénom :\t\tGuy\nGenre :\t\t\tHomme");
	}
}
