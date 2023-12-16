package cstjean.mobile.ecole;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import cstjean.mobile.ecole.travail.Travail;

/**
 * Adapter pour notre RecyclerView de travaux.
 *
 * @author Sébastien Huot
 */
public class TravailListAdapter extends RecyclerView.Adapter<TravailViewHolder> {
    /**
     * La liste des travaux à afficher.
     */
    private final List<Travail> travaux;

    /**
     * Constructeur.
     *
     * @param travaux La liste des travaux à afficher.
     */
    public TravailListAdapter(List<Travail> travaux) {
        this.travaux = travaux;
    }

    /**
     * Lors de la création des ViewHolder.
     *
     * @param parent   Layout dans lequel la nouvelle vue sera
     *                 ajoutée quand elle sera liée à une position.
     * @param viewType Le type de vue de la nouvelle vue.
     * @return Un ViewHolder pour notre cellule.
     */
    @NonNull
    @Override
    public TravailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_liste_travaux, parent, false);

        return new TravailViewHolder(view);
    }

    /**
     * Associe un élément à un ViewHolder.
     *
     * @param holder   Le ViewHolder à utiliser.
     * @param position La position dans la liste qu'on souhaite utiliser.
     */
    @Override
    public void onBindViewHolder(@NonNull TravailViewHolder holder, int position) {
        holder.bindTravail(travaux.get(position));
    }

    /**
     * Récupère le nombre total d'item de notre liste.
     *
     * @return Le nombre d'item total de notre liste.
     */
    @Override
    public int getItemCount() {
        return travaux.size();
    }
}

/**
 * ViewHolder pour notre RecyclerView de travaux.
 * Checkstyle : OK ici puisque les deux classes sont très liées.
 *
 * @author Sébastien Huot
 */
class TravailViewHolder extends RecyclerView.ViewHolder {
    /**
     * CheckBox pour si le travail est complété.
     */
    private final CheckBox chkComplete;

    /**
     * TextView pour le nom du travail.
     */
    private final TextView nomTravail;

    /**
     * TextView pour la date de remise du travail.
     */
    private final TextView dateRemise;

    /**
     * Le travail lié à ce ViewHolder.
     */
    private Travail travail;

    /**
     * Constructeur.
     *
     * @param itemView Le layout associé au ViewHolder.
     */
    public TravailViewHolder(@NonNull View itemView) {
        super(itemView);

        chkComplete = itemView.findViewById(R.id.checkbox_termine);
        nomTravail = itemView.findViewById(R.id.txt_nom);
        dateRemise = itemView.findViewById(R.id.txt_date);

        chkComplete.setOnClickListener(view -> {
            this.travail.setEstTermine(chkComplete.isChecked());
        });
    }

    /**
     * On associe un travail à ce ViewHolder.
     *
     * @param travail Le travail associé.
     */
    void bindTravail(Travail travail) {
        this.travail = travail;

        nomTravail.setText(travail.getNom());
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        dateRemise.setText(formatDate.format(travail.getDateRemise().getTime()));
        chkComplete.setChecked(travail.estTermine());
    }
}
