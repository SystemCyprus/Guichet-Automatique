/*
    Projet guichet automatique
    Nicolae-Florin Munteanu
    Christian Toumie
*/
package mnf.collateral.guichetautomatique;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Guichet extends Application{
    // pour avoir un singleton
    private static Guichet instanceGuichet = null;
    public static synchronized Guichet getInstance(){
        if (instanceGuichet == null)
            instanceGuichet = new Guichet();
        return instanceGuichet;
    }
    // listes des comptes
    private static final ArrayList<ClasseClient> listeClients = new ArrayList<>();
    private static final ArrayList<ClasseCompte> comptesCheques = new ArrayList<>();
    private static final ArrayList<ClasseCompte> comptesEpargne = new ArrayList<>();

    // pour acceder aux listes, des getters
    public static ArrayList<ClasseClient> getListeClients(){
        return listeClients;
    }
    public static ArrayList<ClasseCompte> getComptesCheques(){
        return comptesCheques;
    }
    public static ArrayList<ClasseCompte> getComptesEpargne(){
        return comptesEpargne;
    }

    private Guichet() {
        // population des listes avec qqes items chaque
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

    // methode pour valider un username et un nip
    public boolean ValiderUtilisateur(String username, String nip){
        boolean valide = false;
        for (ClasseClient client : listeClients) {
            valide = client.getUsername().equalsIgnoreCase(username) && client.getNumeroNIP().equalsIgnoreCase(nip);
            if(valide)
                break;
        }
        return valide;
    }

    // methode pour mettre les infos qu'on veut passer a l'ecran principal dans un bundle
    public Bundle ChercherBundle(String user, String nip){
        Bundle ceBundle = new Bundle();
        for (ClasseClient c : listeClients)
        {   // le nom et prenom viennent de la classe client
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

    // mise a jour d'un compte de cheque
    public void setCheques(String numeroCompte,double solde){
        for (ClasseCompte c : comptesCheques)
        {
            if (c.getNumeroCompte().equalsIgnoreCase(numeroCompte)){
                c.setSolde(solde);
            }
        }
    }

    // misa a jur d'un compte epargne
    public void setEpargne(String numeroCompte, double solde){
        for (ClasseCompte c : comptesEpargne)
        {
            if (c.getNumeroCompte().equalsIgnoreCase(numeroCompte)){
                c.setSolde(solde);
            }
        }
    }

    // fonction pour faire le paiement d'interets
    public static void paiementInterets(){
        for (ClasseCompte c : comptesEpargne)
        {
            ((ClasseEpargne)c).ajouterInterets();
        }
    }
}
