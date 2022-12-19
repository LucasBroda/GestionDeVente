package client;

import util.Util;

/**
 *
 Un objet de la classe ClientParticulier représente un client correspondant à un particulier. Un client qui est un particulier a un nom de contact comme caractéristique supplémentaire.
 * @author hugo.potier
 *@version 04/04/2022
 */
public class ClientParticulier extends Client{

    /**
     * Le genre du client de type particulier.
     */
    private Genre genre;

    /**
     * Le prénom du client de type particulier.
     */
    private String prenom;

    /**
     * Constructeur permettant d'initialiser un nouveau client de type particulier en effectuant la saisie au clavier de son nom, son adresse, son prénom et son genre (en utilisant la méthode saisirInfos()).
     */
    public ClientParticulier() {
        super();
    }

    /**
     * Constructeur permettant d'initialiser un nouveau client de type particulier avec son nom, son adresse, son prénom et son genre.
     * @param nom Le nom du client de type particulier.
     * @param adresse L'adresse du client de type particulier.
     * @param pointsFidelite Les points de fidélité initiaux du client.
     * @param prenom Le prénom du client de type particulier.
     * @param genre Le genre du client de type particulier.
     */
    public ClientParticulier(String nom, String adresse, int pointsFidelite, String prenom, Genre genre) {
        super(nom, adresse, pointsFidelite);
        this.prenom = prenom;
        this.genre = genre;
    }

    /**
     * Méthode retournant le genre du client de type particulier.
     * @return Le genre du client de type particulier.
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Méthode permettant de modifier le genre du client de type particulier.
     * @param genre Le nouveau genre (qui doit être non null).
     */
    public void setGenre(Genre genre) {
        if(genre != null) this.genre = genre;
    }

    /**
     * Méthode retournant le prénom du client de type particulier.
     * @return Le prénom du client de type particulier.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Méthode permettant de modifier le prénom du client de type particulier.
     * @param prenom Le nouveau prénom (qui doit être non null).
     */
    public void setPrenom(String prenom) {
        if(prenom != null) this.prenom = prenom;
    }

    /**
     * Méthode permettant de saisir le nom, l'adresse, le prénom et le genre d'un client de type particulier.
     */
    public void saisirInfos() {
        super.saisirInfos();
        prenom = Util.saisirChaine("Prénom : ");
        boolean resgenre = Util.questionBinaire("Genre (F/H)", "F", "H");
        if(resgenre) genre = Genre.Homme;
        else genre = Genre.Femme;
    }
    /**
     * Méthode (redéfinition de toString()) retournant une représentation textuelle du client de type particulier.
     */
    public String toString() {
        return super.toString() + "\nPrénom : "+this.getPrenom() + "\nGenre : "+this.getGenre();
    }
}
