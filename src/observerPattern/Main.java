package observerPattern;

import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String args[]) throws NoSuchAlgorithmException {
        Subject subject = new Subject();

        new SHA256Observer(subject);
        new MD5Observer(subject);

        System.out.println("Password change: pass127P");
        subject.setPwd("pass127P");
        System.out.println("State change: P235pwdpass");
        subject.setPwd("P235pwdpass");
    }
}
