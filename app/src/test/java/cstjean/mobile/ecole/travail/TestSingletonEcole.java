package cstjean.mobile.ecole.travail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class TestSingletonEcole {
    /**
     * Le Singleton à tester.
     */
    private SingletonEcole singleton;

    /**
     * Création des objets nécessaires dans différentes méthodes de tests.
     */
    @Before
    public void setUp() {
        singleton = SingletonEcole.getInstance();
        singleton.reset();
    }

    /**
     * Test la récupération d'une instance.
     */
    @Test
    public void testInstance() {
        SingletonEcole singleton2 = SingletonEcole.getInstance();
        assertSame(singleton, singleton2);
    }

    /**
     * Test de l'ajout de cours dans le Singleton.
     */
    @Test
    public void testAjoutTravail() {
        CoursSession cours1 = new CoursSession("Philo", "101");
        singleton.ajouterCoursSession(cours1);
        assertEquals(1, singleton.getNbCoursSession());
        assertEquals(1, singleton.getListeCoursSession().size());
        assertEquals(cours1, singleton.getCoursSession(0));

        CoursSession cours2 = new CoursSession("Philo", "201");
        singleton.ajouterCoursSession(cours2);
        assertEquals(2, singleton.getNbCoursSession());
        assertEquals(2, singleton.getListeCoursSession().size());
        assertEquals(cours1, singleton.getCoursSession(0));
        assertEquals(cours2, singleton.getCoursSession(1));
    }
}


