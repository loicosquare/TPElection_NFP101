package edu.cnam.nfp101.tp.models;

import edu.cnam.nfp101.tp.interfac.Participant;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe representant une circonscription dans une election.
 */
public class Circonscription {

    // Attributs privés.
    private String nom;
    private int nbInscrits;
    private List<Participant> participants;
    private boolean electionTerminee;

    // Variables statiques pour les messages d'erreur.
    private static final String PARTICIPANT_NON_TROUVE = "Participant non trouve: ";
    private static final String NOMBRE_DE_VOIX_SUPERIEUR_AU_NOMBRE_D_INSCRITS = "Nombre de voix superieur au nombre d'inscrits!";
    private static final String ELECTION_NON_TERMINEE = "L'election n'est pas encore terminee.";

    /**
     * Constructeur pour une circonscription.
     * @param nom Le nom de la circonscription.
     * @param nbInscrits Le nombre d'inscrits sur les listes electorales.
     */
    public Circonscription(String nom, int nbInscrits) {
        this.nom = nom;
        this.nbInscrits = nbInscrits;
        this.participants = new ArrayList<>();
        this.electionTerminee = false;
    }

    /**
     * Methode pour ajouter un participant dans la circonscription.
     * @param participant Le participant à ajouter.
     */
    public void ajouterParticipant(Participant participant) {
        this.participants.add(participant);
    }

    /**
     * Methode pour ajouter des voix a un participant.
     * @param nomComplet Le nom complet du participant.
     * @param voix Le nombre de voix a ajouter.
     */
    public void ajouterVoix(String nomComplet, int voix) {
        for (Participant participant : participants) {
            if (participant.getNomComplet().equals(nomComplet)) {
                participant.ajouterVoix(voix);
                return;
            }
        }
        throw new IllegalArgumentException(PARTICIPANT_NON_TROUVE + nomComplet);
    }

    /**
     * Methode pour clore l'election.
     */
    public void cloreElection() {
        int totalVoix = participants.stream()
                .mapToInt(p -> p.getVoix() == null ? 0 : p.getVoix())
                .sum();

        if (totalVoix > nbInscrits) {
            throw new IllegalStateException(NOMBRE_DE_VOIX_SUPERIEUR_AU_NOMBRE_D_INSCRITS);
        }
        this.electionTerminee = true;
    }

    /**
     * Methode pour calculer le taux de participation.
     * @return Le taux de participation en pourcentage.
     */
    public double calculerTauxParticipation() {
        int totalVoix = participants.stream()
                .mapToInt(p -> p.getVoix() == null ? 0 : p.getVoix())
                .sum();
        return (double) totalVoix / nbInscrits * 100;
    }

    /**
     * Methode pour determiner le vainqueur de l'élection.
     * @return Le participant vainqueur (null si égalite).
     */
    public List<Participant> determinerVainqueurs() {
        if (!electionTerminee) {
            throw new IllegalStateException(ELECTION_NON_TERMINEE);
        }

        List<Participant> vainqueurs = new ArrayList<>();
        int nombreVoixMax = -1;

        for (Participant participant : participants) {
            int voix = participant.getVoix() == null ? 0 : participant.getVoix();
            if (voix > nombreVoixMax) {
                nombreVoixMax = voix;
                vainqueurs.clear(); // réinitialisation de la liste
                vainqueurs.add(participant);
            } else if (voix == nombreVoixMax) {
                vainqueurs.add(participant); //Ajout de ce participant qui est considéré comme ex æquo
            }
        }
        return vainqueurs;
    }

    /**
     * Methode toString pour representer la circonscription.
     * @return Representation sous forme de texte la circonscription.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Circonscription: " + nom + "\n");
        sb.append("Nombre d'inscrits: " + nbInscrits + "\n");
        sb.append("Participants:\n");
        for (Participant participant : participants) {
            sb.append("  - ").append(participant).append("\n");
        }
        sb.append("Election terminee: " + electionTerminee + "\n");
        return sb.toString();
    }
}
