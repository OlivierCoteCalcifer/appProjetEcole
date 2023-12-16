package cstjean.mobile.ecole;

/**
 * Utilitaire pour les numéros de cours.
 *
 * @author Sébastien Huot
 */
public class NumeroCoursUtil {

    /**
     * Constructeur privé puisque c'est un utilitaire et qu'on veut éviter
     * les instances.
     */
    private NumeroCoursUtil() {
    }

    /**
     * Valide un numéro de cours.
     *
     * @param numeroCours Le numéro à valider
     *
     * @return vrai si le numéro est valide
     */
    public static boolean estNumeroCoursValide(String numeroCours) {
        String regex = "^\\d[0-9A-Z]\\d$";
        return numeroCours.matches(regex);
    }
}
