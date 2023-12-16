package cstjean.mobile.ecole;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.SingletonEcole;

/**
 * Fragment pour le détail d'un cours.
 *
 * @author Sébastien Huot
 */
public class DetailsCoursFragment extends Fragment {
    /**
     * L'Activity qui contient notre Fragment.
     *
     * @see Callbacks
     */
    private Callbacks callbacks = null;

    /**
     * Initialisation du fragment.
     *
     * @param savedInstanceState If the fragment is being re-created from
     *                           a previous saved state, this is the state.
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
        View view = inflater.inflate(R.layout.fragment_details_cours, container, false);

        RecyclerView recyclerViewTravaux = view.findViewById(R.id.recycler_view_travaux);
        recyclerViewTravaux.setLayoutManager(new LinearLayoutManager(getActivity()));

        int indexCourant = callbacks.getIndexCourant();

        CoursSession coursSession = SingletonEcole.getInstance().getCoursSession(indexCourant);

        TravailListAdapter adapterTravaux = new TravailListAdapter(coursSession.getListeTravaux());
        recyclerViewTravaux.setAdapter(adapterTravaux);

        TextView txtDepartement = view.findViewById(R.id.txt_departement);
        txtDepartement.setText(coursSession.getDepartement());
        TextView txtNumero = view.findViewById(R.id.txt_numero);
        txtNumero.setText(coursSession.getNumero());

        return view;
    }

    /**
     * Lorsque le Fragment est associé à l'Activity.
     *
     * @param context Le contexte lié à l'Activity.
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callbacks = (Callbacks) context;
    }

    /**
     * Lorsque le Fragment n'est plus associé à l'Activity.
     */
    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }

    /**
     * Permettra d'exiger que l'Activity contenant le Fragment définisse la méthode
     * de récupération de l'index courant qui correspond au cours à afficher.
     */
    interface Callbacks {
        /**
         * Récupère l'index courant.
         *
         * @return L'index courant.
         */
        int getIndexCourant();
    }
}