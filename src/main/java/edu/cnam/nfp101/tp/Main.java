package edu.cnam.nfp101.tp;

import edu.cnam.nfp101.tp.interfac.Participant;
import edu.cnam.nfp101.tp.models.Candidat;
import edu.cnam.nfp101.tp.models.Circonscription;

import java.util.List;

/**
 * Classe principale pour tester le système d'élections.
 */
public class Main {
    public static void main(String[] args) {
        // Création de la circonscription de Picsouville
        Circonscription picsouville = getCirconscription();

        // Affichage des resultats
        System.out.println(" ************ " + picsouville + " ************ ");
        System.out.println("Taux de participation: " + picsouville.calculerTauxParticipation() + "%");

        List<Participant> vainqueurs = picsouville.determinerVainqueurs();
        if (vainqueurs.size() == 1) {
            System.out.println("Le vainqueur est: " + vainqueurs.get(0));
        } else {
            System.out.println("Il y a une egalite entre les participants suivants: ");
            for (Participant p : vainqueurs) {
                System.out.println(" - " + p);
            }
        }
    }

    /**
     * Methode pour creer une circonscription fictive.
     * @return La circonscription creee.
     */
    private static Circonscription getCirconscription() {
        Circonscription picsouville = new Circonscription("Picsouville", 75);

        // Ajout des participants a la circonscription
        Participant riri = new Candidat("Riri", "LA PORTE", null);
        Participant fifi = new Candidat("Fifi", "COURCAUD", "NFP_101");
        Participant loulou = new Candidat("Loulou", "NICOLAS", "CNAM");

        picsouville.ajouterParticipant(riri);
        picsouville.ajouterParticipant(fifi);
        picsouville.ajouterParticipant(loulou);

        // Ajout des voix des participants
        picsouville.ajouterVoix("Riri LA PORTE", 20);
        picsouville.ajouterVoix("Fifi COURCAUD", 18);
        picsouville.ajouterVoix("Loulou NICOLAS", 37);

        // Cloture de l'élection de Picsouville
        picsouville.cloreElection();
        return picsouville;
    }
}
