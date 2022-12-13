package interpreterPattern;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Interpreter {
    public String SHA256Hash (String empPassword) throws NoSuchAlgorithmException {
        MessageDigest mD = MessageDigest.getInstance("MD5");
        byte[] messDig = mD.digest(empPassword.getBytes());
        BigInteger signumRepr = new BigInteger(1, messDig);
        String hashText = signumRepr.toString(16);
        return hashText;
    }

    public String MD5Hash (String empPassword) throws NoSuchAlgorithmException {
        MessageDigest mD = MessageDigest.getInstance("SHA-256");
        byte[] messDig = mD.digest(empPassword.getBytes());
        BigInteger signumRepr = new BigInteger(1, messDig);
        String hashText = signumRepr.toString(16);
        return hashText;
    }
}
