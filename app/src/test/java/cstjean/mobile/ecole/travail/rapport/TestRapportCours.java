package cstjean.mobile.ecole.travail.rapport;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cstjean.mobile.ecole.travail.CoursSession;

/**
 * Tests pour RapportCours.
 *
 * @see RapportCours
 *
 * @author Sébastien Huot
 */
public class TestRapportCours {
    /**
     * Test du rapport des cours.
     */
    @Test
    public void testRapport() {
        RapportCours rapport = new RapportCours();
        rapport.ajouter(new CoursSession("FRANÇAIS", "101"));
        rapport.ajouter(new CoursSession("MATHS", "301"));
        rapport.ajouter(new CoursSession("PHILO", "301"));
        rapport.ajouter(new CoursSession("MATHS", "201"));
        rapport.ajouter(new CoursSession("PHILO", "201"));

        assertEquals("FRANÇAIS 101" + RapportCours.SAUT_LIGNE +
                "MATHS 201" + RapportCours.SAUT_LIGNE +
                "MATHS 301" + RapportCours.SAUT_LIGNE +
                "PHILO 201" + RapportCours.SAUT_LIGNE +
                "PHILO 301" + RapportCours.SAUT_LIGNE, rapport.getRapportCours());
    }
}
