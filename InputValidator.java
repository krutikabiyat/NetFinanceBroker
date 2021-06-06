import java.util.Scanner;

public class InputValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int a = scanner.nextInt();
        System.out.println("Value of a: "+a);

        System.out.println("Enter a string: ");
        char c = scanner.next().charAt(0);
        System.out.println("Value of c: "+c);
    }
}
