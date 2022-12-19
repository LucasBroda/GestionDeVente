/**
 * 
 */
package commande;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import article.Article;
import article.Stock;
import client.Client;
import client.ClientEntreprise;

/**
 * @author lulub
 *
 */
class EnsembleCommandesTest {
	
	private Commande commande;
	
	private Client client;
	
	@BeforeEach
	public void initCommandeClient() {
		//client = new ClientEntreprise();
		commande = new Commande(client);
	}

	@AfterEach public void invalideClient() { 
		client = null; 
		commande = null;
	}

	/**
	 * Test method for {@link commande.EnsembleCommandes#EnsembleCommandes()}.
	 */
	
	@Test
	@DisplayName("Test du constructeur ensembleCommandes")
	void testEnsembleCommandes() {
		//GIVEN
		
		
		//WHEN
		EnsembleCommandes ensembleCommande1 = new EnsembleCommandes();
		EnsembleCommandes ensembleCommande2 = new EnsembleCommandes();
		
		//THEN
		assertThat(ensembleCommande1).isNotEqualTo(ensembleCommande2);
	}

	/**
	 * Test method for {@link commande.EnsembleCommandes#getNbCommandes()}.
	 */
	@Test
	@DisplayName("Test de la méthode getNbCommandes permettant d'avoir le nombre de commandes")
	void testGetNbCommandes() {
		//GIVEN
		EnsembleCommandes ensembleCommande1 = new EnsembleCommandes();
		
		
		//WHEN
		ensembleCommande1.getNbCommandes();
		
		//THEN
		assertThat(ensembleCommande1.getNbCommandes()).isEqualTo(0);
	}

	/**
	 * Test method for {@link commande.EnsembleCommandes#estVide()}.
	 */
	@Test
	@DisplayName("Test de la méthode estVide permettant de savoir si il n'y a pas de commande en cours")
	void testEstVide() {
		//GIVEN
		
				
				
		//WHEN
		EnsembleCommandes ensembleCommande1 = new EnsembleCommandes();
				
		//THEN
		assertThat(ensembleCommande1.estVide()).isEqualTo(true);
	}

	/**
	 * Test method for {@link commande.EnsembleCommandes#estPlein()}.
	 */
	@Test
	@DisplayName("Test de la méthode estPlein permettant de savoir si le nombre de commande a atteint son maximun")
	void testEstPlein() {
		//GIVEN
		EnsembleCommandes ensembleCommande1 = new EnsembleCommandes();
		
				
		//WHEN
		
				
		//THEN
		assertThat(ensembleCommande1.estPlein()).isEqualTo(true);
	}

	/**
	 * Test method for {@link commande.EnsembleCommandes#ajouterCommande(commande.Commande)}.
	 */
	@Test
	@DisplayName("Test de la méthode ajouterCommande permettant d'ajouter une commande")
	void testAjouterCommande() {
		//GIVEN
		int  nbCommandes = 0;
		EnsembleCommandes ensembleCommande1 = new EnsembleCommandes();		
		
		//WHEN
		ensembleCommande1.ajouterCommande(commande);
				
				
		//THEN
		
	}

	/**
	 * Test method for {@link commande.EnsembleCommandes#getCommandes()}.
	 */
	@Test
	@DisplayName("Test de la méthode getCommande permettant d'avoir le tableau de commande dans l'ensemble")
	void testGetCommandes() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link commande.EnsembleCommandes#afficher()}.
	 */
	@Test
	@DisplayName("Test de la méthode afficher permettant d'afficher l'ensemble des commandes")
	void testAfficher() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link commande.EnsembleCommandes#rechercherCommandeParReference(int)}.
	 */
	@Test
	@DisplayName("Test de la méthode rechercherCommandeParReference permettant de rechercher une commande grâce à une référence")
	void testRechercherCommandeParReference() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link commande.EnsembleCommandes#getPosCommande(commande.Commande)}.
	 */
	@Test
	@DisplayName("Test de la méthode getPosCommande permettant de savoir la position d'une commande précise")
	void testGetPosCommande() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link commande.EnsembleCommandes#getPosCommandeReference(int)}.
	 */
	@Test
	@DisplayName("Test de la méthode getPosCommandeReference permettant de savoir la position d'une commande grâce à une référence")
	void testGetPosCommandeReference() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link commande.EnsembleCommandes#supprimerCommande(int)}.
	 */
	@Test
	@DisplayName("Test de la méthode supprimerCommande permettant de supprimer une commande")
	void testSupprimerCommande() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link commande.EnsembleCommandes#supprimerCommandeReference(int)}.
	 */
	@Test
	@DisplayName("Test de la méthode supprimerCommandeReference permettant de supprimer une commande grâce à sa référence")
	void testSupprimerCommandeReference() {
		fail("Not yet implemented");
	}

}
