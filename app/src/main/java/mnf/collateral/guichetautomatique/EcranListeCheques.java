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

        guichetAutomatique = Guichet.getInstance();

        ArrayAdapter adapterCompte = new AdapteurCompte(this, R.layout.layout_liste_inflater, Guichet.getComptesCheques());

        ListView lvClients = (ListView)findViewById(R.id.lvCheques);

        lvClients.setAdapter(adapterCompte);
    }

    public void onClickFenetreListeCheques(View view) {
        finish();
    }
}