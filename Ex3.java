import java.util.Scanner;
public class Ex53 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập mật khẩu: ");
        String pass=sc.nextLine().trim();
        String passwordRegex="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";
        if(pass.matches(passwordRegex)) System.out.print("Mật khẩu hợp lệ");
        else System.out.print("Mật khẩu không hợp lệ");
    }
}
