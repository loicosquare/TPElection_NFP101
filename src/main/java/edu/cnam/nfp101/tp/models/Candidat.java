package edu.cnam.nfp101.tp.models;

import edu.cnam.nfp101.tp.interfac.Participant;

/**
 * Classe representant un candidat a une election, implementant Participant.
 */
public class Candidat implements Participant {

    // Attributs privés
    private String nom;
    private String prenom;
    private String parti; // null si'il n'est pas affilié à un parti politique (LES INDEPENDANTS).
    private Integer voix; // null si le nombre de voix du candidat n'est pas encore connu

    /**
     * Constructeur pour un candidat.
     * @param nom Le nom du candidat.
     * @param prenom Le prenom du candidat.
     * @param parti Le parti politique du candidat (null si independant).
     */
    public Candidat(String nom, String prenom, String parti) {
        this.nom = nom;
        this.prenom = prenom;
        this.parti = parti;
        this.voix = null; // Car par defaut, le nombre de voix n'est pas connu au debut.
    }

    /**
     * Getter pour le nom complet du candidat.
     * @return Le nom complet du candidat.
     */
    @Override
    public String getNomComplet() {
        return nom + " " + prenom;
    }

    /**
     * Getter pour le nombre de voix du candidat.
     * @return Le nombre de voix (null si pas encore connu).
     */
    @Override
    public Integer getVoix() {
        return voix;
    }

    /**
     * Methode pour ajouter des voix au candidat.
     * @param voix Le nombre de voix a ajouter.
     */
    @Override
    public void ajouterVoix(int voix) {
        if (this.voix == null) {
            this.voix = 0;
        }
        this.voix += voix;
    }

    /**
     * Methode toString pour representer le candidat sous forme de chaine de caracteres.
     * @return Representation textuelle du candidat.
     */
    @Override
    public String toString() {
        String estAffilie = (parti == null) ? "Independant" : "Parti: " + parti;
        String nbVoix = (voix == null) ? "Voix non connues" : "Voix: " + voix;
        return "Candidat [" + nom + " " + prenom + ", " + estAffilie + ", " + nbVoix + "]";
    }
}

