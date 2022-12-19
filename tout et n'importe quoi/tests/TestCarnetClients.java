package fr.univartois.butinfo.ihm.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import static org.assertj.core.api.Assertions.*;
import fr.univartois.butinfo.ihm.client.CarnetClients;
import fr.univartois.butinfo.ihm.client.Client;
import fr.univartois.butinfo.ihm.client.ClientEntreprise;
import fr.univartois.butinfo.ihm.client.ClientParticulier;
import fr.univartois.butinfo.ihm.client.Genre;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
class TestCarnetClients {
	CarnetClients carnetTest;
	
	@BeforeEach
	public void initCarnet() {
		carnetTest = new CarnetClients("Test");
		ClientEntreprise clientTest = new ClientEntreprise("ZKTV","2 rue des huitres",20,"AAA");
		carnetTest.ajouterClient(clientTest);
	}
	
	@AfterEach
	public void delCarnet() {
		carnetTest = null;
	}
	
	@Test
	@Order(1)
	@DisplayName("Test du constructeur")
	public void testContruct() {
		//Given
		CarnetClients carnet = new CarnetClients("Nouveau Carnet !");
		//When
		String nom = carnet.getNom();
		//Then
		assertThat(nom).isEqualTo("Nouveau Carnet !");
	}
	
	@Test
	@Order(2)
	@DisplayName("Test du setNom")
	public void testSetNom() {
		//Given + When
		carnetTest.setNom("ACHETEURS");
		//Then
		assertThat(carnetTest.getNom()).isEqualTo("ACHETEURS");
	}
	
	@Test
	@Order(3)
	@DisplayName("Test de l'ajout d'un client + clients dans carnet")
	public void testAjoutClient() {
		//Given
		ClientParticulier client = new ClientParticulier("Fawkes","2 rue des fleurs",20,"Guy",Genre.Homme);
		//When
		carnetTest.ajouterClient(client);
		//Then
		assertThat(carnetTest.getNbClients()).isEqualTo(2);
		Client[] clients = carnetTest.clientsDansCarnet();
		assertThat(clients[1]).isEqualTo(client);
	}
	
	@Test
	@Order(4)
	@DisplayName("Test de la méthode clienst particuliers dans carnet")
	public void testClientsPart() {
		//Given
		ClientParticulier clientPart1 = new ClientParticulier("Fawkes","2 rue des fleurs",20,"Guy",Genre.Homme);
		ClientParticulier clientPart2 = new ClientParticulier("Kazuma","8 rue du soleil",90,"Kiryu",Genre.Homme);
		ClientEntreprise clientEnt1 = new ClientEntreprise("Umbrella","7 rue du fleuve",50,"AAA");
		ClientEntreprise clientEnt2 = new ClientEntreprise("Aperture","25 avenue de la science",999,"NON");
		carnetTest.ajouterClient(clientPart1);
		carnetTest.ajouterClient(clientPart2);
		carnetTest.ajouterClient(clientEnt1);
		carnetTest.ajouterClient(clientEnt2);
		//When
		Client[] listeClientsPart = carnetTest.clientsParticulierDansCarnet();
		//Then 
		assertThat(listeClientsPart.length).isEqualTo(2);
		assertThat(listeClientsPart[1]).isEqualTo(clientPart2);
	}
	
	@Test
	@Order(5)
	@DisplayName("Test de la méthode clients entreprise dans carnet")
	public void testClientsEnt() {
		//Given
		ClientParticulier clientPart1 = new ClientParticulier("Fawkes","2 rue des fleurs",20,"Guy",Genre.Homme);
		ClientParticulier clientPart2 = new ClientParticulier("Kazuma","8 rue du soleil",90,"Kiryu",Genre.Homme);
		ClientEntreprise clientEnt1 = new ClientEntreprise("Umbrella","7 rue du fleuve",50,"AAA");
		ClientEntreprise clientEnt2 = new ClientEntreprise("Aperture","25 avenue de la science",999,"NON");
		carnetTest.ajouterClient(clientPart1);
		carnetTest.ajouterClient(clientPart2);
		carnetTest.ajouterClient(clientEnt1);
		carnetTest.ajouterClient(clientEnt2);
		//When
		Client[] listeClientsEnt = carnetTest.clientsEntrepriseDansCarnet();
		//Then
		assertThat(listeClientsEnt.length).isEqualTo(3);
		assertThat(listeClientsEnt[1]).isEqualTo(clientEnt1);
	}
	
	@Test
	@Order(6)
	@DisplayName("Test de la recherche par mot clef")
	public void testMotClef() {
		//Given
		ClientParticulier clientPart1 = new ClientParticulier("Fawkes","2 rue des fleurs",20,"Guy",Genre.Homme);
		ClientParticulier clientPart2 = new ClientParticulier("Kazuma","8 rue du soleil",90,"Kiryu",Genre.Homme);
		ClientEntreprise clientEnt1 = new ClientEntreprise("Umbrella","7 rue du fleuve",50,"AAA");
		ClientEntreprise clientEnt2 = new ClientEntreprise("Aperture","25 avenue de la science",999,"NON");
		carnetTest.ajouterClient(clientPart1);
		carnetTest.ajouterClient(clientPart2);
		carnetTest.ajouterClient(clientEnt1);
		carnetTest.ajouterClient(clientEnt2);
		//When
		Client[] listeClientsRue = carnetTest.rechercherClientsParMotCle("rue");
		//Then
		assertThat(listeClientsRue.length).isEqualTo(4);
		assertThat(listeClientsRue[1]).isEqualTo(clientPart1);
	}
	
	@Test
	@Order(7)
	@DisplayName("Test de la recherche par référence")
	public void testRef() {
		//Given
		ClientParticulier clientPart1 = new ClientParticulier("Fawkes","2 rue des fleurs",20,"Guy",Genre.Homme);
		ClientParticulier clientPart2 = new ClientParticulier("Kazuma","8 rue du soleil",90,"Kiryu",Genre.Homme);
		ClientEntreprise clientEnt1 = new ClientEntreprise("Umbrella","7 rue du fleuve",50,"AAA");
		ClientEntreprise clientEnt2 = new ClientEntreprise("Aperture","25 avenue de la science",999,"NON");
		int ref = clientPart2.getReference();
		carnetTest.ajouterClient(clientPart1);
		carnetTest.ajouterClient(clientPart2);
		carnetTest.ajouterClient(clientEnt1);
		carnetTest.ajouterClient(clientEnt2);
		//When
		Client clientRecherche = carnetTest.rechercherClientParReference(ref);
		boolean meme = clientPart2.equals(clientRecherche);
		//Then
		assertThat(meme).isEqualTo(true);
	}
	
	@Test
	@Order(8)
	@DisplayName("Test de la suppression (client existe)")
	public void testSupprExiste() {
		//Given
		ClientParticulier clientPart1 = new ClientParticulier("Fawkes","2 rue des fleurs",20,"Guy",Genre.Homme);
		carnetTest.ajouterClient(clientPart1);
		//When
		assertThat(carnetTest.getNbClients()).isEqualTo(2);
		carnetTest.supprimerClient(clientPart1);
		//Then
		assertThat(carnetTest.getNbClients()).isEqualTo(1);
	}
	
	@Test
	@Order(9)
	@DisplayName("Test du est vide carnet avec clients")
	public void testVideFalse() {
		//Given + When
		boolean vide = carnetTest.estVide();
		//Then
		assertThat(vide).isEqualTo(false);
	}
	
	@Test
	@Order(10)
	@DisplayName("Test du est vide avec carnet vide")
	public void testVideTrue() {
		//Given
		CarnetClients carnetNouv = new CarnetClients("Il est vide");
		//When
		boolean vide = carnetNouv.estVide();
		//Then
		assertThat(vide).isEqualTo(true);
	}
	
	@Test
	@Order(11)
	@DisplayName("Test du est plein avec un carnet non plein")
	public void testPleinFalse() {
		//Given + When
		boolean plein = carnetTest.estPlein();
		//Then
		assertThat(plein).isEqualTo(false);
	}
	
	@Test
	@Order(12)
	@DisplayName("Test du est plein avec un carnet plein")
	public void testPleinTrue() {
		//Given
		ClientParticulier clientPart1 = new ClientParticulier("Fawkes","2 rue des fleurs",20,"Guy",Genre.Homme);
		ClientParticulier clientPart2 = new ClientParticulier("Kazuma","8 rue du soleil",90,"Kiryu",Genre.Homme);
		ClientEntreprise clientEnt1 = new ClientEntreprise("Umbrella","7 rue du fleuve",50,"AAA");
		ClientEntreprise clientEnt2 = new ClientEntreprise("Aperture","25 avenue de la science",999,"NON");
		ClientEntreprise clientEnt3 = new ClientEntreprise("Aperture","25 avenue de la science",999,"NON");
		ClientEntreprise clientEnt4 = new ClientEntreprise("Aperture","25 avenue de la science",999,"NON");
		ClientEntreprise clientEnt5 = new ClientEntreprise("Aperture","25 avenue de la science",999,"NON");
		ClientEntreprise clientEnt6 = new ClientEntreprise("Aperture","25 avenue de la science",999,"NON");
		ClientEntreprise clientEnt7 = new ClientEntreprise("Aperture","25 avenue de la science",999,"NON");
		ClientEntreprise clientEnt8 = new ClientEntreprise("Aperture","25 avenue de la science",999,"NON");
		carnetTest.ajouterClient(clientPart1);
		carnetTest.ajouterClient(clientPart2);
		carnetTest.ajouterClient(clientEnt1);
		carnetTest.ajouterClient(clientEnt2);
		carnetTest.ajouterClient(clientEnt3);
		carnetTest.ajouterClient(clientEnt4);
		carnetTest.ajouterClient(clientEnt5);
		carnetTest.ajouterClient(clientEnt6);
		carnetTest.ajouterClient(clientEnt7);
		carnetTest.ajouterClient(clientEnt8);
		//When
		boolean plein = carnetTest.estPlein();
		//Then
		assertThat(plein).isEqualTo(true);
	}
	
	@Test
	@Order(13)
	@DisplayName("Test de la suppression (le client n'existe pas)")
	public void testSupprEchec() {
		//Given
		ClientParticulier clientPart1 = new ClientParticulier("Fawkes","2 rue des fleurs",20,"Guy",Genre.Homme);
		//When
		assertThat(carnetTest.getNbClients()).isEqualTo(1);
		carnetTest.supprimerClient(clientPart1);
		//Then
		assertThat(carnetTest.getNbClients()).isEqualTo(1);
	}
	
	@Test
	@Order(14)
	@DisplayName("Test de la recherche de client par référence (le client n'existe pas)")
	public void testRechercheIndEchec() {
		//Given
		ClientParticulier clientPart1 = new ClientParticulier("Fawkes","2 rue des fleurs",20,"Guy",Genre.Homme);
		//When
		Client clientRech = carnetTest.rechercherClientParReference(clientPart1.getReference());
		//Then
		assertThat(clientRech).isEqualTo(null);
	}
	
}
