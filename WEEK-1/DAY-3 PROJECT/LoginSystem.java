import java.util.Scanner;

class Login {
    private String email;
    private String pwd;

    Scanner input = new Scanner(System.in);

    public void setCredentials() {
        String remail, rpwd;
        System.out.println("Enter Email : ");
        remail = input.nextLine();
        System.out.println("Enter Password : ");
        rpwd = input.nextLine();
        email = remail;
        pwd = rpwd;
    }

    public void login() {
        String uEmail, uPwd;
        System.out.println("Enter Your Email : ");
        uEmail = input.nextLine();
        System.out.println("Enter Your Password : ");
        uPwd = input.nextLine();
        if (email.equals(uEmail) && pwd.equals(uPwd)) {
            System.out.println("Login SUccesful");
        } else {
            System.out.println("Wrong Credentials");
        }
    }
}

class LoginSystem {
    public static void main(String[] args) {
        Login u1 = new Login();
        u1.setCredentials();
        u1.login();
    }
}