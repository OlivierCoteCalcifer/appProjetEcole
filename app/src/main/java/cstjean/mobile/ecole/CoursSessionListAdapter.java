package cstjean.mobile.ecole;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cstjean.mobile.ecole.travail.CoursSession;

/**
 * Adapter pour notre RecyclerView de cours.
 *
 * @author Sébastien Huot
 */
public class CoursSessionListAdapter extends RecyclerView.Adapter<CoursSessionViewHolder> {
    /**
     * La liste des cours à afficher.
     */
    private final List<CoursSession> listeCoursSession;

    /**
     * Constructeur.
     *
     * @param listeCoursSession La liste des cours à afficher.
     */
    public CoursSessionListAdapter(List<CoursSession> listeCoursSession) {
        this.listeCoursSession = listeCoursSession;
    }

    /**
     * Lors de la création des ViewHolder.
     *
     * @param parent   Layout dans lequel la nouvelle vue
     *                 sera ajoutée quand elle sera liée à une position.
     * @param viewType Le type de vue de la nouvelle vue.
     * @return Un ViewHolder pour notre cellule.
     */
    @NonNull
    @Override
    public CoursSessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_liste_cours, parent, false);

        return new CoursSessionViewHolder(view);
    }

    /**
     * Associe un élément à un ViewHolder.
     *
     * @param holder   Le ViewHolder à utiliser.
     * @param position La position dans la liste qu'on souhaite utiliser.
     */
    @Override
    public void onBindViewHolder(@NonNull CoursSessionViewHolder holder, int position) {
        holder.bindCoursSession(listeCoursSession.get(position), position);
    }

    /**
     * Récupère le nombre total d'item de notre liste.
     *
     * @return Le nombre d'item total de notre liste.
     */
    @Override
    public int getItemCount() {
        return listeCoursSession.size();
    }
}

/**
 * ViewHolder pour notre RecyclerView de cours.
 * Checkstyle : OK ici puisque les deux classes sont très liées.
 *
 * @author Sébastien Huot
 */
class CoursSessionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    /**
     * TextView pour le nom du département.
     */
    private final TextView departement;

    /**
     * TextView pour le numéro du cours.
     */
    private final TextView numero;

    /**
     * L'index courant dans notre liste de cours.
     * Pour passer à l'Activity de détail lors du click.
     */
    private int indexCourant;

    /**
     * Constructeur.
     *
     * @param itemView Le layout associé au ViewHolder.
     */
    CoursSessionViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        departement = itemView.findViewById(R.id.item_txt_departement);
        numero = itemView.findViewById(R.id.item_txt_numero);
    }

    /**
     * On associe un cours à ce ViewHolder.
     *
     * @param coursSession Le cours associé.
     * @param position     La position dans notre liste.
     *                     Pour passer à l'Activity de détail lors du click
     */
    void bindCoursSession(CoursSession coursSession, int position) {
        departement.setText(coursSession.getDepartement());
        numero.setText(coursSession.getNumero());
        indexCourant = position;
    }

    /**
     * Lors d'un click sur notre cellule.
     *
     * @param view La vue cliquée.
     */
    @Override
    public void onClick(View view) {
        Intent intent = DetailsCoursActivity.newIntent(view.getContext(), indexCourant);
        view.getContext().startActivity(intent);
    }
}

