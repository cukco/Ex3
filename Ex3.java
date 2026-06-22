import java.util.Scanner;
public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("a: ");
        int a = scanner.nextInt();
        System.out.print("b: ");
        int b = scanner.nextInt();
        System.out.print("c: ");
        int c = scanner.nextInt();
        System.out.print("d: ");
        int d = scanner.nextInt();
        System.out.printf("Result: %d/%d ",a*d+b*c,b*d);
    }
}
