package cstjean.mobile.ecole;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.SingletonEcole;

public class ListeCoursFragment extends Fragment {
    /**
     * Le RecyclerView des cours.
     */
    private RecyclerView recyclerViewCours;

    /**
     * Initialisation du fragment.
     *
     * @param savedInstanceState Les données conservées au changement d'état
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Instanciation de l'interface.
     *
     * @param inflater           Pour instancier l'interface
     * @param container          Le parent qui contiendra notre interface
     * @param savedInstanceState Les données conservées au changement d'état
     * @return La vue instanciée
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_liste_cours, container, false);
        recyclerViewCours = view.findViewById(R.id.recycler_view_cours);
        recyclerViewCours.setLayoutManager(new LinearLayoutManager(getActivity()));
        ImageButton btnAjout = view.findViewById(R.id.btn_ajouter);

        btnAjout.setOnClickListener(v -> {
            Intent intent = AjoutCoursActivity.newIntent(getActivity());
            startActivity(intent);
        });

        return view;
    }

    /**
     * Lorsque le Fragment est remis en avant plan.
     * Pour s'assurer que la liste est à jour.
     * Idéalement, on devrait cibler que les changements ...
     */
    @Override
    public void onResume() {
        super.onResume();
        SingletonEcole singletonEcole = SingletonEcole.getInstance();
        List<CoursSession> listeCoursSession = singletonEcole.getListeCoursSession();

        CoursSessionListAdapter adapterCoursSession = new CoursSessionListAdapter(listeCoursSession);
        recyclerViewCours.setAdapter(adapterCoursSession);
    }
}