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
public class AdapteurClients extends ArrayAdapter<ClasseClient> {
    private ArrayList<ClasseClient> alClients;
    private Context context;
    private int viewRes;
    private Resources res;

    public AdapteurClients(Context context, int textViewResourceId, ArrayList<ClasseClient> clients){
        super(context, textViewResourceId, clients);

        this.alClients = clients;
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

        final ClasseClient client = alClients.get(position);
        if (client != null) {
            final TextView tvNom = (TextView) view.findViewById(R.id.tvItem1);
            final TextView tvPrenom = (TextView)view.findViewById(R.id.tvItem2);

            String strNom = res.getString(R.string.strNom) + " " + client.getNom();
            tvNom.setText(strNom);

            String strPrenom = res.getString(R.string.strPrenom) + " " + client.getPrenom();
            tvPrenom.setText(strPrenom);
        }
        return view;
    }

    @Override
    public int getCount(){
        return alClients.size();
    }
}
