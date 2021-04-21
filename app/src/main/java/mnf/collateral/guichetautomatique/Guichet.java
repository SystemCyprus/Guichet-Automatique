package mnf.collateral.guichetautomatique;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Guichet extends Application{
    public static Guichet instanceGuichet = null;
    public static synchronized Guichet getInstance(){
        return instanceGuichet;
    }

    private static final ArrayList<ClasseClient> listeClients = new ArrayList<>();
    private static final ArrayList<ClasseCompte> comptesCheques = new ArrayList<>();
    private static final ArrayList<ClasseCompte> comptesEpargne = new ArrayList<>();

    public static ArrayList<ClasseCompte> getComptesCheques(){
        return comptesCheques;
    }
    public static ArrayList<ClasseCompte> getComptesEpargne(){
        return comptesEpargne;
    }
    public static ArrayList<ClasseClient> getListeClients(){
        return listeClients;
    }

    public Guichet() {
        listeClients.add( new ClasseClient("Himrane", "Naïm", "Android", "Admin"));
        listeClients.add( new ClasseClient("Munteanu", "Florin", "florin", "florin"));
        listeClients.add( new ClasseClient("Toumie", "Christian", "christian", "christian"));
        listeClients.add( new ClasseClient("Kuamé", "Félicien", "felicien", "felicien"));

        comptesCheques.add(new ClasseCheques("Admin", "0001", 45.19));
        comptesCheques.add(new ClasseCheques("florin", "0002", 87.32));
        comptesCheques.add(new ClasseCheques("christian", "0003", 72.28));
        comptesCheques.add(new ClasseCheques("felicien", "0004", 54.04));

        comptesEpargne.add(new ClasseEpargne("Admin", "7771", 5435.64));
        comptesEpargne.add(new ClasseEpargne("florin", "7772", 3872.09));
        comptesEpargne.add(new ClasseEpargne("christian", "7773", 4000.89));
        comptesEpargne.add(new ClasseEpargne("felicien", "7774", 2107.35));
    }

    public boolean ValiderUtilisateur(String username, String nip){
        boolean valide = false;
        for (ClasseClient client : listeClients) {
            valide = client.getUsername().equalsIgnoreCase(username) && client.getNumeroNIP().equalsIgnoreCase(nip);
            if(valide)
                break;
        }
        return valide;
    }

    public Bundle GetBundle(String user, String nip){
        Bundle ceBundle = new Bundle();
        for (ClasseClient c : listeClients)
        {
            if (c.getUsername().equalsIgnoreCase(user) && c.getNumeroNIP().equalsIgnoreCase(nip))
            {
                ceBundle.putString("Nom", c.getNom());
                ceBundle.putString("Prenom", c.getPrenom());
                for (ClasseCompte compte : comptesCheques)
                {
                    if (compte.getNumeroNip().equalsIgnoreCase(nip)){
                        ceBundle.putString("compteCheques", compte.getNumeroCompte());
                        ceBundle.putDouble("soldeCheques", compte.getSolde());
                        break;
                    }
                }
                for (ClasseCompte compte : comptesEpargne)
                {
                    if (compte.getNumeroNip().equalsIgnoreCase(nip)){
                        ceBundle.putString("compteEpargne", compte.getNumeroCompte());
                        ceBundle.putDouble("soldeEpargne", compte.getSolde());
                        break;
                    }
                }
            }
        }
        return ceBundle;
    }

    public double RetraitCheque(String nip, double montant){
        return 0.00;
    }

    public double RetraitEpargne(String nip, double montant){
        return 0.00;
    }

    public void setCheques(String numeroCompte,double solde){
        for (ClasseCompte c : comptesCheques)
        {
            if (c.getNumeroCompte().equalsIgnoreCase(numeroCompte)){
                c.setSolde(solde);
            }
        }
    }

    public void setEpargne(String numeroCompte, double solde){
        for (ClasseCompte c : comptesEpargne)
        {
            if (c.getNumeroCompte().equalsIgnoreCase(numeroCompte)){
                c.setSolde(solde);
            }
        }
    }

    public boolean paiementInterets(){
        return true;
    }
}
