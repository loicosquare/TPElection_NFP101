package edu.cnam.nfp101.tp.interfac;

/**
 * Interface representant un participant a une election.
 */
public interface Participant {

    /**
     * Obtenir le nom complet du participant.
     * @return Le nom complet du participant.
     */
    String getNomComplet();

    /**
     * Obtenir le nombre de voix du participant.
     * @return Le nombre de voix (null si pas encore connu).
     */
    Integer getVoix();

    /**
     * Ajouter des voix au participant.
     * @param voix Le nombre de voix a ajouter.
     */
    void ajouterVoix(int voix);
}
