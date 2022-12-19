/**
 * 
 */
package commande;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import article.Article;

/**
 * @author lulub
 *
 */
class LigneCommandeTest {

	/**
	 * Test method for {@link commande.LigneCommande#LigneCommande(article.Article, int)}.
	 */
	@Test
	@DisplayName("Test du contructeur ligneCommande")
	void testLigneCommande() {
		//GIVEN
		Article article1 = new Article("designation",100,2);
		
		//WHEN
		LigneCommande commande1 = new LigneCommande(article1, 2);
		
		//THEN
		assertThat(commande1.getArticle()).isEqualTo(article1);
		assertThat(commande1.getQuantite()).isEqualTo(2);
	}

	/**
	 * Test method for {@link commande.LigneCommande#ajouterQuantite(int)}.
	 */
	@Test
	@DisplayName("Test de la méthode ajouterQuantité permettant d'ajouter de la quantité supplémentaire à la commande demandée")
	void testAjouterQuantite() {
		//GIVEN
		Article article1 = new Article("designation",100,2);
		LigneCommande commande1 = new LigneCommande(article1, 2);
		
		//WHEN
		commande1.ajouterQuantite(2);
		
		//THEN
		assertThat(commande1.getQuantite()).isEqualTo(4);
	}

	/**
	 * Test method for {@link commande.LigneCommande#getArticle()}.
	 */
	@Test
	@DisplayName("Test de la méthode getArticle permettant de renvoyer l'article demandé")
	void testGetArticle() {
		//GIVEN
		Article article1 = new Article("designation",100,2);
				
		//WHEN
		LigneCommande commande1 = new LigneCommande(article1, 2);
				
		//THEN
		assertThat(commande1.getArticle()).isEqualTo(article1);
	}

	/**
	 * Test method for {@link commande.LigneCommande#getQuantite()}.
	 */
	@Test
	@DisplayName("Test de la méthode getQuantité permettant de renvoyer la quantité demandée ")
	void testGetQuantite() {
		//GIVEN
		Article article1 = new Article("designation",100,2);
				
		//WHEN
		LigneCommande commande1 = new LigneCommande(article1, 2);
				
		//THEN
		assertThat(commande1.getQuantite()).isEqualTo(2);
	}

	/**
	 * Test method for {@link commande.LigneCommande#getMontant()}.
	 */
	@Test
	@DisplayName("Test de la méthode getMontant permettant de renvoyer le montant de la ligne de commande sans livraison")
	void testGetMontant() {
		//GIVEN
		Article article1 = new Article("designation",100,2);
		LigneCommande commande1 = new LigneCommande(article1, 2);
		
		//WHEN
		commande1.getMontant();
				
		//THEN
		assertThat(commande1.getMontant()).isEqualTo(200);
	}

	/**
	 * Test method for {@link commande.LigneCommande#getMontantAvecLivraison()}.
	 */
	@Test
	@DisplayName("Test de la méthode getMontant permettant de renvoyer le montant de la ligne de commande avec livraison")
	void testGetMontantAvecLivraison() {
		//GIVEN
		
		
		//WHEN
		
		//THEN
		
	}

	/**
	 * Test method for {@link commande.LigneCommande#toString()}.
	 */
	@Test
	@DisplayName("Test de la méthode toString permettant de renvoyer la ligne de commande entière avec toutes les informations")
	void testToString() {
		//GIVEN
		
		
		//WHEN
		
		//THEN
		
	}

}
