package client;

import java.util.Locale;

/**
 * Un objet de la classe CarnetClients correspond à un carnet de clients. Chaque carnet de clients a un nom ("Carnet Clients 2022" par exemple) et permet de gérer un ensemble de clients. Un carnet de clients ne peut pas contenir plus de CarnetClients.MAX_CLIENTS clients.
 * @author hugo.potier
 * @version 05/04/2022
 */
public class CarnetClients{

    /**
     * Les clients se trouvant dans le carnet.
     */
    private Client[] clients;
    /**
     * Le nombre maximal de clients pouvant être dans un carnet (valué à 10).
     */
    final static int MAX_CLIENTS = 25;
    /**
     * Le nombre de clients dans le carnet.
     */
    private int nbClients;
    /**
     * Le nom du carnet de clients.
     */
    private String nom;

    /**
     * Constructeur permettant de construire un nouveau carnet de clients.
     * @param nom Le nom du carnet de clients
     */
    public CarnetClients(String nom) {
        this.nom=nom;
        this.clients = new Client[MAX_CLIENTS];
        this.nbClients=0;
    }

    /**
     * Méthode retournant le nom du carnet de clients.
     * @return Le nom du carnet de clients.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode permettant de modifier le nom du carnet de clients.
     * @param nom Le nouveau nom du carnet.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode retournant le nombre de clients du carnet.
     * @return Le nombre de clients dans le carnet.
     */
    public int getNbClients() {
        return nbClients;
    }

    /**
     * Méthode testant si le carnet est plein.
     * @return true si et seulement si le carnet de clients est plein.
     */
    public boolean estPlein() {
        return this.getNbClients()==MAX_CLIENTS;
    }

    /**
     * Méthode testant si le carnet est vide.
     * @return true si et seulement si le carnet de clients est vide.
     */
    public boolean estVide() {
        return this.getNbClients()==0;
    }

    /**
     * Méthode cherchant un client dans le tableau clients correspondant (ayant même référence) au client passé en parmaètre.
     * @param client Un client (supposé non null).
     * @return L'indice où se trouve ce client dans le tableau clients. Dans le cas où le client n'est pas présent -1 est retourné.
     */
    private int chercherIndiceClient(Client client) {
        if(client != null) {
            for(int i=0; i < this.nbClients;i++) {
                if(client.equals(clients[i])) return i;
            }
        } return -1;
    }

    /**
     * Méthode permettant d'ajouter un client dans le carnet. Dans le cas où le carnet est plein ou bien le client est déjà présent dans le carnet, rien est fait. Dans le cas contraire le client est inséré dans le carnet.
     * @param client Un client (supposé non null).
     */
    public void ajouterClient(Client client) {
        if((chercherIndiceClient(client) == -1) && (!estPlein())) {
            this.clients[this.nbClients++] = client;
            this.nbClients++;
        }else System.out.println("ERREUR : Carnet plein");
    }

    /**
     * Méthode permettant de chercher un client dans le carnet avec son numéro de référence.
     * @param refClient La référence du client recherché.
     * @return Le client dans le carnet ayant refClient comme référence ou null si un tel client n'existe pas.
     */
    public Client rechercherClientParReference(int refClient) {
        if (!estVide()) {
            for (int i = 0; i < this.getNbClients(); i++) {
            	if(clients[i] != null) {
	               if (clients[i].getReference() == refClient) return clients[i];
            	}
            }
        }
        return null;
    }

    /**
     * Méthode permettant de supprimer un client du carnet. Rien est fait dans le cas où le client n'est pas présent dans le carnet.
     * @param client Un client (supposé non null).
     */
    public void supprimerClient(Client client) {
        if(chercherIndiceClient(client) != -1) {
            for(int i = 0; i < this.getNbClients();i++){
                if(client.equals(clients[i])){
                    clients[i] = clients[this.nbClients-1];
                    clients[this.nbClients-1]=null;
                    this.nbClients--;
                    break;
                }
            }
        }
    }

    /**
     * Méthode retournant un nouveau tableau contenant les clients de type entreprise du carnet.
     * @return Un nouveau tableau non null contenant les clients de type entreprise du carnet.
     */
    public Client[] clientsEntrepriseDansCarnet() {
        Client[] temp = new Client[MAX_CLIENTS];
        int ent = 0;
        for(int i=0; i < this.nbClients;i++) {
            if(clients[i] instanceof ClientEntreprise) {
                    temp[ent] = clients[i];
                    ent++;
            }
        }
        return temp;
    }

    /**
     * Méthode retournant un nouveau tableau contenant les clients de type particulier du carnet.
     * @return Un nouveau tableau non null contenant les clients de type particulier du carnet.
     */
    public Client[] clientsParticulierDansCarnet() {
        Client[] temp = new Client[MAX_CLIENTS];
        int part = 0;
        for(int i=0; i < this.nbClients;i++) {
            if(clients[i] instanceof ClientParticulier) {
                    temp[part] = clients[i];
                    part++;
            }
        }
        return temp;
    }

    /**
     * Méthode retournant un nouveau tableau contenant les clients du carnet. Le tableau retourné a pour taille getNbClients().
     * @return Un nouveau tableau non null contenant les clients du carnet.
     */
    public Client[] clientsDansCarnet(){
        Client[] temp = new Client[this.getNbClients()];
        if(getNbClients() >0) {
            for (int i = 0; i < this.nbClients; i++) temp[i] = clients[i];
            return temp;
        }
        return null;
    }

    public Client[] rechercherClientsParMotCle(String motCle){
        Client[] temp = new Client[this.getNbClients()];
        if(!estVide()){
            int find =0;
            for(int i=0; i< this.getNbClients();i++){
                if (clients[i] != null && (clients[i].getNom().contains(motCle) || (clients[i].getAdresse().contains(motCle)))){
                    temp[find] = clients[i];
                    find++;
                }
            }
        }
        return temp;
    }
}
