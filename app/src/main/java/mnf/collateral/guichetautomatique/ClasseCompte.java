/*
    Projet guichet automatique
    Nicolae-Florin Munteanu
    Christian Toumie
*/
package mnf.collateral.guichetautomatique;


// classe compte, pour effectuer diverses operations sur un compte en particulier
// ces informations sont valides pour touss les types de compte heritant de cette classe
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

}
