package mnf.collateral.guichetautomatique;

import android.os.Bundle;

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
