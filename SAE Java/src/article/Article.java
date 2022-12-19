package article;

import util.Util;
 /**
  * Une classe permettant de représenter des articles en vente.
  * @author TomD
  * @version 06/04/2022
  */
public class Article {
	private int reference;
	private String categorie;
	private String designation;
	private double prix;
	private int quantiteStock;
	private static int nbArticles=0;
	
	/**
	 * Constructeur de la classe Article (sans catégorie)
	 */	
	public Article(String designation, double prix, int quantiteStock) {
		this.reference = nbArticles;
		this.designation = designation;
		this.prix = prix;
		this.quantiteStock = quantiteStock;
		this.categorie = "Aucune";
		nbArticles++;
	}
	
	/**
	 * Constructeur de la classe Article (avec catégorie)
	 */
	protected Article(String categorie,String designation, double prix, int quantiteStock) {
		this.categorie = categorie;
		this.reference = nbArticles;
		this.designation = designation;
		this.prix = prix;
		this.quantiteStock = quantiteStock;
		nbArticles++;
	}
	
	/**
	 * Constructeur de la classe Article (vide)
	 */
	public Article() {
		this.reference = nbArticles;
		nbArticles ++;
		this.categorie = "Aucune";
		this.saisirInfos();
	}
	
	/**
	* Méthode retournant la référence de l'article
	* @return La référence de l'article.
	*/
	public int getReference() {
		return this.reference;
	}
	
	/**
	* Méthode qui renvoie la catégorie à laquelle appartient l'article
	* @return La catégorie de l'article, "Figurines","Cartes" ou "Aucune"
	*/
	public String getCategorie() {
		return this.categorie;
	}
	
	/**
	* Méthode qui retourne la désignation (nom) de l'article
	* @return Le nom de l'article
	*/
	public String getDesignation() {
		return this.designation;
	}
	
	/**
	* Méthode qui retourne le prix de l'article
	* @return Le prix de l'article
	*/
	public double getPrix() {
		return this.prix;
	}
	
	/**
	 * Méthode qui change le prix de l'article pour le prix passé en paramètre. Ne fonctionne pas si le prix est négatif
	 * ou si le prix est égal à 0.
	 * @param nouv_p un prix en euros, double strictement supérieur à 0
	 */
	public void setPrix(double nouv_p) {
		if(nouv_p > 0) {
			this.prix = nouv_p;
		}
	}
	
	/**
	 * Méthode qui retourne la quantité dudit article en stock.
	 * @return La quantié disponible
	 */
	public int getQuantiteStock() {
		return this.quantiteStock;
	}
	
	/**
	* Méthode permettant de savoir si un article est disponible.
	* @return true si l'article est en stock, false sinon
	*/
	public boolean estDisponible() {
		return(this.getQuantiteStock() > 0);
	}
	
	/**
	* Méthode qui change la quantité en stock par la quantité en paramètre. Ne marche qu'avec des quantités positives ou nulles.
	* @param nouv_quant La nouvelle quantité du stock, un entier positif ou nul
	*/
	public void setQuantiteStock(int nouv_quant) {
		if(nouv_quant>=0) {
			this.quantiteStock=nouv_quant;
		}
	}
	
	/**
	 * méthode qui permet de saisir la désignation, le prix et la quantité en stock d'un article.
	 */
	public void saisirInfos() {
		this.designation = Util.saisirChaine("saisir désignation : ");
		this.prix = Util.saisirDoublePositif("saisir prix : ");
		this.quantiteStock = Util.saisirEntierPositif("Saisir quantité : ");
	}
	
	/**
	 * Méthode qui ajoute au stock la quantité passée en paramètre.
	 * @param quant la quantité à ajouter (int)
	 */
	public void ajouterQuantiteStock(int quant) {
		this.quantiteStock = this.getQuantiteStock() + quant;
	}
	
	/**
	 * Méthode qui retire au stock la quantité passée en paramètre.
	 * @param quant la quantité à retirer (int)
	 */	
	public void enleverQuantiteStock(int quant) {
		if(this.getQuantiteStock() - quant < 0) {
			throw new IllegalArgumentException("La quantité finale est négative !");
		}
		this.quantiteStock = this.getQuantiteStock() - quant;
	}
	
	/**
	 * Méthode qui affiche les références et nom d'une liste d'articles passée en paramètres
	 * @param articles une liste d'objets Article
	 */
	public static void afficherTabArticles(Article[] articles) {
		for(int x=0;x < articles.length;x++) {
			if(articles[x] == null) {
				break;
			}
			System.out.println(articles[x]);
		}
	}
	/**
	 * Méthode vérifiant si l'article passé en paramètre est égal à l'article actuel.
	 * Deux articles sont égaux si et seuelement si ils ont le même numéro de référence.
	 * @param art un objet à comparer à l'Article actuel
	 */
	public boolean equals(Object art) {
		if (art==null) return false; 
		if (! (art instanceof Article)) return false; 
		Article article = (Article)art;
		return this.getReference() == article.getReference();
	}
	
	/**
	 * Méthode permettant de changer la catégorie d'un article
	 * Ne fonctionne que si nouv_cat n'est pas nul
	 * @param nouv_cat une catégorie (String)
	 */
	public void setCategorie(String nouv_cat) {
		if(nouv_cat != null) {
			this.categorie = nouv_cat;
		}
	}
	
	/**
	 * Méthode qui affiche toutes les informations sur l'article à la suite (équivaut au toString)
	 */
	public String toString() {
		return "~\nRéférence : " + this.getReference() + "\nDésignation : " + this.getDesignation() + "\nPrix : " + this.getPrix() + "\nCatégorie : " + this.getCategorie() + "\nQuantité en stock : " + this.getQuantiteStock();
	}
	
}

	