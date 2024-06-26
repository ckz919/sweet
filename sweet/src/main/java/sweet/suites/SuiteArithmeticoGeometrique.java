package sweet.suites;

import java.util.ArrayList;

public class SuiteArithmeticoGeometrique extends SuiteRecurrente {

    private double raisonGeometrique;
    private double raisonArithmetique;

    public SuiteArithmeticoGeometrique(String chaineSuite, double valPremierTerme,
                                       double raisonGeometrique, double raisonArithmetique) {
        super(chaineSuite, new double[]{valPremierTerme});
        this.raisonGeometrique = raisonGeometrique;
        this.raisonArithmetique = raisonArithmetique;
    }

    public double getRaisonGeometrique() {
        return raisonGeometrique;
    }

    public double getRaisonArithmetique() {
        return raisonArithmetique;
    }

    public double getValeurPremierTerme() {
        return getValPremierTerme(0);
    }

    @Override
    public ArrayList<Double> getValeursTermes(int rangMaxTermes) {
        ArrayList<Double> valeurs = new ArrayList<>();

        double terme = getValeurPremierTerme();
        valeurs.add(terme);

        if (rangMaxTermes == 0) return valeurs;

        for (int i = 1; i <= rangMaxTermes; i++) {
            terme = terme * raisonGeometrique + raisonArithmetique;
            valeurs.add(terme);
        }

        return valeurs;
    }

    @Override
    public void calculeEtAffiche(int rangMaxTermes) {
        super.calculeEtAffiche(rangMaxTermes);
        System.out.println("Valeur de la raison arithmétique : " + getRaisonArithmetique());
        System.out.println("Valeur de la raison géométrique : " + getRaisonGeometrique());
    }
}
