package mnf.collateral.guichetautomatique;

public class ClasseEpargne extends ClasseCompte {
    private final double tauxInteret = 1.25;

    public ClasseEpargne(String nip, String compte, double solde) {
        super(nip, compte, solde);
    }

    public void paiementInterets(){
        super.solde = this.solde * 1.25;
    }
}