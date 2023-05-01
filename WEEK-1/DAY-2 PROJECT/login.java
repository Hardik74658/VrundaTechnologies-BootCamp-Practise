class login {
    public static void main(String[] args) {
        String email = "hardik@gmail.com";
        String pwd = "Hardik@21549";
        String uMail = "hardik@gmail.com";
        String uPwd = "Hardik@21549";
        Boolean success = false;
        if (email.equals(uMail)) {
            if (pwd.equals(uPwd)) {
                System.out.println("Login Succesful");
                success = true;
            }
        }
        if (success == false) {
            System.out.println("Wrong Credentials");
        }
    }
}