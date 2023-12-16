package cstjean.mobile.ecole.travail.rapport;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.Travail;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class RapportTravaux extends Rapport {
    /** L'entête de notre rapport. */
    static final String ENTETE_RAPPORT_TRAVAUX = "---------- TRAVAUX ----------" + SAUT_LIGNE;

    /** Le pied de page de notre rapport. */
    static final String PIEDPAGE_RAPPORT_TRAVAUX = SAUT_LIGNE + "--------------------";

    /**
     * Constructeur privé puisque c'est un utilitaire et qu'on veut éviter
     * les instances.
     */
    private RapportTravaux() {
    }

    /**
     * Crée un rapport d'une liste de travaux.
     *
     * @param coursSession Le cours à utiliser pour le rapport.
     *
     * @return Le rapport de cours formaté.
     */
    public static String getRapportTravaux(CoursSession coursSession) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        StringBuilder builder = new StringBuilder();

        builder.append(ENTETE_RAPPORT_TRAVAUX);

        for (int i = 0; i < coursSession.getNombreTravaux(); i++) {
            Travail travail = coursSession.getTravail(i);

            builder.append(travail.getNom())
                    .append(" - ")
                    .append(formatDate.format(travail.getDateRemise().getTime()))
                    .append(SAUT_LIGNE);
        }
        builder.append("Total : ")
                .append(coursSession.getNombreTravaux())
                .append(PIEDPAGE_RAPPORT_TRAVAUX);

        return builder.toString();
    }

}