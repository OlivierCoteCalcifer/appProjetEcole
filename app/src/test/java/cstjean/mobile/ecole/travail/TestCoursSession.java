package cstjean.mobile.ecole.travail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Permet de tester l'objet CoursSession.
 *
 * @author Sébastien Huot
 */
public class TestCoursSession {
    /**
     * Cours session.
     */
    private CoursSession coursSession;

    /**
     * Date de remise.
     */
    private Calendar dateRemise;

    /**
     * Préparation des objets à utiliser.
     */
    @Before
    public void setUp() {
        coursSession = new CoursSession("Philo", "101");
        dateRemise = new GregorianCalendar(2023, Calendar.SEPTEMBER, 10);
    }

    /**
     * Test de la création d'un CoursSession.
     */
    @Test
    public void testCreer() {
        assertEquals("Philo", coursSession.getDepartement());
        assertEquals("101", coursSession.getNumero());
        assertEquals("Philo 101", coursSession.getDepartementNumero());
        assertEquals(0, coursSession.getNombreTravaux());
    }

    /**
     * Test de l'ajout de travaux à un CoursSession.
     */
    @Test
    public void testAjoutTravail() {
        Travail travail1 = new Travail("TP1", dateRemise);
        coursSession.ajouterTravail(travail1);
        assertEquals(1, coursSession.getNombreTravaux());
        assertEquals(1, coursSession.getListeTravaux().size());
        assertEquals(travail1, coursSession.getTravail(0));

        Travail travail2 = new Travail("TP2", dateRemise);
        coursSession.ajouterTravail(travail2);
        assertEquals(2, coursSession.getNombreTravaux());
        assertEquals(2, coursSession.getListeTravaux().size());
        assertEquals(travail1, coursSession.getTravail(0));
        assertEquals(travail2, coursSession.getTravail(1));
    }

    @Test
    public void testCompteur() {
        CoursSession.resetCompteur();
        assertEquals(0, CoursSession.getCompteur());

        new CoursSession("Philo", "101");
        assertEquals(1, CoursSession.getCompteur());

        new CoursSession("Philo", "101");
        assertEquals(2, CoursSession.getCompteur());

        new CoursSession("Philo", "101");
        assertEquals(3, CoursSession.getCompteur());

        CoursSession.resetCompteur();
        assertEquals(0, CoursSession.getCompteur());
    }

    @Test
    public void testUrl() throws MalformedURLException {
        final String url = "https://www.cstjean.qc.ca/philo101";
        coursSession.setUrl(url);
        assertEquals(url, coursSession.getUrl().toString());
    }

    /**
     * Test URL invalide - façon jUnit 3.
     */
    @Test
    public void testUrlInvalidejUnit3() {
        final String url = "://www.cstjean.qc.ca/philo101";

        try {
            coursSession.setUrl(url);
            fail("Devrait avoir une exception");
        } catch (MalformedURLException ex) {
            // Succès!
        }
    }

    /**
     * Test URL invalide - façon jUnit 4.
     */
    @Test(expected = MalformedURLException.class)
    public void testUrlInvalidejUnit4() throws MalformedURLException {
        final String url = "://www.cstjean.qc.ca/philo101";

        coursSession.setUrl(url);
    }

    /**
     * Test numéro de cours invalide.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNumeroCoursInvalide() {
        new CoursSession("Philo", "AAA");
    }

    /**
     * Tests pour la comparaison de 2 CoursSession.
     */
    @Test
    public void testCompare() {
        assertEquals(0, coursSession.compareTo(new CoursSession("Philo", "101")));
        assertTrue(coursSession.compareTo(new CoursSession("Philo", "201")) < 0);
        assertTrue(coursSession.compareTo(new CoursSession("Math", "101")) > 0);
    }

    /**
     * Test d'égalité.
     */
    @Test
    public void testEgalite() {
        CoursSession coursA = new CoursSession("Philo", "101");
        CoursSession coursB = new CoursSession("Philo", "101");
        assertEquals(coursA, coursB);

        CoursSession coursC = new CoursSession("Philo", "201");
        assertNotEquals(coursA, coursC);

        // Réflexivité
        assertEquals(coursA, coursA);

        // Symétrie
        assertEquals(coursB, coursA);

        // Transitivité
        CoursSession coursD = new CoursSession("Philo", "101");
        assertEquals(coursB, coursD);
        assertEquals(coursA, coursD);

        // Constance
        assertEquals(coursA, coursB);

        // Comparaison à null
        // LINT : jUnit n'appelle pas le equal si on envoit null donc on veut comparer directement
        //          On veut vraiment tester le null ici...
        assertFalse(coursA.equals(null));

        // Validation
        assertNotEquals("MATHS334", coursA);
    }

    /**
     * Test de HashCode.
     */
    @Test
    public void testHashCode() {
        CoursSession coursA = new CoursSession("Philo", "101");
        CoursSession coursB = new CoursSession("Philo", "101");
        assertEquals(coursA.hashCode(), coursB.hashCode());
        assertEquals(coursA.hashCode(), coursA.hashCode());
    }
}
