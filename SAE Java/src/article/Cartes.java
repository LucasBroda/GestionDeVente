package article;

import util.Util;
/**
 * Une classe permettant de représenter des cartes (à jouer/à colectionner), un type d'Article.
 * @author TomD
 * @version 06/04/2022
 *
 */
public class Cartes extends Article {
	private String franchise;
	private String type;
	private String extension;
	
	/** 
	 * Constructeur de la classe Cartes
	 */
	public Cartes(String designation, double prix, int quantiteStock, String franchise,
			String type, String extension) {
		super(designation,prix,quantiteStock);
		this.setCategorie("Cartes");
		this.franchise = franchise;
		this.type = type;
		this.extension = extension;
	}

	/**
	 * Constructeur de la classe cartes (vide)
	 */
	public Cartes() {
		super();
	}
	
	/**
	 * Retourne la franchise d'où viennent les cartes
	 * @return la franchise
	 */
	public String getFranchise() {
		return this.franchise;
	}
	
	/**
	 * Méthode renvoyant le type de produit (boosters de cartes, boîte...)
	 * @return le type de produit
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * méthode qui permet de saisir les différentes informations sur des cartes
	 */
	public void saisirInfos() {
		super.saisirInfos();
		this.setCategorie("Cartes");
		this.franchise = Util.saisirChaine("saisir franchise : ");
		this.type = Util.saisirChaine("saisir le type de paquet (booster, pack...) : ");
		this.extension = Util.saisirChaine("saisir l'extension du jeu de cartes : ");
	}
	
	/**
	 * retourne l'extension d'où sont issues les cartes
	 * @return l'extension des cartes
	 */
	public String getExtension() {
		return this.extension;
	}
	
	/**
	 * Méthode qui affiche toutes les informations sur les cartes
	 */
	public String toString() {
		String anc = super.toString();
		return anc + "\nFranchise : " + this.getFranchise() + " Type : " + this.getType() + " Extension : " + this.getExtension();
	}
	
	/**méthode retournant la liste (dans le stock) des cartes de l'extension passée en paramètre
	 * @param  le stock sur lequel on effectue la recherche, de type Stock
	 * @param le nom de l'extension que l'on recherche (String)
	 * @return la liste des cartes appartenant à l'extension en paramètre
	 */
	public static Cartes[] rechercheParExtension(Stock stock, String extension) {
		int nbCarExt = 0;
		Cartes[] car_ext = new Cartes[stock.getNbArticles()];
		Article[] arts = stock.articlesDansStock();
		for(int x=0;x < stock.getNbArticles();x++) {
			if(arts[x].getCategorie().equals("Cartes")){
				Cartes temp = (Cartes)arts[x];
				if(temp.getExtension().contains(extension)) {
					car_ext[nbCarExt] = temp;
					nbCarExt++;
				}
			}
		}
		return car_ext;
	}
	
	
	/**méthode retournant la liste (dans le stock) des cartes de la franchise passée en paramètre
	 * @param  le stock sur lequel on effectue la recherche, de type Stock
	 * @param le nom de la franchise que l'on recherche (String)
	 * @return la liste des cartes appartenant à la franchise passée en paramètre
	 */
	public static Cartes[] rechercheParFranchise(Stock stock, String franchise) {
		int nbCarFran = 0;
		Cartes[] car_fran = new Cartes[stock.getNbArticles()];
		Article[] arts = stock.articlesDansStock();
		for(int x=0;x < stock.getNbArticles();x++) {
			if(arts[x].getCategorie().equals("Cartes")){
				Cartes temp = (Cartes)arts[x];
				if(temp.getExtension().contains(franchise)) {
					car_fran[nbCarFran] = temp;
					nbCarFran++;
				}
			}
		}
		return car_fran;
	}
		
}
