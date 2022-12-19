package article;

import util.Util;
/**
 * Une classe permettant de représenter des figurines, un type d'Article.
 * @author TomD
 *@version 06/04/2022
 */

public class Figurine extends Article implements Livrable {
	private String franchise;
	private String personnage;
	private String fournisseur;
	private String type;
	private double poids;
	private double hauteur;
	private double profondeur;
	private double largeur;
	
	/**
	 * Constructeur de la classe Figurine
	 */
	public Figurine(String designation, double prix, int quantiteStock, String franchise, String personnage,
			String fournisseur, String type, double poids, double hauteur, double profondeur, double largeur) {
		super(designation,prix,quantiteStock);
		this.setCategorie("Figurines");
		this.franchise = franchise;
		this.personnage = personnage;
		this.fournisseur = fournisseur;
		this.type = type;
		this.poids = poids;
		this.hauteur = hauteur;
		this.profondeur = profondeur;
		this.largeur = largeur;
	}
	/**
	 * Constructeur de la classe figurine (vide)
	 */
	public Figurine() {
		super();
	}
	
	/**
	 * Méthode qui permet de saisir les différentes informations sur une figurine
	 */
	public void saisirInfos() {
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
	
	/**
	* Méthode retournant la franchise dont est issu le personnage de la figurine
	* @return La franchise du personnage
	*/
	public String getFranchise() {
		return this.franchise;
	}
	
	/**
	* Méthode retournant le personnage présent sur la figurine
	* @return Le personnage de la figurine
	*/
	public String getPersonnage() {
		return this.personnage;
	}
	
	/**
	* Méthode retournant le fournisseur/créateur de la figurine
	* @return Le fournisseur de la figurine
	*/
	public String getFournisseur() {
		return this.fournisseur;
	}
	
	/**
	* Méthode retournant le type de figurine (figurine articulée, figurine à monter, chibi, etc.)
	* @return Le type de figurine
	*/
	public String getType() {
		return this.type;
	}
	
	/**
	 * Méthode qui retourne le poids de la figurine en grammes
	 * @return le poids de la figurine
	 */
	public double getPoids() {
		return this.poids;
 	}
	
	/**
	 * Méthode qui retourne la hauteur de la figurine en centimètres 
	 * @return la hauteur de la figurine
	 */
	public double getHauteur() {
		return this.hauteur;
	}
	
	/**
	 * Méthode qui retourne la largeur de la figurine en centimètres 
	 * @return la largeur de la figurine
	 */
	public double getLargeur() {
		return this.largeur;
	}
	
	/**
	 * Méthode qui retourne la profondeur de la figurine en centimètres 
	 * @return la profondeur de la figurine
	 */
	public double getProfondeur() {
		return this.profondeur;
	}
	/**
	 * Méthode modifiant la hauteur de la figurine avec la valeur passée en paramètres.
	 * Ne fonctionne que si cette valeur est supérieure à 0
	 * @param nouv_haut la nouvelle hauteur (double strictement supérieur à 0)
	 */
	public void setHauteur(double nouv_haut) {
		if(nouv_haut > 0) {
			this.hauteur = nouv_haut;
		}
	}
	
	/**
	 * Méthode modifiant la largeur de la figurine avec la valeur passée en paramètres.
	 * Ne fonctionne que si cette valeur est supérieure à 0
	 * @param nouv_larg la nouvelle largeur (double strictement supérieur à 0)
	 */
	public void setLargeur(double nouv_larg) {
		if(nouv_larg > 0) {
			this.largeur = nouv_larg;
		}
	}
	
	/**
	 * Méthode modifiant la profondeur de la figurine avec la valeur passée en paramètres.
	 * Ne fonctionne que si cette valeur est supérieure à 0
	 * @param nouv_prof la nouvelle profondeur (double strictement supérieur à 0)
	 */
	public void setProfondeur(double nouv_prof) {
		if(nouv_prof > 0) {
			this.profondeur = nouv_prof;
		}
	}
	
	/**
	 * Méthode qui retourne le poids du colis en kilos
	 * @return poids (double) en kilos
	 */
	public double getPoidsKgColis() {
		return this.getPoids()*0.001;
	}
	
	/**
	 * Méthode qui retourne la hauteur du colis en faisant un arrondis vers la valeur du dessus
	 * (exemple : 17,3 cm > 18 cm)
	 * @return haute la hauteur (double) en centimètres
	 */
	public int getHauteurColis() {
		int haut = (int)Math.ceil(this.getHauteur());
		return haut;
	}
	
	/**
	 * Méthode qui retourne la largeur du colis en faisant un arrondis vers la valeur du dessus
	 * (exemple : 17,3 cm > 18 cm)
	 * @return haute la largeur (double) en centimètres
	 */
	public int getLargeurColis() {
		int larg = (int)Math.ceil(this.getLargeur());
		return larg;
	}
	
	/**
	 * Méthode qui retourne la pofondeur du colis en faisant un arrondis vers la valeur du dessus
	 * (exemple : 17,3 cm > 18 cm)
	 * @return haute la profondeur (double) en centimètres
	 */
	public int getProfondeurColis() {
		int prof = (int)Math.ceil(this.getProfondeur());
		return prof;
	}
	
	/**
	 * Méthode qui affiche différentes informations liées aux dimensions de la figurine, ainsi que l'unité
	 * Hauteur, largeur, profondeur et poids
	 */
	public void afficherDimensions(){
		System.out.println("Hauteur : " + this.getHauteur() + " cm\nLargeur : " + this.getLargeur() + 
				" cm\n Profondeur : " + this.getProfondeur() + " cm\nPoids : " + this.getPoids() + " grammes");
	}
	
	/**
	 * Méthode qui affiche toutes les informations sur la figurine.
	 */
	public String toString() {
		String anc = super.toString();
		return anc +"\nPersonnage : " + this.getPersonnage() + " Franchise : " + this.getFranchise() +
				" Fournisseur : " + this.getFournisseur() + "\nType de figurine : " + this.getType();
	}
	
	
	/**Méthode retournant la liste (dans le stock) des figurines contenant le personnage passé en paramètre
	 * Une figurine peut avoir plusieurs personnages, on utilise contain()
	 * @param  le stock sur lequel on effectue la recherche, de type Stock
	 * @param le nom du personnage que l'on recherche (String)
	 * @return la liste des figurines contenant le personnage en question
	 */
	public static Figurine[] rechercheParPerso(Stock stock, String perso) {
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
	
	/**Méthode retournant la liste (dans le stock) des figurines de la franchise passée en paramètre
	 * @param  le stock sur lequel on effectue la recherche, de type Stock
	 * @param le nom de la franchise que l'on recherche (String)
	 * @return la liste des figurines de la franchise
	 */
	public static Figurine[] rechercheParFranchise(Stock stock, String franchise) {
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
	
	/**Méthode retournant la liste (dans le stock) des figurines du fournisseur passée en paramètre
	 * @param  le stock sur lequel on effectue la recherche, de type Stock
	 * @param le nom du fournisseur que l'on recherche (String)
	 * @return la liste des figurines du fournissuer
	 */
	public static Figurine[] rechercheParFournisseur(Stock stock, String fournisseur) {
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
