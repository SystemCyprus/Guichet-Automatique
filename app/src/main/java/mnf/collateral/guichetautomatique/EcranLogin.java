/*
    Projet guichet automatique
    Nicolae-Florin Munteanu
    Christian Toumie
*/
package mnf.collateral.guichetautomatique;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EcranLogin extends AppCompatActivity {
    // constante pour le intent
    public final int REQUEST_FENETRE_PRINCIPALE = 1;
    // singleton de notre classe guichet
    public Guichet guichetAutomatique = Guichet.getInstance();
    // les variables pour passer en bundle a l'ecran principal
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
        // declaration de 2 textvieus, les memes que sur l'cran login, pour les manipuler en java
        TextView strUser = findViewById(R.id.txtUser);
        TextView txtNip = findViewById(R.id.txtNip);

        // saisie des user input dans les textview
        String strNom = strUser.getText().toString();
        String strNip = txtNip.getText().toString();

        // message d'erreur ssi un des deux champs est vide
        if (strNom.equalsIgnoreCase("") || strNip.equalsIgnoreCase("")) {
                Toast.makeText(this, "Entrez le username ET le mot de passe", Toast.LENGTH_SHORT).show();
            // si c'est le user android, on va a l'ecran admin
            } else if (guichetAutomatique.ValiderUtilisateur(strNom, strNip)  && strNom.equalsIgnoreCase("android")) {
                Intent fenetreAdmin = new Intent(this, EcranAdmin.class);
                startActivity(fenetreAdmin);
            // si c'est un user valide et le nip est ok, on va a l'ecran principal
            } else if (guichetAutomatique.ValiderUtilisateur(strNom, strNip)) {
                // jai mis le code pour le bundle dans la classse, pour chercher le nom prenom, numeros des deux comptes et leur solde
                Bundle infosLogin = guichetAutomatique.ChercherBundle(strNom, strNip);
                // le intent est pour l'ecran principal
                Intent intentFenetrePrincipale = new Intent(this, EcranPrincipal.class);
                // on ajoute les extras du bundle au intent
                intentFenetrePrincipale.putExtras(infosLogin);
                // on ouvre l'autre activite, mais on attend un resultat en retour
                startActivityForResult(intentFenetrePrincipale, REQUEST_FENETRE_PRINCIPALE);
            } else
                //message d'erreur si le username ou le nip ne sont pas valides
                Toast.makeText(this, "Username ou nip invalide", Toast.LENGTH_SHORT).show();
    }

    @Override // l'event listener pour le retour de la page principale,
                // avec les infos necessaires pour mettre a jour les transactionss de l'usager
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent extrasRetour){
        super.onActivityResult(requestCode, resultCode, extrasRetour);
        if (requestCode == REQUEST_FENETRE_PRINCIPALE){
            if (resultCode == 1){
                compteCheques = extrasRetour.getStringExtra("compteCheques");
                compteEpargne = extrasRetour.getStringExtra("compteEpargne");
                soldeCheques = extrasRetour.getDoubleExtra("soldeCheques", 0);
                soldeEpargne = extrasRetour.getDoubleExtra("soldeEpargne", 0);
                // mise a jour des listes avec les comptes
                guichetAutomatique.setCheques(compteCheques, soldeCheques);
                guichetAutomatique.setEpargne(compteEpargne, soldeEpargne);
            }
        }
    }
}