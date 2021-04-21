package mnf.collateral.guichetautomatique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class EcranPrincipal extends AppCompatActivity {

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

        tvBonjour = findViewById(R.id.tvBonjour);
        tvMontant = findViewById(R.id.tvMontant);

        Intent intentLogin = getIntent();
        Bundle infosLogin = intentLogin.getExtras();

        nom = infosLogin.getString("Nom");
        prenom = infosLogin.getString("Prenom");
        compteCheques = infosLogin.getString("compteCheques");
        compteEpargne = infosLogin.getString("compteEpargne");

        soldeCheques = infosLogin.getDouble("soldeCheques");
        soldeEpargne = infosLogin.getDouble("soldeEpargne");

        String strBonjour = "Bonjour " + nom + " " + prenom;
        tvBonjour.setText(strBonjour);

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

    public void onClickBtnLogout(View view) {
        Bundle bundleLogout = new Bundle();
        bundleLogout.putString("compteCheques", compteCheques);
        bundleLogout.putString("compteEpargne", compteEpargne);
        bundleLogout.putDouble("soldeCheques", soldeCheques);
        bundleLogout.putDouble("soldeEpargne", soldeCheques);

        Intent intentRetour = new Intent(this, EcranLogin.class);
        setResult(1, intentRetour);
        intentRetour.putExtras(bundleLogout);
        finish();
    }

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

    public void onClickBtnC(View view) {
        resetMontant();
    }

    public void resetMontant(){
        tvMontant.setText("0.00");
    }

    public void onClickEtatComptes(View view) {
        updateEtatComptes();
    }

    public void updateEtatComptes(){
        TextView tvCheques = findViewById(R.id.tvSoldeCheques);
        TextView tvEpargne= findViewById(R.id.tvSoldeEpargne);

        tvCheques.setText("Solde compte Chèques: " + String.format("%.2f",soldeCheques));
        tvEpargne.setText("Solde compte Épargnes: " + String.format("%.2f",soldeEpargne));
    }


    public void onClickBtnSoumettre(View view) {
        double montant = Double.parseDouble(tvMontant.getText().toString());

        if(montant==0.00){
            Toast.makeText(this, "Veuillez entrer un montant", Toast.LENGTH_SHORT).show();
        }
        else {
            switch (strOperation) {
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
                    if (strCompte.equals("Chèques")) {
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
                    } else if (strCompte.equals("Épargne")) {
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
                case "Virement":
                    if (strCompte.equals("Chèques")) {
                        if (montant > 100000) {
                            Toast.makeText(this, "Maximum de 100,000$", Toast.LENGTH_SHORT).show();
                        } else {
                            if (montant > soldeCheques) {
                                Toast.makeText(this, "Fonds insuffisants", Toast.LENGTH_SHORT).show();
                            } else {
                                soldeCheques -= montant;
                                soldeEpargne += montant;
                                Toast.makeText(this, "Chèques --> " +montant+" --> Épargne", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else if (strCompte.equals("Épargne")) {
                        if (montant > 100000) {
                            Toast.makeText(this, "Maximum de 100,000$", Toast.LENGTH_SHORT).show();
                        } else {
                            if (montant > soldeEpargne) {
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
        resetMontant();
        updateEtatComptes();
    }
}