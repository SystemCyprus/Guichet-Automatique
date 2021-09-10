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
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class EcranPrincipal extends AppCompatActivity {
    // les variables que nous allons manipuler et passer a l'ecran suivant
    String nom;
    String prenom;
    String compteCheques;
    String compteEpargne;
    String strOperation = "Dépôt";
    String strCompte = "Chèques";
    double soldeCheques;
    double soldeEpargne;
    TextView tvBonjour;
    TextView tvMontant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenetre_principale);
        // variables java pour nos labels bonjour et montant
        tvBonjour = findViewById(R.id.tvBonjour);
        tvMontant = findViewById(R.id.tvMontant);

        // pour recevoir les infos passees de l'ecran login via un bundle
        Intent intentLogin = getIntent();
        Bundle infosLogin = intentLogin.getExtras();

        // affectation des valeurs du bundle a des variables java
        nom = infosLogin.getString("Nom");
        prenom = infosLogin.getString("Prenom");
        compteCheques = infosLogin.getString("compteheques");
        compteEpargne = infosLogin.getString("compteEpargne");
        soldeCheques = infosLogin.getDouble("soldeCheques");
        soldeEpargne = infosLogin.getDouble("soldeEpargne");

        // saluer le user online
        String strBonjour = "Bonjour " + nom + " " + prenom;
        tvBonjour.setText(strBonjour);

        // capter la selection des radio buttons avec une variable,
        // pour choisir l'action a prendre au moment de la sooumission
        RadioGroup rgOperation = (RadioGroup)findViewById(R.id.rgOperation);
        rgOperation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId){
                    case R.id.rbDepot:
                            strOperation = "Dépôt";
                        Toast.makeText(EcranPrincipal.this, "Déposer un montant", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbRetrait:
                        strOperation = "Retrait";
                        Toast.makeText(EcranPrincipal.this, "Retirer un montant", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbVirement:
                        strOperation = "Virement";
                        Toast.makeText(EcranPrincipal.this, "Virer un montant", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        // meme chose pour les radio button du compte
        RadioGroup rgCompte = (RadioGroup)findViewById(R.id.rgCompte);
        rgCompte.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId){
                    case R.id.rbCheque:
                        strCompte = "Chèques";
                        Toast.makeText(EcranPrincipal.this, String.valueOf(R.id.rbCheque), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbEpargne:
                        strCompte = "Épargne";
                        Toast.makeText(EcranPrincipal.this, String.valueOf(R.id.rbEpargne), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    // au moment du logout, on bundle les comptes apres les avoir modifies,
    // et on les retourne a l'ecran principal avec leur numero de compte pour pouvoir les update
    public void onClickBtnLogout(View view) {
        Bundle bundleLogout = new Bundle();
        bundleLogout.putString("compteCheques", compteCheques);
        bundleLogout.putString("compteEpargne", compteEpargne);
        bundleLogout.putDouble("soldeCheques", soldeCheques);
        bundleLogout.putDouble("soldeEpargne", soldeEpargne);

        // on declare, prepare et declanche le intent de retour pour fermer cet ecran et retourner au login
        // avec les infos necessaires
        Intent intentRetour = new Intent(this, EcranLogin.class);
        intentRetour.putExtras(bundleLogout);
        setResult(1, intentRetour);
        finish();
    }

    // le regex ne nour permet d'entrer que des chiffres, une seul point, et 2 decimales
    public void onClickBtn0(View view) {
        if (tvMontant.getText().toString().equalsIgnoreCase("0.00")) {
            tvMontant.setText("0");
        }
        else if(!tvMontant.getText().toString().matches("^[0-9]+\\.[0-9]{2,}$")) {
            tvMontant.setText(tvMontant.getText().toString() + "0");
        }
    }

    public void onClickBtn1(View view) {
        if (tvMontant.getText().toString().equalsIgnoreCase("0.00")) {
            tvMontant.setText("1");
        }
        else if(!tvMontant.getText().toString().matches("^[0-9]+\\.[0-9]{2,}$")) {
            tvMontant.setText(tvMontant.getText().toString() + "1");
        }
    }

    public void onClickBtn2(View view) {
        if (tvMontant.getText().toString().equalsIgnoreCase("0.00"))
            tvMontant.setText("2");
        else if(!tvMontant.getText().toString().matches("^[0-9]+\\.[0-9]{2,}$")) {
            tvMontant.setText(tvMontant.getText().toString() + "2");
        }
    }

    public void onClickBtn3(View view) {
        if (tvMontant.getText().toString().equalsIgnoreCase("0.00"))
            tvMontant.setText("3");
        else if(!tvMontant.getText().toString().matches("^[0-9]+\\.[0-9]{2,}$")) {
            tvMontant.setText(tvMontant.getText().toString() + "3");
        }
    }

    public void onClickBtn4(View view) {
        if (tvMontant.getText().toString().equalsIgnoreCase("0.00"))
            tvMontant.setText("4");
        else if(!tvMontant.getText().toString().matches("^[0-9]+\\.[0-9]{2,}$")) {
            tvMontant.setText(tvMontant.getText().toString() + "4");
        }
    }

    public void onClickBtn5(View view) {
        if (tvMontant.getText().toString().equalsIgnoreCase("0.00"))
            tvMontant.setText("5");
        else if(!tvMontant.getText().toString().matches("^[0-9]+\\.[0-9]{2,}$")) {
            tvMontant.setText(tvMontant.getText().toString() + "5");
        }
    }

    public void onClickBtn6(View view) {
        if (tvMontant.getText().toString().equalsIgnoreCase("0.00"))
            tvMontant.setText("6");
        else if(!tvMontant.getText().toString().matches("^[0-9]+\\.[0-9]{2,}$")) {
            tvMontant.setText(tvMontant.getText().toString() + "6");
        }
    }

    public void onClickBtn7(View view) {
        if (tvMontant.getText().toString().equalsIgnoreCase("0.00"))
            tvMontant.setText("7");
        else if(!tvMontant.getText().toString().matches("^[0-9]+\\.[0-9]{2,}$")) {
            tvMontant.setText(tvMontant.getText().toString() + "7");
        }
    }

    public void onClickBtn8(View view) {
        if (tvMontant.getText().toString().equalsIgnoreCase("0.00"))
            tvMontant.setText("8");
        else if(!tvMontant.getText().toString().matches("^[0-9]+\\.[0-9]{2,}$")) {
            tvMontant.setText(tvMontant.getText().toString() + "8");
        }
    }

    public void onClickBtn9(View view) {
        if (tvMontant.getText().toString().equalsIgnoreCase("0.00"))
            tvMontant.setText("9");
        else if(!tvMontant.getText().toString().matches("^[0-9]+\\.[0-9]{2,}$")) {
            tvMontant.setText(tvMontant.getText().toString() + "9");
        }
    }

    public void onClickBtnPoint(View view) {
        if (tvMontant.getText().toString().equalsIgnoreCase("0.00")) {
            tvMontant.setText("0.");
        }
        else if(tvMontant.getText().toString().matches("^[0-9]+$"))
            tvMontant.setText(tvMontant.getText().toString() + ".");
    }

    // pour effacer le label montant
    public void onClickBtnC(View view) {
        resetMontant();
    }

    public void resetMontant(){
        tvMontant.setText("0.00");
    }

    // pour afficher l'etat des comptes
    public void onClickEtatComptes(View view) {
        updateEtatComptes();
    }

    public void updateEtatComptes(){
        TextView tvCheques = findViewById(R.id.tvSoldeCheques);
        TextView tvEpargne= findViewById(R.id.tvSoldeEpargne);

        // seulement 2 chiffres apres la virgule
        tvCheques.setText("Solde compte Chèques: " + String.format("%.2f",soldeCheques));
        tvEpargne.setText("Solde compte Épargnes: " + String.format("%.2f",soldeEpargne));
    }

    // faire les calculs necessaire, en fonction des options choisies, qu'on a capte dans la variable strOperation
    public void onClickBtnSoumettre(View view) {
        double montant = Double.parseDouble(tvMontant.getText().toString());

        // seulement si le user a entre qqch, sinon message d'erreur
        if(montant==0.00){
            Toast.makeText(this, "Veuillez entrer un montant", Toast.LENGTH_SHORT).show();
        }
        else {
            switch (strOperation) { // pour le depot on ne fait qu'ajouter la somme entree au compte selectionne
                case "Dépôt":
                    if (strCompte.equals("Chèques")) {
                        soldeCheques += montant;
                        Toast.makeText(this, montant + "$ deposés dans le compte Chèques", Toast.LENGTH_SHORT).show();
                    } else if (strCompte.equals("Épargne")) {
                        soldeEpargne += montant;
                        Toast.makeText(this, montant + "$ deposés dans le compte Chèques", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case "Retrait":
                    if (strCompte.equals("Chèques")) {// validations et calculs pour les oparations sur le compte cheques, avec messages
                        if (montant > 1000) {
                            Toast.makeText(this, "Maximum de 1,000$", Toast.LENGTH_SHORT).show();
                        } else {
                            if (montant > soldeCheques) {
                                Toast.makeText(this, "Fonds insuffisants", Toast.LENGTH_SHORT).show();
                            } else {
                                if (montant % 10 != 0) {
                                    Toast.makeText(this, "Multiples de 10 seulement", Toast.LENGTH_SHORT).show();
                                } else {
                                    soldeCheques -= montant;
                                    Toast.makeText(this, "Retrait de "+montant+"$ du compte Chèques", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    } else if (strCompte.equals("Épargne")) { // validations et calculs pour les oparations sur le compte epargne, avec messages
                        if (montant > 1000) {
                            Toast.makeText(this, "Maximum de 1,000$", Toast.LENGTH_SHORT).show();
                        } else {
                            if (montant > soldeEpargne) {
                                Toast.makeText(this, "Fonds insuffisants", Toast.LENGTH_SHORT).show();
                            } else {
                                if (montant % 10 != 0) {
                                    Toast.makeText(this, "Multiples de 10 seulement", Toast.LENGTH_SHORT).show();
                                } else {
                                    soldeEpargne -= montant;
                                    Toast.makeText(this, "Retrait de "+montant+"$ du compte Épargnes", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                    break;
                case "Virement": //validation pour le montant maximum
                    if (strCompte.equals("Chèques")) {
                        if (montant > 100000) {
                            Toast.makeText(this, "Maximum de 100,000$", Toast.LENGTH_SHORT).show();
                        } else {
                            if (montant > soldeCheques) { // on s'assure qu'il y a assez de fonds
                                Toast.makeText(this, "Fonds insuffisants", Toast.LENGTH_SHORT).show();
                            } else { // on enleve le montant du compte selectionne et on l'ajoute dans l'autre
                                soldeCheques -= montant;
                                soldeEpargne += montant;
                                Toast.makeText(this, "Chèques --> " +montant+" --> Épargne", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else if (strCompte.equals("Épargne")) {
                        if (montant > 100000) { // un maximum pour la transaction, avec message d'erreur
                            Toast.makeText(this, "Maximum de 100,000$", Toast.LENGTH_SHORT).show();
                        } else {
                            if (montant > soldeEpargne) { // on s'assure que le compte a les fonds pour le virement
                                Toast.makeText(this, "Fonds insuffisants", Toast.LENGTH_SHORT).show();
                            } else {
                                soldeEpargne -= montant;
                                soldeCheques += montant;
                                Toast.makeText(this, "Épargne --> " +montant+" --> Chèques", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    break;
            }
        }
        // effacer le montant en preparation pour une autre transaction
        resetMontant();
        // mise a jour du label etat des comptes pour voir le changement tout de suite
        updateEtatComptes();
    }
}