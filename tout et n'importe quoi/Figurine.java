package article;

import util.Util;

public class Figurine extends Article implements Livrable {
	private String franchise;
	private String personnage;
	private String fournisseur;
	private String type;
	private double poids;
	private double hauteur;
	private double profondeur;
	private double largeur;
	
	protected Figurine(String designation, double prix, int quantiteStock, String franchise, String personnage,
			String fournisseur, String type, double poids, double hauteur, double profondeur, double largeur) {
		/**
		 * Constructeur de la classe Figurine
		 */
		super(designation,prix,quantiteStock);
		this.setCategorie("Figurine");
		this.franchise = franchise;
		this.personnage = personnage;
		this.fournisseur = fournisseur;
		this.type = type;
		this.poids = poids;
		this.hauteur = hauteur;
		this.profondeur = profondeur;
		this.largeur = largeur;
	}
	public Figurine() {
		/**
		 * Constructeur de la classe figurine (vide)
		 */
		super();
	}
	
	public void saisirInfos() {
	/**
	 * méthode qui permet de saisir les différentes informations sur une figurine
	 */
		super.saisirInfos();
		this.setCategorie("Figurines");
		this.franchise = Util.saisirChaine("saisir franchise : ");
		this.personnage = Util.saisirChaine("saisir personnage : ");
		this.fournisseur = Util.saisirChaine("saisir fournisseur : ");
		this.type = Util.saisirChaine("saisir le type de figurine : ");
		this.poids = Util.saisirDoublePositif("saisir poids (grammes) : ");
		this.hauteur = Util.saisirDoublePositif("saisir hauteur (cm) : ");
		this.largeur = Util.saisirDoublePositif("saisir largeur (cm) : ");
		this.profondeur = Util.saisirDoublePositif("saisir profondeur (cm) : ");
	}
	public String getFranchise() {
	/**
	* Méthode retournant la franchise dont est issu le personnage de la figurine
	* @return La franchise du personnage
	*/
		return this.franchise;
	}
	
	public String getPersonnage() {
	/**
	* Méthode retournant le personnage présent sur la figurine
	* @return Le personnage de la figurine
	*/
		return this.personnage;
	}
	
	public String getFournisseur() {
	/**
	* Méthode retournant le fournisseur/créateur de la figurine
	* @return Le fournisseur de la figurine
	*/
		return this.fournisseur;
	}
	
	public String getType() {
	/**
	* Méthode retournant le type de figurine (figurine articulée, figurine à monter, chibi, etc.)
	* @return Le type de figurine
	*/
		return this.type;
	}
	
	public double getPoids() {
	/**
	 * Méthode qui retourne le poids de la figurine en grammes
	 * @return le poids de la figurine
	 */
		return this.poids;
	}
	
	public double getHauteur() {
		/**
		 * Méthode qui retourne la hauteur de la figurine en centimètres 
		 * @return la hauteur de la figurine
		 */
		return this.hauteur;
	}
	
	public double getLargeur() {
		/**
		 * Méthode qui retourne la largeur de la figurine en centimètres 
		 * @return la largeur de la figurine
		 */
		return this.largeur;
	}
	
	public double getProfondeur() {
		/**
		 * Méthode qui retourne la profondeur de la figurine en centimètres 
		 * @return la profondeur de la figurine
		 */
		return this.profondeur;
	}
	public void setHauteur(double nouv_haut) {
		/**
		 * Méthode modifiant la hauteur de la figurine avec la valeur passée en paramètres.
		 * Ne fonctionne que si cette valeur est supérieure à 0
		 */
		if(nouv_haut > 0) {
			this.hauteur = nouv_haut;
		}
	}
	
	public void setLargeur(double nouv_larg) {
		/**
		 * Méthode modifiant la largeur de la figurine avec la valeur passée en paramètres.
		 * Ne fonctionne que si cette valeur est supérieure à 0
		 */
		if(nouv_larg > 0) {
			this.largeur = nouv_larg;
		}
	}
	
	public void setProfondeur(double nouv_prof) {
		/**
		 * Méthode modifiant la profondeur de la figurine avec la valeur passée en paramètres.
		 * Ne fonctionne que si cette valeur est supérieure à 0
		 */
		if(nouv_prof > 0) {
			this.profondeur = nouv_prof;
		}
	}
	
	public double getPoidsKgColis() {
		/**
		 * Méthode qui retourne le poids du colis en kilos
		 * @return poids (double) en kilos
		 */
		return this.getPoids()*0.001;
	}
	
	public int getHauteurColis() {
		int haut = (int)Math.ceil(this.getHauteur());
		return haut;
	}
	
	public int getLargeurColis() {
		int larg = (int)Math.ceil(this.getLargeur());
		return larg;
	}
	
	public int getProfondeurColis() {
		int prof = (int)Math.ceil(this.getProfondeur());
		return prof;
	}
	
	public void afficherDimensions(){
		/**
		 * Méthode qui affiche différentes informations liées aux dimensions de la figurine, ainsi que l'unité
		 * Hauteur, largeur, profondeur et poids
		 */
		System.out.println("Hauteur : " + this.getHauteur() + " cm\nLargeur : " + this.getLargeur() + 
				" cm\n Profondeur : " + this.getProfondeur() + " cm\nPoids : " + this.getPoids() + " grammes");
	}
	public void afficherInfos() {
		/**
		 * Méthode qui affiche toutes les informations sur la figurine.
		 */
		super.afficherInfos();
		System.out.println("Personnage : " + this.getPersonnage() + " Franchise : " + this.getFranchise() +
				" Fournisseur : " + this.getFournisseur() + " type de figurine : " + this.getType());
	}
	
	
	public static Figurine[] rechercheParPerso(Stock stock, String perso) {
		/**méthode retournant la liste (dans le stock) des figurines contenant le personnage passé en paramètre
		 * Une figurine peut avoir plusieurs personnages, on utilise contain()
		 * @return la liste des figurines contenant le personnage en question
		 */
		int nbFigPerso = 0;
		Figurine[] figus_perso = new Figurine[stock.getNbArticles()];
		Article[] arts = stock.articlesDansStock();
		for(int x=0;x < stock.getNbArticles();x++) {
			if(arts[x].getCategorie().equals("Figurines")){
				Figurine temp = (Figurine)arts[x];
				if(temp.getPersonnage().contains(perso)) {
					figus_perso[nbFigPerso] = temp;
					nbFigPerso++;
				}
			}
		}
		return figus_perso;
	}
	
	public static Figurine[] rechercheParFranchise(Stock stock, String franchise) {
		/**méthode retournant la liste (dans le stock) des figurines de la franchise passée en paramètre
		 * @return la liste des figurines de la franchise
		 */
		int nbFigFranch = 0;
		Figurine[] figus_franch = new Figurine[stock.getNbArticles()];
		Article[] arts = stock.articlesDansStock();
		for(int x=0;x < stock.getNbArticles();x++) {
			if(arts[x].getCategorie().equals("Figurines")){
				Figurine temp = (Figurine)arts[x];
				if(temp.getFranchise().contains(franchise)) {
					figus_franch[nbFigFranch] = temp;
					nbFigFranch++;
				}
			}
		}
		return figus_franch;
	}
	
	public static Figurine[] rechercheParFournisseur(Stock stock, String fournisseur) {
		/**méthode retournant la liste (dans le stock) des figurines du fournisseur passée en paramètre
		 * @return la liste des figurines du fournissuer
		 */
		int nbFigFourn = 0;
		Figurine[] figus_fourn = new Figurine[stock.getNbArticles()];
		Article[] arts = stock.articlesDansStock();
		for(int x=0;x < stock.getNbArticles();x++) {
			if(arts[x].getCategorie().equals("Figurines")){
				Figurine temp = (Figurine)arts[x];
				if(temp.getFournisseur().contains(fournisseur)) {
					figus_fourn[nbFigFourn] = temp;
					nbFigFourn++;
				}
			}
		}
		return figus_fourn;
	}
}
