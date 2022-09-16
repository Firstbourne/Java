public class main {
    public static void main(String[] args) {
        Fraction fraction1 = new Fraction();
        Fraction fraction2 = new Fraction();
        fraction1.setFraction(10, 5);
        fraction2.setFraction( 5, 10);
        fraction1.add(fraction2);
        fraction1.print();
        fraction1.setFraction(10, 5);
        fraction2.setFraction( 5, 10);
        fraction1.multi(fraction2);
        fraction1.print();
        fraction1.setFraction(10, 5);
        fraction2.setFraction( 5, 10);
        fraction1.divide(fraction2);
        fraction1.print();
    }
}
