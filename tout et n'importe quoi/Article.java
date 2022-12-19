package article;

import util.Util;

public class Article {
	private int reference;
	private String categorie;
	private String designation;
	private double prix;
	private int quantiteStock;
	private static int nbArticles=0; 
	
	public Article(String designation, double prix, int quantiteStock) {
/**
 * Constructeur de la classe Article (sans catégorie)
 */
		this.reference = nbArticles;
		this.designation = designation;
		this.prix = prix;
		this.quantiteStock = quantiteStock;
		this.categorie = "Aucune";
		nbArticles++;
	}
	
	protected Article(String categorie,String designation, double prix, int quantiteStock) {
	/**
	 * Constructeur de la classe Article (avec catégorie)
	 */
		this.categorie = categorie;
		this.reference = nbArticles;
		this.designation = designation;
		this.prix = prix;
		this.quantiteStock = quantiteStock;
		nbArticles++;
	}
	
	public Article() {
		/**
		 * Constructeur de la classe Article (vide)
		 */
		this.reference = nbArticles;
		nbArticles ++;
		this.categorie = "Aucune";
		this.saisirInfos();
	}
	
	public int getReference() {
	/**
	* Méthode retournant la référence de l'article
	* @return La référence de l'article.
	*/
		return this.reference;
	}
	
	public String getCategorie() {
	/**
	* Méthode qui renvoie la catégorie à laquelle appartient l'article
	* @return La catégorie de l'article, figurine ou cartes
	*/
		return this.categorie;
	}
	
	public String getDesignation() {
	/**
	* Méthode qui retourne la désignation (nom) de l'article
	* @return Le nom de l'article
	*/
		return this.designation;
	}
	
	public double getPrix() {
	/**
	* Méthode qui retourne le prix de l'article
	* @return Le prix de l'article
	*/
		return this.prix;
	}
	
	public void setPrix(double nouv_p) {
	/**
	 * Méthode qui change le prix de l'article pour le prix passé en paramètre. Ne fonctionne pas si le prix est négatif
	 * ou si le prix est égal à 0.
	 */
		if(nouv_p > 0) {
			this.prix = nouv_p;
		}
	}
	public int getQuantiteStock() {
	/**
	 * Méthode qui retourne la quantité dudit article en stock.
	 * @return La quantié disponible
	 */
		return this.quantiteStock;
	}
	
	public boolean estDisponible() {
	/**
	* Méthode permettant de savoir si un article est disponible.
	* @return true si l'article est en stock, false sinon
	*/
		return(this.getQuantiteStock() > 0);
	}
	
	public void setQuantiteStock(int nouv_quant) {
	/**
	* Méthode qui change la quantité en stock par la quantité en paramètre. Ne marche qu'avec des quantités positives ou nulles.
	*/
		if(nouv_quant>=0) {
			this.quantiteStock=nouv_quant;
		}
	}
	
	public void saisirInfos() {
	/**
	 * méthode qui permet de saisir la désignation, le prix et la quantité en stock d'un article.
	 */
		this.designation = Util.saisirChaine("saisir désignation : ");
		this.prix = Util.saisirDoublePositif("saisir prix : ");
		this.quantiteStock = Util.saisirEntierPositif("Saisir quantité : ");
	}
	public void ajouterQuantiteStock(int quant) {
	/**
	 * Méthode qui ajoute au stock la quantité passée en paramètre.
	 */
		this.quantiteStock = this.getQuantiteStock() + quant;
	}
	
	public void enleverQuantiteStock(int quant) {
	/**
	 * Méthode qui retire au stock la quantité passée en paramètre.
	 */
		if(this.getQuantiteStock() - quant < 0) {
			throw new IllegalArgumentException("La quantité finale est négative !");
		}
		this.quantiteStock = this.getQuantiteStock() - quant;
	}
	public static void afficherTabArticles(Article[] articles) {
	/**
	 * Méthode qui affiche les références et nom d'une liste d'articles passée en paramètres
	 */
		for(int x=0;x < articles.length;x++) {
			if(articles[x] == null) {
				break;
			}
			articles[x].afficherInfos();
		}
	}
	public boolean equals(Object art) {
	/**
	 * Méthode vérifiant si l'article passé en paramètre est égal à l'article actuel.
	 * Deux articles sont égaux si et seuelement si ils ont le même numéro de référence.
	 */
		if (art==null) return false; 
		if (! (art instanceof Article)) return false; 
		Article article = (Article)art;
		return this.getReference() == article.getReference();
	}
	
	public void setCategorie(String nouv_cat) {
		/**
		 * Méthode permettant de changer la catégorie d'un article
		 * Ne fonctionne que si nouv_cat n'est pas nul
		 */
		if(nouv_cat != null) {
			this.categorie = nouv_cat;
		}
	}
	public void afficherInfos() {
	/**
	 * Méthode qui affiche toutes les informations sur l'article à la suite (équivaut au toString)
	 */
		System.out.println("~\nRéférence : " + this.getReference() + " Désignation : " + this.getDesignation() + " Prix : " + this.getPrix() + "\nCatégorie : " + this.getCategorie() + " Quantité en stock : " + this.getQuantiteStock());
	}
	
}

	