package article;

import util.Util;

public class Cartes extends Article {
	private String franchise;
	private String type;
	private String extension;
	
	protected Cartes(String designation, double prix, int quantiteStock, String franchise,
			String type, String extension) {
		/** 
		 * Constructeur de la classe Cartes
		 */
		super(designation,prix,quantiteStock);
		this.setCategorie("Cartes");
		this.franchise = franchise;
		this.type = type;
		this.extension = extension;
	}

	public Cartes() {
		/**
		 * Constructeur de la classe cartes (vide)
		 */
		super();
	}
	public String getFranchise() {
		/**
		 * Retourne la franchise d'où viennent les cartes
		 * @return la franchise
		 */
		return this.franchise;
	}
	
	public String getType() {
		/**
		 * Méthode renvoyant le type de produit (boosters de cartes, boîte...)
		 * @return le type de produit
		 */
		return this.type;
	}
	
	public void saisirInfos() {
		/**
		 * méthode qui permet de saisir les différentes informations sur des cartes
		 */
		super.saisirInfos();
		this.setCategorie("Cartes");
		this.franchise = Util.saisirChaine("saisir franchise : ");
		this.type = Util.saisirChaine("saisir le type de paquet (booster, pack...) : ");
		this.extension = Util.saisirChaine("saisir l'extension du jeu de cartes : ");
	}
	public String getExtension() {
		/**
		 * retourne l'extension d'où sont issues les cartes
		 * @return l'extension des cartes
		 */
		return this.extension;
	}
	
	public void afficherInfos() {
		/**
		 * Méthode qui affiche toutes les informations sur les cartes
		 */
		super.afficherInfos();
		System.out.println("Franchise : " + this.getFranchise() + " Type : " + this.getType() + " Extension : " + this.getExtension());
	}
	
	public static Cartes[] rechercheParExtension(Stock stock, String extension) {
		/**méthode retournant la liste (dans le stock) des cartes de l'extension passée en paramètre
		 * @return la liste des cartes appartenant à l'extension en paramètre
		 */
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
	
	public static Cartes[] rechercheParFranchise(Stock stock, String franchise) {
		/**méthode retournant la liste (dans le stock) des cartes de la franchise passée en paramètre
		 * @return la liste des cartes appartenant à la franchise passée en paramètre
		 */
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
