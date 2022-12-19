package fr.univartois.butinfo.ihm.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.univartois.butinfo.ihm.conducteur.Commercial;
import fr.univartois.butinfo.ihm.conducteur.ExceptionConducteurDejaPresent;
import fr.univartois.butinfo.ihm.conducteur.Livreur;
import fr.univartois.butinfo.ihm.vehicule.ExceptionVehiculeDejaPresent;
import fr.univartois.butinfo.ihm.vehicule.ExceptionVehiculePasPresent;
import fr.univartois.butinfo.ihm.vehicule.FlotteVehicules;
import fr.univartois.butinfo.ihm.vehicule.Fourgon;
import fr.univartois.butinfo.ihm.vehicule.Voiture;
import fr.univartois.butinfo.ihm.vehicule.Vehicule;
import org.junit.jupiter.api.Order;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class TestFlotteVehicules {
	FlotteVehicules flotteTest; 
	@Mock
	Commercial com;
	@Mock
	Livreur liv;
	
	Voiture voit1 = new Voiture("555-555-555","Celica","Toyota",172.2,1995,com);
	Voiture voit2 = new Voiture("000-000-000","Mobile","Bat",2.3,2024,com);
	Fourgon fourg1 = new Fourgon("512-512-512","Modele","Marque",5.5,2020,102.3,15.6,liv);
	Fourgon fourg2 = new Fourgon("888-888-888","Exemple","Test",4.4,2002,103.54,58.8,liv);
	
	@BeforeEach
	public void initFlotte() throws ExceptionVehiculeDejaPresent {
		flotteTest = new FlotteVehicules();
		flotteTest.addVehicule(voit2);
		flotteTest.addVehicule(voit1);
		flotteTest.addVehicule(fourg2);
		flotteTest.addVehicule(fourg1);
	}
	
	@AfterEach
	public void delFlotte() { 
		flotteTest = null;
	}
	
	@Test
	@Order(1)
	@DisplayName("Test du constructeur")
	public void testConstructeur() {
		//Given + When
		FlotteVehicules test = new FlotteVehicules();
		List<Vehicule> listeTest = test.getVehicules();
		//Then
		assertThat(listeTest.size()).isEqualTo(0);
	}
	
	@Test
	@Order(2)
	@DisplayName("Test de l'ajout (véhicule déjà présent)")
	public void testAjoutDejaPresent() {
		assertThrows(ExceptionVehiculeDejaPresent.class, () -> flotteTest.addVehicule(voit2));
	}
	
	@Test
	@Order(3)
	@DisplayName("Test de la suppression (véhicule présent)")
	public void testDelDejaPresent() throws ExceptionVehiculePasPresent {
		//Given
		List<Vehicule> listeTest = flotteTest.getVehicules();
		assertThat(listeTest.size()).isEqualTo(4);
		//When
		flotteTest.supVehicule(fourg1);
		listeTest = flotteTest.getVehicules();
		//Then
		assertThat(listeTest.size()).isEqualTo(3);
	}
	
	@Test
	@Order(4)
	@DisplayName("Test de la suppression (véhicule non présent)")
	public void testDelNonPresent() {
		assertThrows(ExceptionVehiculePasPresent.class, () -> flotteTest.supVehicule(new Voiture("888-555-222","Nexiste","Pas",25.2,20556,com)));
	}
	
	@Test
	@Order(5)
	@DisplayName("Test de la méthode de tri")
	public void testTri() {
		//Given + When
		flotteTest.triVehicule();
		List<Vehicule> listeTest = flotteTest.getVehicules();
		//Then
		assertThat(listeTest.get(0)).isEqualTo(voit1);
		assertThat(listeTest.get(1)).isEqualTo(fourg2);
		assertThat(listeTest.get(2)).isEqualTo(fourg1);
		assertThat(listeTest.get(3)).isEqualTo(voit2);
	}
	
	@Test
	@Order(6)
	@DisplayName("Test de la liste de fourgons")
	public void testFourg() {
		//Given + When
		ArrayList<Vehicule> listeFourg = flotteTest.onlyFourgon();
		//Then
		assertThat(listeFourg.size()).isEqualTo(2);
	}
	
	@Test
	@Order(7)
	@DisplayName("Test de la liste de voitures")
	public void testVoit() {
		//Given + When
		ArrayList<Vehicule> listeVoit = flotteTest.onlyVoiture();
		//Then
		assertThat(listeVoit.size()).isEqualTo(2);
	}
}
