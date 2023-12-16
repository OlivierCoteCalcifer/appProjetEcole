package cstjean.mobile.ecole.travail;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Cette classe est pour chaque cours durant une session.
 * NOTES EXAMEN: On ajout l'interface Comparable pour ajouter nos options de tri
 * pour nos coursSessions. En ajoutant Comparable on doit creer la fonction compareTo.
 */
public class CoursSession implements Comparable<CoursSession> {
    static int compteur = 0;
    /**
     * Cette variable est le nom du département.
     */
    private final String departement;
    /**
     * Cette variable est le numero d'identification du cours.
     */
    private final String numero;
    /**
     * Cette liste sont les travaux à remettre durant le cours..
     */
    private final List<Travail> travaux = new ArrayList<>();

    private URL url;

    /**
     * Le constructeur creer l'objet qui rassemble les variables énumérées plus haut.
     *
     * @param departement Cette variable est pour le nom du departement.
     * @param numero      Cette variable est le numero de cours.
     */

    public CoursSession(String departement, String numero) {
        if (!NumeroCoursUtil.estNumeroCoursValide(numero)) {
            throw new IllegalArgumentException();
        }
        this.departement = departement;
        this.numero = numero;
        incrementerCompteur();
    }

    private static void incrementerCompteur() {
        compteur++;
    }

    static int getCompteur() {
        return compteur;
    }

    /**
     * Remet le compteur de cours à zéro.
     */
    static void resetCompteur() {
        compteur = 0;
    }

    public String getDepartement() {
        return departement;
    }

    public String getNumero() {
        return numero;
    }

    public int getNombreTravaux() {
        return travaux.size();
    }

    /**
     * Permet d'ajouter un travail dans la liste.
     *
     * @param travail Travail à ajouter.
     */
    public void ajouterTravail(Travail travail) {
        travaux.add(travail);
    }

    /**
     * Permet de récupérer un travail dans la liste.
     *
     * @param index Position du travail à récupérer.
     * @return Travail.
     */
    public Travail getTravail(int index) {
        return travaux.get(index);
    }

    public String getDepartementNumero() {
        return departement + " " + numero;
    }

    public URL getUrl() {
        return url;
    }

    /**
     * Assigne l'URL du cours.
     *
     * @param url L'URL du cours
     * @throws MalformedURLException Si l'URL est invalide
     */
    public void setUrl(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    public List<Travail> getListeTravaux() {
        return travaux;
    }

    @Override
    public int compareTo(CoursSession o) {
        int compareDepartement = getDepartement().compareTo(o.getDepartement());

        if (compareDepartement != 0) {
            return compareDepartement;
        }

        return getNumero().compareTo(o.getNumero());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CoursSession that = (CoursSession) o;
        return departement.equals(that.departement) && numero.equals(that.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departement, numero);
    }
}

