package hei.school;

public class Cours {
    private int id;
    private String label;
    private int credit;
    private Enseignant enseignant;

    public Cours(int id, String label, int credit, Enseignant enseignant) {
        this.id = id;
        this.label = label;
        this.credit = credit;
        this.enseignant = enseignant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }
}
