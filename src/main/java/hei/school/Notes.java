package hei.school;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Notes {
    private double valeurActuelle;
    private final Map<Instant,HistoriqueNote> historique;

    public Notes(double valeurInitiale) {
        this.valeurActuelle = valeurInitiale;
        this.historique = new TreeMap<>();
        this.historique.put(Instant.now(),new HistoriqueNote(valeurInitiale, "Note initiale"));
    }

    public void modifierNote(double nouvelleValeur, String motif) {
        this.valeurActuelle += nouvelleValeur;
        this.historique.put(Instant.now(), new HistoriqueNote(nouvelleValeur, motif));
    }

    public double getValeurActuelle() {
        return valeurActuelle;
    }

    public Map<Instant, HistoriqueNote> getHistorique(){
        return historique;
    }

    public static class  HistoriqueNote{
        private final double valeur;
        private final String motif;

        public HistoriqueNote(double valeur, String motif) {
            this.valeur = valeur;
            this.motif = motif;
        }
    }

    public void setValeurActuelle(double valeurActuelle) {
        this.valeurActuelle = valeurActuelle;
    }
}
