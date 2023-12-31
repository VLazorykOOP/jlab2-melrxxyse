public class Матриця2x2 {
    private double[][] матриця;

    public Матриця2x2(double[][] матриця) {
        this.матриця = матриця;
    }

    public double знайтиДетермінант() {
        return матриця[0][0] * матриця[1][1] - матриця[0][1] * матриця[1][0];
    }

    public Матриця2x2 знайтиОберненуМатрицю() {
        double[][] обернена = new double[2][2];
        double детермінант = знайтиДетермінант();

        обернена[0][0] = матриця[1][1] / детермінант;
        обернена[0][1] = -матриця[0][1] / детермінант;
        обернена[1][0] = -матриця[1][0] / детермінант;
        обернена[1][1] = матриця[0][0] / детермінант;

        return new Матриця2x2(обернена);
    }

    public Матриця2x2 помножитиНа(Матриця2x2 інша) {
        double[][] результат = new double[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                результат[i][j] = матриця[i][0] * інша.матриця[0][j] + матриця[i][1] * інша.матриця[1][j];
            }
        }

        return new Матриця2x2(результат);
    }

    public Матриця2x2 додатиДо(Матриця2x2 інша) {
        double[][] результат = new double[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                результат[i][j] = матриця[i][j] + інша.матриця[i][j];
            }
        }

        return new Матриця2x2(результат);
    }

    public Матриця2x2 помножитиНа(double число) {
        double[][] результат = new double[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                результат[i][j] = матриця[i][j] * число;
            }
        }

        return new Матриця2x2(результат);
    }

    public void вивестиМатрицю() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(матриця[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] матриця1 = {{1, 2}, {3, 4}};
        double[][] матриця2 = {{5, 6}, {7, 8}};

        Матриця2x2 м1 = new Матриця2x2(матриця1);
        Матриця2x2 м2 = new Матриця2x2(матриця2);

        Матриця2x2 сума = м1.додатиДо(м2);
        Матриця2x2 добуток = м1.помножитиНа(м2);
        Матриця2x2 добутокНаЧисло = м1.помножитиНа(3);
        Матриця2x2 обернена = м1.знайтиОберненуМатрицю();

        System.out.println("Сума матриць:");
        сума.вивестиМатрицю();

        System.out.println("Добуток матриць:");
        добуток.вивестиМатрицю();

        System.out.println("Добуток матриці на число:");
        добутокНаЧисло.вивестиМатрицю();

        System.out.println("Обернена матриця:");
        обернена.вивестиМатрицю();
    }
}
