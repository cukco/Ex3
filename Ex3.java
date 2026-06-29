import java.util.Scanner;
import java.lang.Math;
public class Ex23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum=0;
        while(n!=0){
            sum+=Math.abs(n%10);
            n=n/10;
        }
        System.out.printf("Tổng các chữ số là: %d",sum);
    }
}
