package mnf.collateral.guichetautomatique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class EcranAdmin extends AppCompatActivity {

    Guichet guichetAutomatique = Guichet.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenetre_admin);
    }

    public void onClickBtnInterets(View view) {
       /* if (guichetAutomatique.paiementInterets()){
            Toast.makeText(this, "Paiement éffectué avec succès", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Il y a une erreur", Toast.LENGTH_SHORT).show();
        }*/
    }

    public void onClickBtnCheques(View view) {
        Intent fenetreListeCheques = new Intent(this, EcranListeCheques.class);
        startActivity(fenetreListeCheques);
    }

    public void onClickBthEpargnes(View view) {
        Intent fenetreListeEpargne = new Intent(this, EcranListeEpargne.class);
        startActivity(fenetreListeEpargne);
    }

    public void onClickBtnClients(View view) {
        Intent fenetreListeClients = new Intent(this, EcranListeClients.class);
        startActivity(fenetreListeClients);
    }

    public void onClickBtnLogout(View view) {
        finish();
    }
}