package mnf.collateral.guichetautomatique;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EcranListeEpargne extends AppCompatActivity {
    Guichet guichetAutomatique;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenetre_liste_epargne);

        guichetAutomatique = Guichet.getInstance();

        ArrayAdapter adapterCompte = new AdapteurCompte(this, R.layout.layout_liste_inflater, Guichet.getComptesEpargne());

        final ListView lvEpargne = (ListView)findViewById(R.id.lvEpargne);

        lvEpargne.setAdapter(adapterCompte);
    }

    public void onClickFenetreListeEpargnes(View view) {
        finish();
    }
}