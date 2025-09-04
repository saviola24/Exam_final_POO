package hei.school;

import java.time.LocalDate;

public class Etudiant extends Personne {
    private String Groupe;
    private Tuteur tuteur;

    public Etudiant(int id, String nom, String prenom, LocalDate dateDeNaissance, String email, String numeroTelephone, String groupe, Tuteur tuteur) {
        super(id,nom,prenom,dateDeNaissance,email,numeroTelephone);
        this.Groupe = groupe;
        this.tuteur = tuteur;
    }

    public String getGroupe() {
        return Groupe;
    }

    public void setGroupe(String groupe) {
        Groupe = groupe;
    }

    public Tuteur getTuteur() {
        return tuteur;
    }

    public void setTuteur(Tuteur tuteur) {
        this.tuteur = tuteur;
    }
}
