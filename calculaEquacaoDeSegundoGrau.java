import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double A, B, C;
        double x1, x2;

        System.out.println("Informe o valor 'a' da equação:");
        A = Double.parseDouble(sc.nextLine());
        System.out.println("Informe o valor 'b' da equação:");
        B = Double.parseDouble(sc.nextLine());
        System.out.println("Informe o valor 'c' da equação:");
        C = Double.parseDouble(sc.nextLine());

        double delta = Math.sqrt(B) - (4.0 * A * C);

        x1 = (-B + Math.sqrt(delta)) / (2.0 * A);
        x2 = (-B - Math.sqrt(delta)) / (2.0 * A);

        System.out.println("Valor de delta: " + delta);
        System.out.println("Valor de x1: " + x1);
        System.out.println("Valor de x2: " + x2);

        sc.close();

    }
}
