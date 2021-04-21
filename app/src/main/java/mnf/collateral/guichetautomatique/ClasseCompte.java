package mnf.collateral.guichetautomatique;

public class ClasseCompte {
    protected String numeroNip;
    protected String numeroCompte;
    protected double solde;


    public ClasseCompte(String nip, String compte, double solde) {
        this.numeroNip = nip;
        this.numeroCompte = compte;
        this.solde = solde;
    }

    public String getNumeroNip() {
        return numeroNip;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }


    public double getSolde() {
        return this.solde;
    }

    public void setSolde(double montant) {
        solde = montant;
    }

    public void retrait(double montant, String typeCompte) {
        solde -= montant;
    }

    public void depot(double montant, String typeCompte) {
        solde += montant;
    }
}
