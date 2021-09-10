/*
    Projet guichet automatique
    Nicolae-Florin Munteanu
    Christian Toumie
*/
package mnf.collateral.guichetautomatique;



// classe pour les objets compte epargne, herite de la classe compte, ocntien une methode a elle meme
public class ClasseEpargne extends ClasseCompte {

    private final double tauxInteret = 1.25;

    public ClasseEpargne(String nip, String compte, double solde) {
        super(nip, compte, solde);
    }

    public void ajouterInterets(){
        this.solde *= tauxInteret;
    }
}