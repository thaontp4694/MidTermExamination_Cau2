import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
    /*
    Viết chương trình nhập mật khẩu, yêu cầu mật khẩu phải có từ 10 ký tự trở lên
    trong đó có ít nhất 1 ký tự in hoa, 1 ký tự số, 1 ký tự đặc biệt như . - _ …
    Nếu mật khẩu ít hơn 10 ký tự thông báo mật khẩu yếu
    Nếu thiếu một trong các ký tự đặc biệt thì thông báo mật khẩu chưa đủ mạnh
     */
public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String password = "";
        do {
            System.out.print("Nhập mật khẩu: ");
            password = sc.nextLine();
            if (!minCharacter(password)) {
                System.out.println("Mật khẩu yếu!");
            }
            if (!specialCharacterCheck(password)) {
                System.out.println("Mật khẩu chưa đủ mạnh!");
            }
        }while (!minCharacter(password) || !upperCaseCheck(password) || !specialCharacterCheck(password) || !numericCheck(password));
        System.out.println("Mật khẩu mạnh!");
    }

    public static boolean minCharacter(String pw){
        if (pw.length() >= 10) {
            return true;
        }
        return false;
    }

    public static boolean upperCaseCheck(String pw){
        char[] ch = pw.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isUpperCase(ch[i])){
                return true;
            }
        }
        return false;
    }

    public static boolean numericCheck(String pw){
        Pattern p = Pattern.compile("[^A-Za-z]");
        Matcher m = p.matcher(pw);
        if (m.find())
            return true;
        return false;
    }

    public static boolean specialCharacterCheck(String pw){
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(pw);
        if (m.find())
            return true;
        return false;
    }
}
