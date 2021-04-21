package mnf.collateral.guichetautomatique;

public class ClasseCheques extends ClasseCompte {
    public double soldeCheques;
    public ClasseCheques(String nip, String compte, double solde) {
        super(nip, compte, solde);
    }
}
