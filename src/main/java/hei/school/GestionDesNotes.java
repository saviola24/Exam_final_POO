package hei.school;

import hei.school.Cours;
import hei.school.Etudiant;
import hei.school.Examen;
import hei.school.Notes;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GestionDesNotes {
    private final Map<Examen, Map<Etudiant, Notes>> notesParExamen;
    private final Map<Etudiant, Map<Cours, List<Examen>>> examensParEtudiantEtCours;

    public GestionDesNotes() {
        this.notesParExamen = new TreeMap<>();
        this.examensParEtudiantEtCours = new TreeMap<>();
    }

    public GestionDesNotes(Map<Examen, Map<Etudiant, Notes>> notesParExamen, Map<Etudiant, Map<Cours, List<Examen>>> examensParEtudiantEtCours) {
        this.notesParExamen = notesParExamen;
        this.examensParEtudiantEtCours = examensParEtudiantEtCours;
    }

    public void ajouterNote(Examen examen, Etudiant etudiant, Notes note) {
        notesParExamen.computeIfAbsent(examen, k -> new TreeMap<>()).put(etudiant, note);
        examensParEtudiantEtCours.computeIfAbsent(etudiant, k -> new TreeMap<>())
                .computeIfAbsent(examen.getCours(), k -> new ArrayList<>())
                .add(examen);
    }


    public double getExamGrade(Examen examen, Etudiant etudiant, Instant t) {
        if (!notesParExamen.containsKey(examen) || !notesParExamen.get(examen).containsKey(etudiant)) {
            throw new IllegalArgumentException("Note not found for the given exam and student.");
        }

        Notes note = notesParExamen.get(examen).get(etudiant);
        Map<Instant, Notes.HistoriqueNote> historique = note.getHistorique();

        // Find the most recent note value before or at the specified instant 't'
        Instant lastInstant = null;
        for (Instant instant : historique.keySet()) {
            if (!instant.isAfter(t)) {
                lastInstant = instant;
            } else {
                break;
            }
        }

        if (lastInstant != null) {
            return historique.get(lastInstant).getValeur();
        }

        return note.getValeurActuelle();
    }


    public double getCourseGrade(Cours cours, Etudiant etudiant, Instant t) {
        if (!examensParEtudiantEtCours.containsKey(etudiant) || !examensParEtudiantEtCours.get(etudiant).containsKey(cours)) {
            return 0.0;
        }

        List<Examen> examens = examensParEtudiantEtCours.get(etudiant).get(cours);
        double totalPoints = 0.0;
        int totalCoefficients = 0;

        for (Examen examen : examens) {
            double examGrade = getExamGrade(examen, etudiant, t);
            totalPoints += examGrade * examen.getCoefficient();
            totalCoefficients += examen.getCoefficient();
        }

        if (totalCoefficients == 0) {
            return 0.0;
        }

        return totalPoints / totalCoefficients;
    }
}