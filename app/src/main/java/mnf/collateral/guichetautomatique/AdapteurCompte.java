/*
    Projet guichet automatique
    Nicolae-Florin Munteanu
    Christian Toumie
*/
package mnf.collateral.guichetautomatique;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

// adapteur pour pouvoir mettre les infos de la liste,
// dans un view qu'on poura mettre dans une liste en changant les infos pour chaque item
public class AdapteurCompte extends ArrayAdapter<ClasseCompte> {
    private ArrayList<ClasseCompte> alComptes;
    private Context context;
    private int viewRes;
    private Resources res;

    public AdapteurCompte(Context context, int textViewResourceId, ArrayList<ClasseCompte> comptes){
        super(context, textViewResourceId, comptes);

        this.alComptes = comptes;
        this.context = context;
        this.viewRes = textViewResourceId;
        this.res = context.getResources();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = convertView;
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes, parent, false);
        }

        final ClasseCompte compte = alComptes.get(position);
        if (compte != null){
            final TextView tvCompte = (TextView)view.findViewById(R.id.tvItem1);
            final TextView tvSolde = (TextView)view.findViewById(R.id.tvItem2);

            String strCompte = res.getString(R.string.strCompte) + " " + compte.getNumeroCompte();
            String strSolde = res.getString(R.string.strSolde) + " " + compte.getSolde();

            tvCompte.setText(strCompte);
            tvSolde.setText(strSolde);
        }

        return view;
    }

    @Override
    public int getCount(){
        return alComptes.size();
    }
}
