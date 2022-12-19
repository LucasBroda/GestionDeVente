package principal;

import article.Article;
import article.Cartes;
import article.Figurine;
import article.Stock;
import client.CarnetClients;
import client.ClientEntreprise;
import client.ClientParticulier;
import client.Genre;
import commande.Commande;
import commande.EnsembleCommandes;
import gestionnaire.GestionnairePrincipal;

/**
 * Le programme principal de l'application de gestion de ventes.
 * @author Jean-François Condotta
 * @version 17/03/22
 *
 */
public class GestionVentes {
	/**
	 * Le nom de l'entreprise réalisant les ventes d'articles.
	 */
	static final public String nomEntreprise="Mikomania";
	/**
	 * Les prénoms et noms des gérants.
	 */
	static final public String nomsGerants="Hugo Potier & Clement Mahieux & Lucas Broda & Tom Decary";
	
	/**
	 * Le programme principal de l'application de gestion des ventes.
	 * @param args Pas d'arguments.
	 */
	public static void main(String[] args) {
		Stock stock=new Stock("Stock Mikamania");
		//article figure
		stock.ajouterArticle(new Figurine("Gundam 78-2 Perfect Grade Unleashed",279.99,10,"Gundam","Gundam RX 78-2","Bandai","Maquette",2360,31,13,5));
		stock.ajouterArticle(new Figurine("Chronicle Master Stars Piece Monkey D. Luffy",42.90,25,"One Piece","Monkey D. Luffy","Banpresto","Figurine PVC",1700,24.5,10,10));
		stock.ajouterArticle(new Figurine("Chronicle Master Stars Piece Portgas D. Ace",44.90,20,"One Piece","Portgas D. Ace","Banpresto","Figurine PVC", 1900,26,11,11));
		stock.ajouterArticle(new Figurine("Pokemon Deluxe Collector Pikachu",109.90,10,"Pokemon","Pikachu","Jazwares","Figurine lumineuse",3500,30,10,15));
		stock.ajouterArticle(new Figurine("Pokemon Pokepla Dracaufeu VS Dracolosse",34.90,25,"Pokemon","Dracaufeu, Dracolosse","Bandai","Maquette",1200,12,5,5));
		stock.ajouterArticle(new Figurine("HG Char's Zaku II Revive",20.99,30,"Gundam","Char's Zaku II","Bandai","Maquette",1150,13,4,2));
		stock.ajouterArticle(new Figurine("Entry Grade Kirby",19.99,35,"Kirby","Kirby","Bandai","Maquette",900,7,4,4));
		stock.ajouterArticle(new Figurine("Nendoroid Sacha et Pikachu",37.99,15,"Pokemon","Sacha, Pikachu","Good Smile","Figurine PVC", 1400,10.5,6,3));
		stock.ajouterArticle(new Figurine("Chronicle Master Stars Piece Lupin Lupin the third",39.90,10,"Lupin the third","Lupin III","Banpresto","Figurine PVC",1900,25,11,11));
		stock.ajouterArticle(new Figurine("Burning Fighters Son Goku",29.90,15,"Dragon Ball Z","Son Goku","Banpresto","Figurine PVC",2100,16.7,5,3));
		//article carte
		stock.ajouterArticle(new Cartes("Digimon Trading Cards Game booster BT 05 Battle of Omni",3.49,80,"Digimon","boosters","Battle of Omni"));
		stock.ajouterArticle(new Cartes("Digimon Trading Cards Game booster BT 04 Great Legend",3.49,90,"Digimon","boosters","Great Legend"));
		stock.ajouterArticle(new Cartes("Digimon Trading Cards Game booster BT 06 Double Diamond",3.49,80,"Digimon","boosters","Double Diamond"));
		stock.ajouterArticle(new Cartes("Digimon Trading Cards Game booster BT 07 Next Adventure",3.49,60,"Digimon","boosters","Next Adventure"));
		stock.ajouterArticle(new Cartes("Digimon Trading Cards Game booster BT 08 New Awakening",3.49,70,"Digimon","boosters","New Awakening"));
		stock.ajouterArticle(new Cartes("Magic the Gathering booster Apocalypse",3.49,90,"Magic the Gathering","boosters","Apocalypse"));
		stock.ajouterArticle(new Cartes("Magic the Gathering coffret Apocalypse",39.49,15,"Magic the Gathering","","Apocalypse"));
		stock.ajouterArticle(new Cartes("Magic The Gathering booster Sombrelande",3.49,80,"Magic the Gathering","boosters","Sombrelande"));
		stock.ajouterArticle(new Cartes("Magic The Gathering coffret Commander (noir)",39.90,20,"Magic the Gathering","coffret","Commander"));
		stock.ajouterArticle(new Cartes("Magic the Gathering Coffret Les rues de la Nouvelle-Capenna",32.90,10,"Magic the Gathering","coffret"," Les rues de la Nouvelle-Capenna"));
		
		CarnetClients carnetClients=new CarnetClients("Carnet Clients 2022");
		//client Particulier
		carnetClients.ajouterClient(new ClientParticulier("Potier","30 rue des Tulipes, 62300 Lens, France",0,"Hugo",Genre.Homme));
		carnetClients.ajouterClient(new ClientParticulier("Broda","123 rue de la fete, 62300 Lens, France",50,"Lucas",Genre.Homme));
		carnetClients.ajouterClient(new ClientParticulier("Roussell","57 avenue de la dance, 62232 Annezin, France",100,"Damien",Genre.Homme));
		carnetClients.ajouterClient(new ClientParticulier("Pecpec","50 rue du fion, 62400 Bethune, France",1000,"Ilona",Genre.Femme));
		carnetClients.ajouterClient(new ClientParticulier("Mahieux","123 rue des narcisses, 62300 Lens, France",2000,"Karim",Genre.Homme));
		//client Entreprise
		carnetClients.ajouterClient(new ClientEntreprise("DockGame","42 boulevard des Marguerites, 62400 Béthune, France",100,"Jean Lasalle"));
		carnetClients.ajouterClient(new ClientEntreprise("Uwu Gang","22 impasse de la face, 62300 Lille, France",500,"MArine Dufois"));
		carnetClients.ajouterClient(new ClientEntreprise("Logitech","12 Boulevard de la vie,75000 Paris, France",100,"Tony leFou"));
		carnetClients.ajouterClient(new ClientEntreprise("Razer","26 rue du la fleur, 62300 Lille, France",0,"Françoise Dupuis"));
		carnetClients.ajouterClient(new ClientEntreprise("Micromania","12 rue de la vie, 62300 Lille, France",10,"Patrick Sébastien"));
		//Commandes - Ensemble des commandes
		EnsembleCommandes ensembleCommandes=new EnsembleCommandes();
		ensembleCommandes.ajouterCommande(new Commande(carnetClients.rechercherClientParReference(0)));
		ensembleCommandes.ajouterCommande(new Commande(carnetClients.rechercherClientParReference(1)));
		
		ensembleCommandes.rechercherCommandeParReference(0).commander​(stock.rechercherArticleParReference(0), 2);
		ensembleCommandes.rechercherCommandeParReference(1).commander​(stock.rechercherArticleParReference(1), 3);
		GestionnairePrincipal gestionnairePrincipal=new GestionnairePrincipal("Gestion des ventes - "+nomEntreprise+"\n"+nomsGerants,ensembleCommandes,carnetClients,stock);
		gestionnairePrincipal.afficherGererMenu();

	}

}
