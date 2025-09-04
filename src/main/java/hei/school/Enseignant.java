package hei.school;

import java.time.LocalDate;

public class Enseignant extends Personne {
    private String specialiste;

    public Enseignant(int id, String nom, String prenom, LocalDate dateDeNaissance, String email, String numeroTelephone, String specialite){
        super(id, nom, prenom, dateDeNaissance, email, numeroTelephone);
        this.specialiste = specialite;
    }
}
