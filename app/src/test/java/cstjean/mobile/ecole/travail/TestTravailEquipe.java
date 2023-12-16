package cstjean.mobile.ecole.travail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTravailEquipe extends TestTravail {

    /**
     * Tests d'ajout de coéquipiers.
     */
    @Test
    public void testAjoutCoequipiers() {
        TravailEquipe travail = (TravailEquipe) creerTravail("TP1",
                new GregorianCalendar(2023, Calendar.SEPTEMBER, 20));

        int da1 = 123456;
        String nomCoequipier1 = "Coéquipier 1";
        travail.ajouterCoequipier(da1, nomCoequipier1);
        assertEquals(nomCoequipier1, travail.getCoequipier(da1));

        int da2 = 789011;
        String nomCoequipier2 = "Coéquipier 2";
        travail.ajouterCoequipier(da2, nomCoequipier2);
        assertEquals(nomCoequipier2, travail.getCoequipier(da2));

        assertEquals(nomCoequipier1, travail.getCoequipier(da1));
    }

    /**
     * Créé un travail du bon type.
     *
     * @param nom        Le nom du travail.
     * @param dateRemise La date de remise du travail.
     * @return Le travail créé selon les paramètres.
     */
    @Override
    protected Travail creerTravail(String nom, Calendar dateRemise) {
        TravailEquipe travail = new TravailEquipe(nom, dateRemise);
        travail.ajouterCoequipier(12345, "Seb");
        return travail;
    }
}