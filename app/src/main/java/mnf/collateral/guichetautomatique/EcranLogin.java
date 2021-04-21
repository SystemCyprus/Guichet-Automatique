package mnf.collateral.guichetautomatique;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EcranLogin extends AppCompatActivity {
    public final int REQUEST_FENETRE_PRINCIPALE = 1;
    public Guichet guichetAutomatique = new Guichet();
    public String compteCheques;
    public String compteEpargne;
    double soldeEpargne;
    double soldeCheques;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenetre_login);
    }

    public void onClickBtnSignIn(View view) {
        TextView strUser = findViewById(R.id.txtUser);
        TextView txtNip = findViewById(R.id.txtNip);

        String strNom = strUser.getText().toString();
        String strNip = txtNip.getText().toString();

        if (strNom.equalsIgnoreCase("") || strNip.equalsIgnoreCase("")) {
                Toast.makeText(this, "Entrez le username ET le mot de passe", Toast.LENGTH_SHORT).show();

            } else if (guichetAutomatique.ValiderUtilisateur(strNom, strNip)  && strNom.equalsIgnoreCase("android")) {
                Intent fenetreAdmin = new Intent(this, EcranAdmin.class);
                startActivity(fenetreAdmin);

            } else if (guichetAutomatique.ValiderUtilisateur(strNom, strNip)) {

                Bundle infosLogin = guichetAutomatique.GetBundle(strNom, strNip);
                Intent intentFenetrePrincipale = new Intent(this, EcranPrincipal.class);
                intentFenetrePrincipale.putExtras(infosLogin);

                startActivityForResult(intentFenetrePrincipale, REQUEST_FENETRE_PRINCIPALE);
            } else
                Toast.makeText(this, strNom + " " + strNip + " " + "Invalide", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent extrasRetour){
        super.onActivityResult(requestCode, resultCode, extrasRetour);
        if (requestCode == REQUEST_FENETRE_PRINCIPALE){
            if (resultCode == 1){
                compteCheques = extrasRetour.getStringExtra("compteCheques");
                compteEpargne = extrasRetour.getStringExtra("compteEpargne");
                soldeCheques = extrasRetour.getDoubleExtra("soldeCheques", 0);
                soldeEpargne = extrasRetour.getDoubleExtra("soldeEpargne", 0);

                guichetAutomatique.setCheques(compteCheques, soldeCheques);
                guichetAutomatique.setEpargne(compteEpargne, soldeEpargne);
            }
        }
    }
}