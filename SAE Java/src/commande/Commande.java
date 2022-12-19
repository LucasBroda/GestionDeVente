package commande;
import java.util.ArrayList;

import article.Article;
import article.Stock;
import client.Client;

public class Commande {
	private static final LigneCommande[] LigneCommande = null;
	/**
	 * Booléen indiquant si la commande est clôturée.
	 */
	private boolean cloturee;
	/**
	 * Les lignes de commande se trouvant dans la commande.
	 */
	private java.util.ArrayList<LigneCommande> lignesCommande;
	/**
	 * Le nombre maximal de lignes de commande pouvant être dans une commande (valué à 10).
	 */
	static int MAX_LIGNES = 10;
	/**
	 * Le nombre de commande créés (sert également pour attribuer un numéro de référence).
	 */
	private static int nbCommandes=0;
	/**
	 * Numéro de référence de la commande.
	 */
	private int references;
	/**
	 * Le client pour qui est effectué la commande.
	 */
	private Client client;
	
	/**
	 * Constructeur permettant de construire un nouvelle commande ne contenant aucune ligne de commande et associée au client passé en paramètre. La commande créée est non clôturée.
	 * @param client Le client associé à la commande.
	 */
	public Commande(Client client) {
		references = nbCommandes;
		nbCommandes++;
		this.client =client;
		this.cloturee=false;
		this.lignesCommande= new ArrayList<>();
	}
	/**
	 * Méthode retournant le nombre de lignes de commande de la commande.
	 * @return Le nombre de lignes de commande de la commande.
	 */
	public  int getNbLignesCommandes() {
		return this.lignesCommande.size();
	}
	/**
	 * Méthode retournant la référence de la commande.
	 * @return La référence de la commande.
	 */

	public int getReferences() {
		return references;
	}

	/**
	 * Méthode testant si la commande est pleine (si on ne peut pas ajouter de nouvelles commandes).
	 * @return true si et seulement si la commande est pleine.
	 */
	public boolean estPleine() {
		return this.getNbLignesCommandes() == MAX_LIGNES;
	}
	/**
	 * Méthode testant si la commande est vide (il n'y a aucune ligne dans la commande).
	 * @return true si et seulement si la commande est vide.
	 */
	public boolean estVide() {
		return this.getNbLignesCommandes() == 0;
	}
	
	/**
	 * Méthode retournant si la commande est clôturée ou non.
	 * @return true si et seulement si la commande est clôturée.
	 */
	public boolean estCloturee(){	
		return cloturee;
	}
	/**
	 * Méthode retournant l'artinumLigneCommande - Un numéro de ligne de commande compris entre 0 et getNbLignesCommande()-1.
numLigneCommande
	 * @return L'article correspondant à la numLigneCommande ième ligne de commande de la commande. Si numLigneCommande n'est pas comprise entre 0 et getNbLignesCommande()-1 alors null est retournée.
	 */
	public Article getArticle​(int numLigneCommande) {
		if (!estVide() && numLigneCommande > 0 && this.getNbLignesCommandes() > numLigneCommande){
			return lignesCommande.get(numLigneCommande).getArticle();
		}
		return null;
	}
	/**
	 * Méthode retournant la quantité commandée correspondant à une des lignes de commande de la commande.
	 * @param numLigneCommande - Un numéro de ligne de commande compris entre 0 et getNbLignesCommande()-1.
	 * @return La quantité correspondant à la numLigneCommande ième ligne de commande de la commande. Si numLigneCommande n'est pas comprise entre 0 et getNbLignesCommande()-1 alors 0 est retournée.
	 */
	public int getQuantite(int numLigneCommande) {
		if (!estVide() && numLigneCommande > 0 && this.getNbLignesCommandes() > numLigneCommande) {
				return lignesCommande.get(numLigneCommande).getQuantite();
		}
		return 0;
	}
	
	/**
	 * Méthode cherchant une ligne de commande dans la commande concernant un certaine référence d'article. Dans le cas où il n'y a aucune ligne de commande correspondant à l'article, null est retourné.
	 * @param refArticle Un entier supposé être une référence d'article.
	 * @return La ligne de commande de la commande dont l'article a pour référence refArticle. Dans le cas où il n'y a pas une telle ligne de commande, null est retourné.
	 */
	private LigneCommande chercherLigneCommande(int refArticle) {
		if(!estVide()){
			for(LigneCommande ligncmd : lignesCommande) {
				if(ligncmd.getArticle().getReference() == refArticle) return ligncmd;
			}
		}
		return null;
	}
	
	/**
	 * Méthode permettant de supprimer une ligne de commande de la commande. La ligne de commande à supprimer sera celle correspondant à la référence d'un article passé en paramètre. Dans le cas où la commande est clôturée ou lorsqu'il n'existe pas de ligne de commande avec un article ayant la référence passée en paramètre rien n'est fait et false est retourné. Dans le cas contraire, la ligne de commande est supprimée de la commande. D'autre part, la quantité en stock de l'article correspondant à la ligne de commande supprimée devra être augmentée de la quantité associée à la ligne de commande. En cas de suppression effective d'une ligne de commande, true est retourné.
	 * @param refArticle Un entier supposé être une référence d'article.
	 * @return true si et seulement une suppression effective de la ligne de commande a été réalisée.
	 */
	public boolean supprimerLigneCommande(int refArticle) {
		LigneCommande ligncmd = chercherLigneCommande(refArticle);
		if(!estCloturee() || (ligncmd== null)) {
			lignesCommande.remove(ligncmd);
			return true;
		}
		return false;
	}
	
	/**
	 * Méthode retournant le montant total de la commande sans livraison.
	 * @return Le montant total de la commande en supposant sans livraison.
	 */
	public double getMontant() {
		double montant=0;
		if (!estVide()) {
			for(int i=0;i< this.getNbLignesCommandes();i++) 
				montant+= lignesCommande.get(i).getMontant();
		}return montant;
	}
	/**
	 * Méthode retournant le montant total de la commande en supposant une livraison.
	 * @return Le montant total de la commande en supposant une livraison.
	 */
	public double getMontantAvecLivraison() {
		double somme=0;
		if (!estVide()) {
			for(int i=0; i<this.getNbLignesCommandes();i++) {
				somme+=lignesCommande.get(i).getMontantAvecLivraison();
			}
		}
		return somme;
	}
	/**
	 * @param article L'article à commander.
	 * @param quantite  La qauntité à commander.
	 * @return true si et seulement si la quantité à commander a été bien commandée (et qu'elle est différente de 0).
	 */
	
	public boolean commander​(Article article, int quantite) {
		if(nbCommandes == MAX_LIGNES || this.cloturee == true || quantite == 0 || article.getQuantiteStock()<quantite) {
			return false;
		}
		for(LigneCommande ligncmd : lignesCommande) {
			if(ligncmd.getArticle().getReference() == article.getReference()) {	
				ligncmd.ajouterQuantite(quantite);
				return true;
			}
		}
		lignesCommande.add(new LigneCommande(article,quantite));
		return true;
	}
	
	/**
	 * Méthode permettant la clôture de la commande. Si la commande est déjà clôturée rien est fait. Dans le cas contraire, la commande est clôturée et des points de fidélité sont ajoutés au client en fonction du montant avec ou sans livraison de la commande. 1 point de fidélité est ajouté par tranche de 10 euros d'achat.
	 * @param Livraison Booléen indique si le client a opté pour une livraison à son domicile ou non.
	 */
	public void cloturer(boolean livraison) {
		if(!estCloturee() && !livraison) {
			this.cloturee=true;
			client.setPointsFidelite(client.getPointsFidelite()+((int)this.getMontant()/10));
		}
		else {
			this.cloturee=true;
			client.setPointsFidelite(client.getPointsFidelite()+((int)+this.getMontantAvecLivraison()/10));
		}
	}
	/**
	 * Méthode retournant une représentation textuelle d'une commande. Cette représentation contient notamment : le numéro de la commande, si la commande est clôturée ou pas, les informations sur le client, sur les lignes de commande et les montants avec ou sans livraison.
	 */
	public String toString() {
		String clo = "(cloturée)";
		if (estCloturee()==false) clo ="(non cloturée)";
		String res= "--------------------------------------------------------------- \nNuméro de commande : " + this.getReferences()+" "+clo+"\n";
		res+= "Client\n"+client.toString()+"\n";
		res+= "Articles commandés\n"+lignesCommande.toString()+"\n";
		res+= "Montants\n";
		res+= "Montant sans livraison : "+this.getMontant();
		res+= "\nMontant avec livraison : "+this.getMontantAvecLivraison();
		return res;
	}
	
}
