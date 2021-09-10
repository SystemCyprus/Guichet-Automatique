/*
    Projet guichet automatique
    Nicolae-Florin Munteanu
    Christian Toumie
*/
package mnf.collateral.guichetautomatique;


// classe compte de cheques herite de la classe compte mais n'a aucune methode a elle meme
public class ClasseCheques extends ClasseCompte {
    public ClasseCheques(String nip, String compte, double solde) {
        super(nip, compte, solde);
    }
}
