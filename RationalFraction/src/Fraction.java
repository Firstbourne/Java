public class Fraction {
    private int nominator;
    private int denominator;

    public Fraction() {
        nominator = 1;
        denominator = 1;
    }

    public void setFraction(int nominator, int denominator){
        this.nominator = nominator;
        this.denominator = denominator;
    }

    public void add(Fraction fraction) {
        if (denominator == fraction.denominator) {
            nominator += fraction.nominator;
            return;
        }
        nominator *= fraction.denominator;
        fraction.nominator *= denominator;
        nominator += fraction.nominator;
        denominator *= fraction.denominator;
    }

    public void multi(Fraction fraction) {
        nominator *= fraction.nominator;
        denominator *= fraction.denominator;
    }

    public void divide(Fraction fraction) {
        nominator *= fraction.denominator;
        denominator *= fraction.nominator;
    }

    public void print() {
        System.out.println(nominator + "/" + denominator);
    }
}
