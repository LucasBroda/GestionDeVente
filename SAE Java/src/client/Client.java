package client;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import util.Util;
/**
 * Un objet de la classe Client correspond à un client. Chaque client a une référence (un entier) permettant de l'identifier, un nom (une chaîne de caractères), une adresse (une chaîne de caractères) et un nombre de points de fidélité (un entier).
 * @author Hugo Potier
 * @version 04/04/2022
 */

public abstract class Client {
    /**
     * Le nombre de clients créés (à initialiser avec 0).
     */
    private static int nbClients;
    /**
     * La référence du client.
     */
    private int reference;
    /**
     *  Le nombre de points de fidélité.
     */
    private int pointsFidelite;
    /**
     * Le nom du client.
     */
    private String nom;
    /**
     *  Le nom du client.
     */
    private String adresse;

    /**
     * Constructeur permettant d'initialiser un nouveau client avec son nom, son adresse et ses points de fidélité.
     * @param nom Le nom de la personne
     * @param adresse L'adresse de la personne
     * @param pointsFidelite Les points de fidélité initiaux du client.
     */
    protected Client(String nom, String adresse, int pointsFidelite) {
        reference = nbClients;
        nbClients++;
        this.nom = nom;
        this.adresse = adresse;
        this.pointsFidelite = pointsFidelite;
    }

    /**
     * Constructeur permettant d'initialiser un nouveau client en effectuant la saisie au clavier de son nom, son adresse et ses points de fidélité (en utilisant la méthode saisirInfos()).
     */
    protected Client(){
        reference = nbClients;
        nbClients++;
        saisirInfos();
    }

    /**
     * Méthode retournant le nombre de points de fidélité du client.
     * @return Le nombre de points de fidélité.
     */
    public int getPointsFidelite() {
        return pointsFidelite;
    }

    /**
     * Méthode permettant de modifier le nombre de points de fidélité du client.
     * @param pointsFidelite Le nouveau nombre de points de fidélité (supposé supérieur ou égal à 0).
     */
    public void setPointsFidelite(int pointsFidelite) {
        this.pointsFidelite = pointsFidelite;
    }

    /**
     * Méthode retournant le nom du client.
     * @return Le nom du client.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode permettant de modifier le nom du client.
     * @param nom Le nouveau du client (doit être non null).
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode retournant l'adresse du client.
     * @return L'adresse du client.
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Méthode permettant de modifier l'adresse du client.
     * @param adresse La nouvelle adresse du client (doit être non null).
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Méthode retournant le numéro de référence du client.
     * @return Le numéro de référence.
     */
    public int getReference() {
        return reference;
    }

    /**
     * Les points de fidélité donnent droit à une ristourne sur le montant total d'une commande. Cette ristourne est calculé de la manière suivante : Un client ayant entre 100 et 499 points de fidelité a droit à une ristourne de 5% sur le montant total. Un client ayant entre 500 et 999 points de fidelité a droit à une ristourne de 10% sur le montant total. Un client ayant 1000 points ou plus de fidelité a droit à une ristourne de 15% sur le montant total.
     * @return L'entier correspondant à la ristourne à laquelle a droit le client.
     */
    public int getRistourne() {
        if (this.getPointsFidelite() >= 100 && this.getPointsFidelite() < 500) return 5;
        else if(this.getPointsFidelite() >=500 && this.getPointsFidelite() < 1000) return 10;
        else if(this.getPointsFidelite() > 1000) return 15;
        else return 0;
    }
    /**
     *  Méthode permettant de saisir le nom et l'adresse du client.
     */
    public void saisirInfos() {
        nom = Util.saisirChaine("Nom : ");
        adresse = Util.saisirChaine("Adresse : ");
        pointsFidelite = Util.saisirEntierPositif("Points Fidélité : ");
    }

    /**
     * Méthode permettant de tester si deux clients sont les mêmes : deux clients sont les mêmes si et seulement ils ont la même référence.
     * @param client Un objet supposé être instance de la classe Client et non null.
     * @return true ou false
     */
    public boolean equals(Object client) {
        if (client == null) return false;
        if(!(client instanceof Client)) return false;
        Client cli = (Client)client;
        return this.getReference()==cli.getReference();
    }

    /**
     * Méthode (redéfinition de toString()) retournant une représentation textuelle d'un client.
     */
    public String toString() {;
        String res="--------------------------------------------------------------- \nReference : "+ this.getReference();
        res+="\nNom : " +this.getNom();
        res+="\nAdresse : "+this.getAdresse();
        res+="\nPoints Fidélité : "+this.getPointsFidelite();
        res+="\nRistourne : "+this.getRistourne();
        return res;
    }

    /**
     * Méthode permettant d'afficher les clients d'un tableau de clients.
     * @param clients Le tableau contenant les clients à afficher, chaque case du tableau contient une référence non null d'un Client
     */
    public static void afficherTabClients(Client[] clients) {
        for(int i =0; i < clients.length;i++) {
            if (clients[i] != null)
                System.out.println(clients[i].toString());
        }
    }

    /**
     * Méthode permettant de trier un tableau de clients selon l'ordre alphabétique des noms des clients.
     * @param clients Le tableau de clients à trier.
     */
    public static void trierTabClients(Client[] clients) {
        Client temp;
        for(int i=0;i<clients.length;i++) {
            if(clients[i] != null) {
                for(int j = i+1;j<clients.length;j++) {
                    if (clients[j] != null) {
                        if (clients[i].getNom().compareTo(clients[j].getNom())>0) {
                            temp = clients[i];
                            clients[i]=clients[j];
                            clients[j]=temp;
                        }
                    }
                }
            }
        }
    }
}
