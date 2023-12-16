package cstjean.mobile.ecole;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.SingletonEcole;

public class AjoutCoursActivity extends AppCompatActivity {
    /**
     * Création d'un Intent pour démarrer l'Activity courant.
     *
     * @param packageContext Le contexte lié à l'Activity.
     * @return L'Intent pour l'ouverture de l'Activity.
     */
    public static Intent newIntent(Context packageContext) {
        return new Intent(packageContext, AjoutCoursActivity.class);
    }

    /**
     * Quand l'Activity est initialisé.
     *
     * @param savedInstanceState Les données conservées au changement d'état.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_cours);
    }
}
