package article;
/**
 * 
 * @author TomD
 * @version 06/04/2022
 *
 */
public class Stock {
	static final int MAX_ARTICLES=50;
	private int nbArticles;
	private String nom;
	private Article[] articles;
	
	/**
	 * Le constructeur de la classe Stcok
	 */
	public Stock(String nom) {
		this.nom = nom;
		nbArticles = 0;
		this.articles = new Article[MAX_ARTICLES];
	}
	
	
	/**
	 * Méthode retournant le nom du stock
	 * @return le nom du stock
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Méthode remplaçant le nom du stock par le nom en paramètres.
	 * Ne marche que si nouv_nom n'est pas null
	 * @param nom le nom du stock
	 */
	public void setNom(String nouv_nom) {
		if(nouv_nom != null) {
			this.nom = nouv_nom;
		}
	}
	
	/**
	 * Méthode retournant le nombre d'articles du stock
	 * @return nombre d'articles présent dans le stock
	 */
	public int getNbArticles() {
		return this.nbArticles;
	}
	
	/**
	 * Méthode retournant le tableau d'articles du stock
	 * @return tableau d'articles avec tous les articles du stock
	 */
	public Article[] articlesDansStock() {
		Article[] tab = new Article[this.getNbArticles()];
		for(int x=0;x < this.getNbArticles();x++) {
			tab[x] = articles[x];
		}
		return tab;
	}
	
	/**
	 * Méthode permettant de savoir si un stock est vide
	 * Retourne true si c'est le cas et false sinon
	 * @return booléen, true si vide et false dans les autres cas
	 */
	public boolean estVide() {
		return(this.getNbArticles() == 0);
	}
	
	/**
	 * Méthode permettant de savoir si un stock est plein
	 * Retourne true si c'est le cas et false sinon
	 * @return booléen, true si plein et false dans les autres cas
	 */
	public boolean estPlein() {
		return(this.getNbArticles() == MAX_ARTICLES);
	}
	
	/**
	 * Méthode permettant d'ajouter un article au tableau des articles si celui-ci n'est pas plein.
	 * @param art l'objet de type Article à ajouter
	 */
	public void ajouterArticle(Article art) {
		if(!(this.estPlein())) {
			articles[this.getNbArticles()] = art;
			nbArticles ++;
		}
	}
	
	public Article rechercherArticleParReference(int ref) {
		/**
		 * Méthode recherchant un article grâce à sa référence
		 * @return l'article si trouvé, null sinon
		 */
		Article art = null;
		for(int x=0;x < this.getNbArticles();x++){
			if (! (articles[x] == null)) {
				if(articles[x].getReference() == ref) {
					art = articles[x];
					break;
				}	
			}
		}
		return art;	
	}
	
	/**
	 * Méthode permettant d'obtenir la position d'un article
	 * @return la position de l'article si trouvé,  -1 sinon
	 * @param l'article cherché
	 */
	public int getPosArticle(Article art) {
		int pos = -1;
		if(!(this.estVide())) {
			for(int x=0;x < this.getNbArticles();x++) {
				if(articles[x] == art) {
					pos = x;
					break;
				}
			}
		}
		return pos;
	}
	
	/**
	 * Méthode permettant d'obtenir la position d'un article à partir de sa référence
	 * @param ref la référence de l'article
	 * @return la position de l'article si trouvé,  -1 sinon
	 */
	public int getPosArticleReference(int ref) {
		int pos = -1;
		if(!(this.estVide())) {
			for(int x=0;x < this.getNbArticles();x++) {
				if(articles[x].getReference() == ref) {
					pos = x;
					break;
				}
			}
		}
		return pos;
	}
	
	/** 
	 * Méthode permettant la suppression d'un article passé en paramètre
	 * @param l'objet de type Article à supprimer
	 */
	public void supprimerArticle(Article art) {
		int pos = getPosArticle(art);
		if(pos != -1) {
			Article temp = articles[this.getNbArticles()-1];
			articles[pos] = temp;
			articles[this.getNbArticles()-1] = null;
		}
		
	}
	
	/** 
	 * Méthode permettant la suppression d'un article à partir de sa référence passée en paramètre
	 * @param ref la référence (int) de l'article à supprimer
	 */
	public void supprimerArticleReference(int ref) {
		int pos = getPosArticleReference(ref);
		if(pos != -1) {
			Article temp = articles[this.getNbArticles()-1];
			articles[pos] = temp;
			articles[this.getNbArticles()-1] = null;
			System.out.println("Article supprimé !");
		}
		else {
			System.out.println("Article non trouvé !");
		}
	}
	
	/**
	 * Recherche la liste des articles appartenant à telle ou telle catégorie
	 * @param la catégorie recherchée
	 * @return un tableau d'articles appartenant tous à la catégorie passée en paramètre
	 */
	public Article[] rechercherArticlesCategorie(String categorie) {
		int nbArtCatego = 0;
		Article[] art_catego = new Article[this.getNbArticles()];
		for(int x=0;x < this.getNbArticles();x++) {
			if(articles[x].getCategorie().equals(categorie)){
				art_catego[nbArtCatego] = articles[x];
				nbArtCatego++;
			}
		}
		return art_catego;
	}
	
	
	
}
