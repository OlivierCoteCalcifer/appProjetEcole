package cstjean.mobile.ecole;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.SingletonEcole;

public class AjoutCoursFragment extends Fragment {
    /**
     * Le champs input du nom du département.
     */
    private TextInputEditText inputDepartement;

    /**
     * Le champs input du numéro du cours.
     */
    private TextInputEditText inputNumero;

    /**
     * Création du fragment.
     *
     * @param savedInstanceState Les données conservées au changement d'état.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Instanciation de l'interface.
     *
     * @param inflater           Pour instancier l'interface.
     * @param container          Le parent qui contiendra notre interface.
     * @param savedInstanceState Les données conservées au changement d'état.
     * @return La vue instanciée.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ajout_cours, container, false);

        inputDepartement = view.findViewById(R.id.input_departement);
        inputNumero = view.findViewById(R.id.input_numero);

        Button btnAjout = view.findViewById(R.id.btn_ajouter);

        btnAjout.setOnClickListener(v -> {
            CoursSession cours = new CoursSession(inputDepartement.getText().toString(),
                    inputNumero.getText().toString());
            SingletonEcole.getInstance().ajouterCoursSession(cours);
            getActivity().finish();
        });

        return view;
    }
}

