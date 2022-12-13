package interpreterPattern;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static Interpreter interpreter;

    public Main (Interpreter i){
        this.interpreter=i;
    }

    public static String inter(String s) throws NoSuchAlgorithmException {
        interpreterInterface interpr = null;
        if(s.contains("SHA256")){
            interpr = new SHA256(s.substring(0,s.indexOf(" ")));
        }else if(s.contains("MD5")){
            interpr = new MD5(s.substring(0,s.indexOf(" ")));
        }else return s;
        return interpr.inter(interpreter);
    }

    public static void main(String args[]) throws NoSuchAlgorithmException {
        Scanner input = new Scanner(System.in);
        String comm = input.nextLine();
        Main main = new Main(new Interpreter());
        System.out.println(comm+": = "+main.inter(comm));
    }
}
