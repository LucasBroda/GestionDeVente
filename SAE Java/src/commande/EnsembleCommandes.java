package commande;

public class EnsembleCommandes {
	static final int MAX_COMMANDES=700;
	private int nbCommandes;
	private Commande[] commandes;
	
	/**
	 * Constructeur de la classe EnsembleCommandes
	 */
	public EnsembleCommandes() {
		this.nbCommandes = 0;
		this.commandes = new Commande[MAX_COMMANDES];
	}
	
	/**
	 * Méthode retournant le nombre de commandes de l'ensemble
	 * @return nombre de commandes dans l'ensemble de commandes
	 */
	public int getNbCommandes() {
		return this.nbCommandes;
	}
	
	/**
	 * Méthode permettant de savoir si un ensemble de commandes est vide
	 * Retourne true si c'est le cas et false sinon
	 * @return booléen, true si vide et false dans les autres cas
	 */
	public boolean estVide() {
		return(this.getNbCommandes() == 0);
	}
	
	/**
	 * Méthode permettant de savoir si un ensemble de commandes est plein
	 * Retourne true si c'est le cas et false sinon
	 * @return booléen, true si plein et false dans les autres cas
	 */
	public boolean estPlein() {
		return(this.getNbCommandes() == MAX_COMMANDES);
	}
	
	/**
	 * Méthode permettant d'ajouter une commande au tableau des commandes si celui-ci n'est pas plein.
	 * @param com l'objet de type Commande à ajouter
	 */
	public void ajouterCommande(Commande com) {
		if(!(this.estPlein())) {
			commandes[this.getNbCommandes()] = com;
			nbCommandes ++;
		}
	}
	
	/**
	 * Méthode retournant le tableau de commandes de l'ensemble
	 * @return tableau des différentes commandes
	 */
	public Commande[] getCommandes() {
		Commande[] tab = new Commande[this.getNbCommandes()];
		for(int x=0;x < this.getNbCommandes();x++) {
			tab[x] = commandes[x];
		}
		return tab;
	}
	
	/**
	 * Méthode affichant l'ensemble des commandes
	 */
	public void afficher() {
		for(int x=0;x < this.getNbCommandes();x++) {
			if(commandes[x] == null) {
				break;
			}
			System.out.println(commandes[x]);
		}
	}
	public Commande rechercherCommandeParReference(int ref) {
		/**
		 * Méthode recherchant une commande grâce à sa référence
		 * @return la commande si trouvée, null sinon
		 */
		Commande com = null;
		for(int x=0;x < this.getNbCommandes();x++){
			if(commandes[x].getReferences() == ref) {
				com = commandes[x];
				break;
			}
		}
		return com;	
	}
	
	/**
	 * Méthode permettant d'obtenir la position d'une commandeicle
	 * @return la position de la commande si trouvée,  -1 sinon
	 * @param l'comicle cherché
	 */
	public int getPosCommande(Commande com) {
		int pos = -1;
		if(!(this.estVide())) {
			for(int x=0;x < this.getNbCommandes();x++) {
				if(commandes[x] == com) {
					pos = x;
					break;
				}
			}
		}
		return pos;
	}
	
	/**
	 * Méthode permettant d'obtenir la position d'une commande à partir de sa référence
	 * @param ref la référence de la commande
	 * @return la position de la commande si trouvé,  -1 sinon
	 */
	public int getPosCommandeReference(int ref) {
		int pos = -1;
		if(!(this.estVide())) {
			for(int x=0;x < this.getNbCommandes();x++) {
				if(commandes[x].getReferences() == ref) {
					pos = x;
					break;
				}
			}
		}
		return pos;
	}
	
	/** 
	 * Méthode permettant la suppression d'une commande passée en paramètre
	 * com l'objet de type Commande à supprimer
	 * @return 
	 */
	public boolean supprimerCommande(int i) {
		int pos = getPosCommandeReference(i);
		if(pos != -1) {
			Commande temp = commandes[this.getNbCommandes()-1];
			commandes[pos] = temp;
			commandes[this.getNbCommandes()-1] = null;
			return true;
		}
		return false;
		
	}
	
	/** 
	 * Méthode permettant la suppression d'une commande à partir de sa référence passée en paramètre
	 * @param ref la référence (int) de la commande à supprimer
	 */
	public void supprimerCommandeReference(int ref) {
		int pos = getPosCommandeReference(ref);
		if(pos != -1) {
			Commande temp = commandes[this.getNbCommandes()-1];
			commandes[pos] = temp;
			commandes[this.getNbCommandes()-1] = null;
			System.out.println("Commande supprimée !");
		}
		else {
			System.out.println("Commande non trouvée !");
		}
	}
	
}
