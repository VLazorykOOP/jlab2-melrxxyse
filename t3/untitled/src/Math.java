import java.util.Scanner;

public class Math {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть перше число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введіть друге число: ");
        int num2 = scanner.nextInt();

        int gcd = findGCD(num1, num2);
        int lcm = findLCM(num1, num2);

        System.out.println("НСД: " + gcd);
        System.out.println("НКМ: " + lcm);

        scanner.close();
    }

    // Функція для пошуку найбільшого спільного дільника (НСД)
    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }

        return findGCD(b, a % b);
    }

    // Функція для пошуку найменшого кратного (НКМ)
    public static int findLCM(int a, int b) {
        int gcd = findGCD(a, b);

        // НКМ = (a * b) / НСД
        return (a * b) / gcd;
    }
}
