package cstjean.mobile.ecole.travail;

import androidx.annotation.NonNull;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Travail implements Cloneable {
    /**
     * Le nom du travail.
     */
    private final String nom;

    /**
     * Date de remise.
     */
    private Calendar dateRemise;

    /** Si le travail est fait. */
    private boolean estTermine;

    /**
     * Constructeur.
     *
     * @param nom        Le nom du travail.
     * @param dateRemise Date de remise.
     */
    public Travail(String nom, Calendar dateRemise) {
        this.nom = nom;
        this.dateRemise = dateRemise;
    }

    /**
     * Récupère le nom du travail.
     *
     * @return Le nom du travail.
     */
    public String getNom() {
        return nom;
    }

    public Calendar getDateRemise() {
        return dateRemise;
    }

    /**
     * Vérifie si le travail est terminé.
     *
     * @return Si le travail est terminé.
     */
    public boolean estTermine() {
        return estTermine;
    }

    public void setEstTermine(boolean estTermine) {
        this.estTermine = estTermine;
    }

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Travail clone = (Travail) super.clone();
        clone.dateRemise = (Calendar) dateRemise.clone();
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Travail travail = (Travail) o;
        return nom.equals(travail.nom) && dateRemise.equals(travail.dateRemise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, dateRemise);
    }
}
