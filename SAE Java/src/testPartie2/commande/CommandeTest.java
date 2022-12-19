/**
 * 
 */
package commande;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import article.Article;
import client.Client;
import client.ClientEntreprise;


/**
 * @author lulub
 *
 */
@ExtendWith(MockitoExtension.class)
class CommandeTest {
	
	@Mock Article a1;
    @Mock Article a2;

    @Mock Client c1;
    @Mock Client c2;
  
    
	private Client client;
	@BeforeEach
	public void initClient() {
		client = new ClientEntreprise();
	}

	@AfterEach public void invalideClient() { client = null; }
	/**
	 * Test method for {@link commande.Commande#Commande(client.Client)}.
	 */
	@Test
	void testCommande() {
		
	}

	/**
	 * Test method for {@link commande.Commande#getNbLignesCommandes()}.
	 */
	@Test
	void testGetNbLignesCommandes() {
		
	}

	/**
	 * Test method for {@link commande.Commande#getReferences()}.
	 */
	@Test
	void testGetReferences() {
		
	}

	/**
	 * Test method for {@link commande.Commande#estPleine()}.
	 */
	@Test
	void testEstPleine() {
		
	}

	/**
	 * Test method for {@link commande.Commande#estVide()}.
	 */
	@Test
	void testEstVide() {
		
	}

	/**
	 * Test method for {@link commande.Commande#estCloturee()}.
	 */
	@Test
	void testEstCloturee() {
		
	}

	/**
	 * Test method for {@link commande.Commande#getArticle​(int)}.
	 */
	@Test
	void testGetArticle​() {
		
	}

	/**
	 * Test method for {@link commande.Commande#getQuantite(int)}.
	 */
	@Test
	void testGetQuantite() {
		
	}

	/**
	 * Test method for {@link commande.Commande#supprimerLigneCommande(int)}.
	 */
	@Test
	void testSupprimerLigneCommande() {
		
	}

	/**
	 * Test method for {@link commande.Commande#getMontant()}.
	 */
	@Test
	void testGetMontant() {
		
	}

	/**
	 * Test method for {@link commande.Commande#getMontantAvecLivraison()}.
	 */
	@Test
	void testGetMontantAvecLivraison() {
		
	}

	/**
	 * Test method for {@link commande.Commande#commander​(article.Article, int)}.
	 */
	@Test
	void testCommander​() {
		
	}

	/**
	 * Test method for {@link commande.Commande#cloturer(boolean)}.
	 */
	@Test
	void testCloturer() {
		
	}

	/**
	 * Test method for {@link commande.Commande#toString()}.
	 */
	@Test
	void testToString() {
		
	}

}
