/*
    Projet guichet automatique
    Nicolae-Florin Munteanu
    Christian Toumie
*/
package mnf.collateral.guichetautomatique;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EcranListeCheques extends AppCompatActivity {
    Guichet guichetAutomatique;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenetre_liste_cheques);

        // on va chercher le singleton pour avoir nos listes
        guichetAutomatique = Guichet.getInstance();

        // on declare le array adapter qui se charge de remplir notre liste et on lui fournit le array necessaire et on lui indique le xml inflater qu'il faut prendre
        ArrayAdapter adapterCompte = new AdapteurCompte(this, R.layout.layout_liste_inflater, Guichet.getComptesCheques());

        // on declare une variable pour identifier la liste de notre ecran
        // pour ensuite lui communiquer son adapteur, qui va populer les items avec l'inflater et la liste
        ListView lvClients = (ListView)findViewById(R.id.lvCheques);
        lvClients.setAdapter(adapterCompte);
    }

    public void onClickFenetreListeCheques(View view) {
        finish();
    }
}