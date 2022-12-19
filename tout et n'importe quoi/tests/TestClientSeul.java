package fr.univartois.butinfo.ihm.test;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.univartois.butinfo.ihm.client.Client;
import fr.univartois.butinfo.ihm.client.DummyClient;

@TestMethodOrder(OrderAnnotation.class)
class TestClientSeul {
	private Client clientTest;
	private Client[] listeCli = new Client[2];
	
	@BeforeEach
	public void initClientTest(){
		clientTest = new DummyClient("Robert","2 rue des fleurs",20);
		listeCli[0] = clientTest;
	}
	
	@AfterEach
	public void delClientTest() {
		clientTest = null;
	}
	@Test
	@Order(0)
	@DisplayName("ATest du Constructeur (+auto incrémentation de l'id)")
	public void atestConstructeur() {
		//Given
		String nom = "Visal";
		String adresse = "3 rue de la Boustifaille";
		int points = 3;
		//When
		DummyClient Visal = new DummyClient(nom,adresse,points);
		//Then
		assertThat(Visal.getPointsFidelite()).isEqualTo(3);
		assertThat(Visal.getNom()).isEqualTo("Visal");
		assertThat(Visal.getAdresse()).isEqualTo("3 rue de la Boustifaille");
	}
	
	@Test
	@Order(5)
	@DisplayName("Test du setNom (fonctionne)")
	public void testSetNomCorrect(){
		//Given
		String nom = "Bob";
		//When
		clientTest.setNom(nom);
		//Then
		assertThat(clientTest.getNom()).isEqualTo("Bob");
	}
	
	@Test
	@Order(2)
	@DisplayName("Test du setNom (chaîne de caractères nulle)")
	public void testSetNomIncorrect() {
		//given
		String nom = null;
		//When
		clientTest.setNom(nom);
		//Then
		assertThat(clientTest.getNom()).isEqualTo(null);
	}
	
	
	@Test
	@Order(3)
	@DisplayName("Test du setteur des points de fidélité")
	public void testSetPointsFidelite() {
		//given + when
		clientTest.setPointsFidelite(80);
		//Then
		assertThat(clientTest.getPointsFidelite()).isEqualTo(80);
	}
	
	@Test
	@Order(4)
	@DisplayName("Test du setteur d'adresse")
	public void testSetAdresse() {
		//Given + When
		clientTest.setAdresse("7 rue de Roubaix");
		//Then
		assertThat(clientTest.getAdresse()).isEqualTo("7 rue de Roubaix");
	}
	
	@Test
	@Order(6)
	@DisplayName("Test de la ristourne (points de fidélité < 100")
	public void testRistourne1() {
		//given + when
		int ristourne = clientTest.getRistourne();
		//then
		assertThat(ristourne).isEqualTo(0);
	}
	
	@Test
	@Order(7)
	@DisplayName("Test de la ristourne (points de fidélité > 100 et <499")
	public void testRistourne2() {
		//Given
		clientTest.setPointsFidelite(150);
		//When
		int ristourne = clientTest.getRistourne();
		//Then
		assertThat(ristourne).isEqualTo(5);
	}
	
	@Test
	@Order(8)
	@DisplayName("Test de la ristourne (points de fidélité > 499 et <999")
	public void testRistourne3() {
		//Given
		clientTest.setPointsFidelite(540);
		//When
		int ristourne = clientTest.getRistourne();
		//Then
		assertThat(ristourne).isEqualTo(10);
	}
	
	@Test
	@Order(9)
	@DisplayName("Test de la ristourne (points de fidélité >999")
	public void testRistourne4() {
		//Given
		clientTest.setPointsFidelite(1500);
		//When
		int ristourne = clientTest.getRistourne();
		//Then
		assertThat(ristourne).isEqualTo(15);
	}
	
		
	@Test
	@Order(10)
	@DisplayName("Test du toString")
	public void testToString() {
		//Given + When
		String texte = clientTest.toString();
		//Then
		assertThat(texte).isEqualTo("Référence :\t\t"+clientTest.getReference()+"\nNom :\t\t\tRobert\nAdresse :\t\t2 rue des fleurs\nPoints Fidélité :\t20\nRistourne (%) :\t\t0");
	}
	
	@Test
	@Order(11)
	@DisplayName("Test du equals (personnes différentes)")
	public void testEqualsDiff() {
		//Given
		String nom = "Georges";
		String adresse = "3 rue de la Boustifaille";
		int points = 3;
		Client georges = new DummyClient(nom,adresse,points);
		//When
		boolean memePersonne = clientTest.equals(georges);
		//Then
		assertThat(memePersonne).isEqualTo(false);
	}
	
	@Test
	@Order(12)
	@DisplayName("Test du equals (même personne)")
	public void testEqualsMeme() {
		//Given + When
		boolean memePersonne = clientTest.equals(clientTest);
		//Then
		assertThat(memePersonne).isEqualTo(true);
	}
	
	@Test
	@Order(13)
	@DisplayName("Test du tri de tableau de clients (liste non triée)")
	public void testTriListeNonTriee() {
		//Given
		String nom = "Georges";
		String adresse = "3 rue de la Boustifaille";
		int points = 3;
		Client georges = new DummyClient(nom,adresse,points);
		listeCli[1] = georges;
		//When
		Client.trierTabClients(listeCli);
		int idPrem = listeCli[0].getReference();
		//Then
		assertThat(idPrem).isEqualTo(georges.getReference());
	}
	
	@Test
	@Order(14)
	@DisplayName("Test du tri de tableau de clients (liste non triée)")
	public void testTriListeTriee() {
		//Given
		String nom = "Zorglub";
		String adresse = "3 rue de la Boustifaille";
		int points = 3;
		Client zorglub = new DummyClient(nom,adresse,points);
		listeCli[1] = zorglub;
		//When
		Client.trierTabClients(listeCli);
		int idPrem = listeCli[0].getReference();
		//Then
		assertThat(idPrem).isEqualTo(clientTest.getReference());
	}
}
