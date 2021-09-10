/*
    Projet guichet automatique
    Nicolae-Florin Munteanu
    Christian Toumie
*/
package mnf.collateral.guichetautomatique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class EcranAdmin extends AppCompatActivity {

    Guichet guichetAutomatique;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenetre_admin);
        // on va chercher notre singleton pour pouvoir effectuer le paiement des interets
        guichetAutomatique = Guichet.getInstance();
    }

    // bouton pour faire le payement, appelle la methode de notre singleton
    public void onClickBtnInterets(View view) {
        guichetAutomatique.paiementInterets();
        Toast.makeText(this, "Paiement éffectué avec succès", Toast.LENGTH_SHORT).show();
    }

    // on ouvre l'ecran liste cheques
    public void onClickBtnCheques(View view) {
        Intent fenetreListeCheques = new Intent(this, EcranListeCheques.class);
        startActivity(fenetreListeCheques);
    }

    // on ouvre l'ecran liste epargnes
    public void onClickBthEpargnes(View view) {
        Intent fenetreListeEpargne = new Intent(this, EcranListeEpargne.class);
        startActivity(fenetreListeEpargne);
    }

    // on ouvre l'ecran liste cllients
    public void onClickBtnClients(View view) {
        Intent fenetreListeClients = new Intent(this, EcranListeClients.class);
        startActivity(fenetreListeClients);
    }

    public void onClickBtnLogout(View view) {
        finish();
    }
}