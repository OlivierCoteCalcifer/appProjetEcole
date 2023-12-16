package cstjean.mobile.ecole.travail;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class SingletonEcole {
    /** L'instance de notre singleton. */
    private static SingletonEcole instance = null;

    /** La liste des cours de notre application. */
    private final List<CoursSession> listeCoursSession = new ArrayList<>();

    /**
     * Constructeur privé.
     */
    private SingletonEcole() {
        Calendar dateRemise = new GregorianCalendar(2023, Calendar.SEPTEMBER, 10);

        // Données de tests
        CoursSession cours = new CoursSession("Philo", "101");
        cours.ajouterTravail(new Travail("TP1", dateRemise));

        listeCoursSession.add(cours);
        listeCoursSession.add(new CoursSession("Philo", "210"));
        listeCoursSession.add(new CoursSession("Math", "101"));
        listeCoursSession.add(new CoursSession("Français", "101"));
    }

    /**
     * Récupère l'instance de notre Singleton.
     *
     * @return L'instance de notre Singleton.
     */
    public static SingletonEcole getInstance() {
        if (instance == null) {
            instance = new SingletonEcole();
        }
        return instance;
    }

    /**
     * Récupère le cours session à l'index spécifié.
     *
     * @param index Position du cours session dans la liste.
     * @return L'instance du cours session situé à la position reçue en paramètre.
     */
    public CoursSession getCoursSession(int index) {
        return listeCoursSession.get(index);
    }

    public int getNbCoursSession() {
        return listeCoursSession.size();
    }

    /**
     * Ajoute un cours dans la liste de notre application.
     *
     * @param cours Le cours à ajouter.
     */
    public void ajouterCoursSession(CoursSession cours) {
        listeCoursSession.add(cours);
    }

    public List<CoursSession> getListeCoursSession() {
        return listeCoursSession;
    }

    /**
     * Pour réinitiliser notre Singleton.
     */
    public void reset() {
        listeCoursSession.clear();
    }
}