package article;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.function.IntPredicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StockTest {
    
    private Stock stock;
    @Mock Article a1;
    @Mock Article a2;
    


    @BeforeEach
    public void init() {
            stock = new Stock("stock");
    }

        @Test
        void testStock() {
                assertThat(stock.getNom()).isEqualTo("stock");
        assertThat(stock.getNbArticles()).isEqualTo(0);
    }

        @Test
        void testEstPlein() {
                assertThat(stock.estPlein()).isEqualTo(false);
        stock.ajouterArticle(a1);
        stock.ajouterArticle(a2);
        stock.ajouterArticle(a3);
        stock.ajouterArticle(a4);
        stock.ajouterArticle(a5);
        assertThat(stock.estPlein()).isEqualTo(true);
        }

        @Test
        void testEstVide() {
                assertThat(stock.estVide()).isEqualTo(true);
            stock.ajouterArticle(a1);
        assertThat(stock.estVide()).isEqualTo(false);        }

        @Test
        void testAjouterArticle() {
                stock.ajouterArticle(new Article("figurine",10,100));
        assertThat(stock.getNbArticles()).isEqualTo(1);
        for (int i = 0;i<stock.MAX_ARTICLES;i++)
                stock.ajouterArticle(new Article("figurines",10,100));
        assertThat(stock.getNbArticles()).isEqualTo(stock.MAX_ARTICLES);
        
        }

        @Test
        void testSupprimerArticle() {
        stock.ajouterArticle(a1);
        assertThat(stock.getNbArticles()).isEqualTo(1);
        stock.ajouterArticle(a2);
        assertThat(stock.getNbArticles()).isEqualTo(2);
        stock.supprimerArticle(a2);
        assertThat(stock.getNbArticles()).isEqualTo(1);
        }

        @Test
        void testRechercherArticleParReference() {
                when(a1.getReference()).thenReturn(0);
                when(a2.getReference()).thenReturn(1);
        stock.ajouterArticle(a1);
        stock.ajouterArticle(a2);
        assertThat(stock.rechercherArticleParReference(0)).isEqualTo(a1);
        }

        @Test
        void testArticlesDansStock() {
                stock.ajouterArticle(a1);
                stock.ajouterArticle(a2);
                Article[] resultatFinal = new Article[2];
                resultatFinal[0] = a1;
                resultatFinal[1] = a2;
                assertThat(stock.articlesDansStock()).isEqualTo(resultatFinal);
        }

        @Test
        void testRechercherArticlesCategorie() {
        	Article[] resultatFinal = new Article[2];
            resultatFinal[0] = a2;
        	stock.ajouterArticle(a1);
            stock.ajouterArticle(a2);
                when(a1.getCategorie()).thenReturn("figurines");
                when(a2.getCategorie()).thenReturn("poupées");
                
            assertThat(stock.rechercherArticlesCategorie("poupées")).isEqualTo(resultatFinal);
        }

        @Test
        void testGetNom() {
                assertThat(stock.getNom()).isEqualTo("stock");        }

        @Test
        void testSetNom() {
                stock.setNom("stock2");
                assertThat(stock.getNom()).isEqualTo("stock2");
        }

        @Test
        void testGetNbArticles() {
                assertThat(stock.getNbArticles()).isZero();        }
        }