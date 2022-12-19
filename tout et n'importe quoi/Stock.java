package article;

public class Stock {
	static final int MAX_ARTICLES=200;
	private int nbArticles;
	private String nom;
	private Article[] articles;
	
	public Stock(String nom) {
		/**
		 * Le constructeur de la classe Stcok
		 */
		this.nom = nom;
		nbArticles = 0;
		this.articles = new Article[MAX_ARTICLES];
	}
	
	
	public String getNom() {
		/**
		 * Méthode retournant le nom du stock
		 * @return le nom du stock
		 */
		return this.nom;
	}
	
	public void setNom(String nouv_nom) {
		/**
		 * Méthode remplaçant le nom du stock par le nom en paramètres.
		 * Ne marche que si nouv_nom n'est pas null
		 */
		if(nouv_nom != null) {
			this.nom = nouv_nom;
		}
	}
	public int getNbArticles() {
		/**
		 * Méthode retournant le nombre d'articles du stock
		 * @return nombre d'articles présent dans le stock
		 */
		return this.nbArticles;
	}
	
	public Article[] articlesDansStock() {
		/**
		 * Méthode retournant le tableau d'articles du stock
		 * @return tableau d'articles avec tous les articles du stock
		 */
		Article[] tab = new Article[this.getNbArticles()];
		for(int x=0;x < this.getNbArticles();x++) {
			tab[x] = articles[x];
		}
		return tab;
	}
	
	public boolean estVide() {
		/**
		 * Méthode permettant de savoir si un stock est vide
		 * Retourne true si c'est le cas et false sinon
		 * @return booléen, true si vide et false dans les autres cas
		 */
		return(this.getNbArticles() == 0);
	}
	
	public boolean estPlein() {
		/**
		 * Méthode permettant de savoir si un stock est plein
		 * Retourne true si c'est le cas et false sinon
		 * @return booléen, true si plein et false dans les autres cas
		 */
		return(this.getNbArticles() == MAX_ARTICLES);
	}
	
	public void ajouterArticle(Article art) {
		/**
		 * Méthode permettant d'ajouter un article au tableau des artices si celui-ci n'est pas plein.
		 */
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
			if(articles[x].getReference() == ref) {
				art = articles[x];
				break;
			}
		}
		return art;	
	}
	
	public int getPosArticle(Article art) {
		/**
		 * Méthode permettant d'obtenir la position d'un article
		 * @return la position de l'article si trouvé,  -1 sinon
		 */
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
	
	public int getPosArticleReference(int ref) {
		/**
		 * Méthode permettant d'obtenir la position d'un article à partir de sa référence
		 * @return la position de l'article si trouvé,  -1 sinon
		 */
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
	
	public void supprimerArticle(Article art) {
		/** 
		 * Méthode permettant la suppression d'un article passé en paramètre
		 */
		int pos = getPosArticle(art);
		if(pos != -1) {
			Article temp = articles[this.getNbArticles()];
			articles[pos] = temp;
			articles[this.getNbArticles()] = null;
		}
		
	}
	
	public void supprimerArticleReference(int ref) {
		/** 
		 * Méthode permettant la suppression d'un article à partir de sa référence passée en paramètre
		 */
		int pos = getPosArticleReference(ref);
		if(pos != -1) {
			Article temp = articles[this.getNbArticles()];
			articles[pos] = temp;
			articles[this.getNbArticles()] = null;
		}
	}
	
	public Article[] rechercherArticlesCategorie(String categorie) {
		/**
		 * Recherche la liste des articles appartenant à telle ou telle catégorie
		 * @return un tableau d'articles appartenant tous à la catégorie passée en paramètre
		 */
		int nbArtCatego = 0;
		Article[] art_catego = new Article[this.getNbArticles()];
		for(int x=0;x < this.getNbArticles();x++) {
			if(articles[x].getCategorie() == categorie){
				art_catego[nbArtCatego] = articles[x];
				nbArtCatego++;
			}
		}
		return art_catego;
	}
	
	
	
}
