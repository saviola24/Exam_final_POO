package hei.school;

import java.time.LocalDate;

public class Tuteur extends Personne {
    private String description;

    public Tuteur(int id, String nom, String prenom, LocalDate dateDeNaissance, String email, String numeroTelephone, String description) {
        super(id,nom,prenom,dateDeNaissance,email,numeroTelephone);
        this.description= description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
