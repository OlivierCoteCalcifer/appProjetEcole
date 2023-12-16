package cstjean.mobile.ecole.travail.rapport;

import cstjean.mobile.ecole.travail.CoursSession;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static cstjean.mobile.ecole.travail.rapport.Rapport.SAUT_LIGNE;

public class RapportCours extends Rapport {
    /** La liste des cours à formater. */
    private final List<CoursSession> listeCoursSession = new ArrayList<>();

    /**
     * Ajoute un cours à la liste de cours à formater.
     *
     * @param coursSession Le cours à ajouter
     */
    public void ajouter(CoursSession coursSession) {
        this.listeCoursSession.add(coursSession);
    }

    /**
     * Crée un rapport d'une liste de cours.
     *
     * @return Le rapport de cours formaté.
     */
    String getRapportCours() {
        StringBuilder builder = new StringBuilder();

        Collections.sort(listeCoursSession);

        for (CoursSession cours : listeCoursSession) {
            builder.append(cours.getDepartement())
                    .append(" ")
                    .append(cours.getNumero())
                    .append(SAUT_LIGNE);
        }

        return builder.toString();
    }
}
