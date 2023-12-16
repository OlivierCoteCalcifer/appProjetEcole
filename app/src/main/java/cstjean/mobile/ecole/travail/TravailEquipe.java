package cstjean.mobile.ecole.travail;

import androidx.annotation.NonNull;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class TravailEquipe extends Travail {
    /**
     * La liste des coéquipiers pour le travail.
     */
    private Map<Integer, String> coequipiers = new LinkedHashMap<>();

    /**
     * Constructeur.
     *
     * @param nom        Le nom du travail
     * @param dateRemise La date de remise du travail
     */
    public TravailEquipe(String nom, Calendar dateRemise) {
        super(nom, dateRemise);
    }

    /**
     * Ajoute un coéquipier au travail.
     *
     * @param da            Le DA du coéquipier.
     * @param nomCoequipier Le nom du coéquipier.
     */
    void ajouterCoequipier(int da, String nomCoequipier) {
        coequipiers.put(da, nomCoequipier);
    }

    /**
     * Récupère le coéquipier selon le DA.
     *
     * @param da Le DA du coéquipier à récupérer.
     * @return Le coéquipier selon le DA.
     */
    String getCoequipier(int da) {
        return coequipiers.get(da);
    }

    /**
     * Égalité sémantique sur deux objets TravailEquipe.
     *
     * @param o L'objet à comparer avec l'objet courant
     * @return vrai s'il y a égalité
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof cstjean.mobile.ecole.travail.TravailEquipe)) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }

        cstjean.mobile.ecole.travail.TravailEquipe that = (cstjean.mobile.ecole.travail.TravailEquipe) o;
        return coequipiers.equals(that.coequipiers);
    }

    /**
     * Calcule le hashcode de notre objet.
     *
     * @return Le hashcode de notre objet courant.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coequipiers);
    }

    /**
     * Crée un clone de notre objet.
     *
     * @return Un clone de notre objet courant.
     * @throws CloneNotSupportedException Si le clonage n'est pas supporté.
     */
    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        cstjean.mobile.ecole.travail.TravailEquipe clone = (cstjean.mobile.ecole.travail.TravailEquipe) super.clone();
        HashMap<Integer, String> coequipiers = new LinkedHashMap<>();

        for (Map.Entry<Integer, String> entry : this.coequipiers.entrySet()) {
            coequipiers.put(entry.getKey(), entry.getValue());
            // Ou entry.getValue().clone() quand c'est un objet ...
        }

        clone.coequipiers = coequipiers;
        return clone;
    }
}
