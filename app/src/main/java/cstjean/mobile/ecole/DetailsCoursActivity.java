package cstjean.mobile.ecole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.SingletonEcole;
import cstjean.mobile.ecole.travail.rapport.RapportTravaux;

public class DetailsCoursActivity extends AppCompatActivity implements DetailsCoursFragment.Callbacks {
    /**
     * La clé pour communiquer l'index courant à afficher.
     */
    private static final String EXTRA_INDEXCOURANT = "indexcourant";

    /**
     * L'index du cours à afficher dans la liste de cours.
     */
    private int indexCourant = 0;

    /**
     * Création d'un Intent pour démarrer l'Activity courant.
     *
     * @param packageContext Le contexte lié à l'Activity
     * @param indexCourant   L'index lié au cours à afficher
     *                       dans notre liste de cours
     * @return L'Intent pour l'ouverture de l'Activity
     */
    public static Intent newIntent(Context packageContext, int indexCourant) {
        Intent intent = new Intent(packageContext, DetailsCoursActivity.class);
        intent.putExtra(EXTRA_INDEXCOURANT, indexCourant);
        return intent;
    }

    /**
     * Quand l'Activity est initialisé.
     *
     * @param savedInstanceState Les données conservées au changement d'état.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_cours);
        indexCourant = getIntent().getIntExtra(EXTRA_INDEXCOURANT, 0);
    }

    @Override
    public int getIndexCourant() {
        return indexCourant;
    }
}