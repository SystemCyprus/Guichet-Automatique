/*
    Projet guichet automatique
    Nicolae-Florin Munteanu
    Christian Toumie
*/
package mnf.collateral.guichetautomatique;

import android.os.Bundle;

// classe definit nos objets clients, et nous fournit des methodes pour acceder et manipuler ses proprietes
public class ClasseClient {
    private String nom;
    private String prenom;
    private String username;
    private String numeroNIP;

    public ClasseClient(String nom, String prenom, String username, String nip){
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.numeroNIP = nip;
    }

    public String getNom(){
        return nom;
    }

    public String getPrenom(){ return prenom; }

    public String getUsername(){
        return username;
    }

    public String getNumeroNIP(){
        return numeroNIP;
    }
}
