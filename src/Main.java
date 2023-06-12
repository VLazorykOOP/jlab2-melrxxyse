class Rational {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменник не може бути нулем.");
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Rational add(Rational other) {
        int resultNumerator = (this.numerator * other.denominator) + (other.numerator * this.denominator);
        int resultDenominator = this.denominator * other.denominator;
        return new Rational(resultNumerator, resultDenominator).reduce();
    }

    public Rational subtract(Rational other) {
        int resultNumerator = (this.numerator * other.denominator) - (other.numerator * this.denominator);
        int resultDenominator = this.denominator * other.denominator;
        return new Rational(resultNumerator, resultDenominator).reduce();
    }

    public Rational multiply(Rational other) {
        int resultNumerator = this.numerator * other.numerator;
        int resultDenominator = this.denominator * other.denominator;
        return new Rational(resultNumerator, resultDenominator).reduce();
    }

    public Rational divide(Rational other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Ділення на нуль не можливе.");
        }

        int resultNumerator = this.numerator * other.denominator;
        int resultDenominator = this.denominator * other.numerator;
        return new Rational(resultNumerator, resultDenominator).reduce();
    }

    public boolean equals(Rational other) {
        Rational reducedThis = this.reduce();
        Rational reducedOther = other.reduce();
        return reducedThis.numerator == reducedOther.numerator && reducedThis.denominator == reducedOther.denominator;
    }

    public boolean isGreaterThan(Rational other) {
        Rational difference = this.subtract(other);
        return difference.numerator > 0;
    }

    public boolean isLessThan(Rational other) {
        Rational difference = this.subtract(other);
        return difference.numerator < 0;
    }

    public Rational reduce() {
        int gcd = findGCD(this.numerator, this.denominator);
        int reducedNumerator = this.numerator / gcd;
        int reducedDenominator = this.denominator / gcd;
        return new Rational(reducedNumerator, reducedDenominator);
    }

    private int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}

public class Main {
    public static void main(String[] args) {
        Rational r1 = new Rational(2, 3);
        Rational r2 = new Rational(3, 4);

        Rational sum = r1.add(r2);
        System.out.println("Сума: " + sum.getNumerator() + "/" + sum.getDenominator());

        Rational difference = r1.subtract(r2);
        System.out.println("Різниця: " + difference.getNumerator() + "/" + difference.getDenominator());

        Rational product = r1.multiply(r2);
        System.out.println("Добуток: " + product.getNumerator() + "/" + product.getDenominator());

        Rational quotient = r1.divide(r2);
        System.out.println("Частка: " + quotient.getNumerator() + "/" + quotient.getDenominator());

        boolean isEqual = r1.equals(r2);
        System.out.println("Чи рівні: " + isEqual);

        boolean isGreater = r1.isGreaterThan(r2);
        System.out.println("Чи більший: " + isGreater);

        boolean isLess = r1.isLessThan(r2);
        System.out.println("Чи менший: " + isLess);
    }
}
