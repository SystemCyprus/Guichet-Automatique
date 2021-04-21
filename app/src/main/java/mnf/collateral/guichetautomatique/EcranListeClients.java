package mnf.collateral.guichetautomatique;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class EcranListeClients extends AppCompatActivity {

    Guichet guichetAutomatique;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenetre_liste_clients);

        guichetAutomatique = Guichet.getInstance();

        AdapteurClients adapterClients = new AdapteurClients(this, R.layout.layout_liste_inflater, Guichet.getListeClients());

        ListView lvListeClients = (ListView)findViewById(R.id.lvClients);

        lvListeClients.setAdapter(adapterClients);
    }

    public void onClickFenetreListeClients(View view) {
        finish();
    }
}