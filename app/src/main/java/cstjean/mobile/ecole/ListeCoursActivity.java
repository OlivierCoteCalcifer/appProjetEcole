package cstjean.mobile.ecole;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import cstjean.mobile.ecole.travail.SingletonEcole;

public class ListeCoursActivity extends AppCompatActivity {

    /**
     * Quand l'Activity est initialisé.
     *
     * @param savedInstanceState Les données conservées au changement d'état.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_cours);
        Log.d("ProjetEcole", "onCreate");
    }

    /**
     * Démo du onStart.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ProjetEcole", "onStart");
    }

    /**
     * Démo du onRestart.
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ProjetEcole", "onRestart");
    }

    /**
     * Démo du onStop.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ProjetEcole", "onStop");
    }

    /**
     * Démo du onDestroy.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ProjetEcole", "onDestroy");
    }

    /**
     * Démo du onPause.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ProjetEcole", "onPause");
    }

    /**
     * Démo du onResume.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ProjetEcole", "onResume");
    }
}
