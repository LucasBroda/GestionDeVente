package article;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import util.Util;

class ArticleTest {

	@Test
	@DisplayName("Test du constructeur sans catégorie")
	void testArticleStringDoubleInt() {
		//GIVEN
		
		
		//WHEN
		Article article1 = new Article("designation",100,2);
		
		//THEN
		assertThat(article1.getCategorie()).isEqualTo("Aucune");
	}

	@Test
	@DisplayName("Test du constructeur avec catégorie")
	void testArticleStringStringDoubleInt() {
		//GIVEN
		
		//WHEN
		Article article1 = new Article("poupet","designation",100,2);
		
		//THEN
		assertThat(article1.getCategorie()).isEqualTo("poupet");
	}

	@Test
	@DisplayName("Test du constructeur sans paramètres")
	void testArticle() {
		//GIVEN
		
		//WHEN
		Article article1 = new Article();
		Article article2 = new Article();
		
		//THEN
		assertThat(article1).isNotEqualTo(article2);
		
	}

	@Test
	@DisplayName("Test de la méthode getReference récupérant la référence de l'article")
	void testGetReference() {
		//GIVEN
		
		
		//WHEN
		Article article1 = new Article("jeu","designation",100,5);
		
		//THEN
		assertThat(article1.getReference()).isEqualTo(article1.getReference());
	
	}

	@Test
	@DisplayName("Test de la méthode getCategorie récupérant la catégorie de l'article")
	void testGetCategorie() {
		//GIVEN
		
		//WHEN
		Article article1 = new Article("poupet","designation",100,2);
		
		//THEN
		assertThat(article1.getCategorie()).isEqualTo("poupet");
	}

	@Test
	@DisplayName("Test de la méthode getDesignation récupérant la désignation de l'article")
	void testGetDesignation() {
		//GIVEN 
		
		//WHEN
		Article article1 = new Article("poupet","designation",100,2);
		
		//THEN
		assertThat(article1.getDesignation()).isEqualTo("designation");
	}

	@Test
	@DisplayName("Test de la méthode getPrix récupérant le prix de l'article")
	void testGetPrix() {
		//GIVEN
		
		//WHEN
		Article article1 = new Article("poupet","designation",100,2);
		
		//THEN
		assertThat(article1.getPrix()).isEqualTo(100);
	}

	@Test
	@DisplayName("Test de la méthode setPrix permettant d'initialiser le prix de l'article")
	void testSetPrix() {
		//GIVEN
		Article article1 = new Article("poupet","designation",100,2);
		
		//WHEN
		article1.setPrix(200);
		
		//THEN
		assertThat(article1.getPrix()).isEqualTo(200);
	}

	@Test
	@DisplayName("Test de la méthode getQuantiteStock récupérant la quantitté en stock d'un produit")
	void testGetQuantiteStock() {
		//GIVEN
		Article article1 = new Article("poupet","designation",100,2);
		
		//WHEN
		article1.setQuantiteStock(1);
		
		//THEN
		assertThat(article1.getQuantiteStock()).isEqualTo(1);
	}

	@Test
	@DisplayName("Test de la méthode estDisponible permettant de savoir si un article est disponible")
	void testEstDisponible() {
		//GIVEN
		Article article1 = new Article("poupet","designation",100,2);
		
		//WHEN
		article1.setQuantiteStock(1);
		
		//THEN
		assertThat(article1.estDisponible()).isNotNull();
	}

	@Test
	@DisplayName("Test de la méthode setQuantiteStock permettant d'initialiser la quantité en stock d'un article")
	void testSetQuantiteStock() {
		//GIVEN
		Article article1 = new Article("poupet","designation",100,2);
				
		//WHEN
		article1.setQuantiteStock(2);
				
		//THEN
		assertThat(article1.getQuantiteStock()).isEqualTo(2);
	}

	@Test
	@DisplayName("Test de la méthode SaisirInfos permettant de saisir les informations d'un article")
	void testSaisirInfos() {
		//GIVEN
		Article article1 = new Article();
		
		//WHEN
		article1.saisirInfos();
		
		//THEN
		assertThat(article1.getDesignation()).isEqualTo(Util.saisirChaine("saisir désignation : "));
		assertThat(article1.getPrix()).isEqualTo(Util.saisirDoublePositif("saisir prix : "));
		assertThat(article1.getQuantiteStock()).isEqualTo(Util.saisirEntierPositif("Saisir quantité : "));
	}

	@Test
	@DisplayName("Test de la méthode ajouterQuantiteStock permettant d'ajouter du stock à un article donné")
	void testAjouterQuantiteStock() {
		//GIVEN
		Article article1 = new Article("poupet","designation",100,2);
						
		//WHEN
		article1.ajouterQuantiteStock(2);
						
		//THEN
		assertThat(article1.getQuantiteStock()).isEqualTo(4);
	}

	@Test
	@DisplayName("Test de la méthode enleverQuantiteStock permettant d'enlever une quantité donnée d'un article")
	void testEnleverQuantiteStock() {
		//GIVEN
		Article article1 = new Article("poupet","designation",100,2);
								
		//WHEN
		article1.enleverQuantiteStock(1);
								
		//THEN
		assertThat(article1.getQuantiteStock()).isEqualTo(1);
		assertThrows(IllegalArgumentException.class, () -> article1.enleverQuantiteStock(1));
	}

	@Test
	@DisplayName("Test de la méthode afficherTabArticles permettant de renvoyer un tableau contenant tous les articles enregistrés")
	//à finir
	void testAfficherTabArticles() {
		//GIVEN
		Article article1 = new Article("poupet","designation",100,2);
								
		//WHEN
		//article1.afficherTabArticles(Article[] articles);
		
								
		//THEN
		
	}

	
	@Test
	@DisplayName("Test de la méthode equalsObject permettant de savoir si deux articles sont les mêmes")
	//à finir
	void testEqualsObject() {
		//GIVEN
		
		
		//WHEN
		Article article1 = new Article("poupet","designation",100,2);
		Article article2 = new Article("poupet","designation",100,2);
		
		//THEN
		assertEquals(article1,article2);
	}

	@Test
	@DisplayName("Test de la méthode setCategorie permettant d'initialiser la catégorie d'un article")
	void testSetCategorie() {
		//GIVEN 
		Article article1 = new Article("designation",100,2);
		
		//WHEN
		article1.setCategorie("poupet");
				
		//THEN
		assertThat(article1.getCategorie()).isEqualTo("poupet");
	}

	@Test
	@DisplayName("Test de la méthode afficherInfos permettant d'afficher les informations d'un article donné")
	//à compléter
	void testAfficherInfos() {
		
		
	}

}
