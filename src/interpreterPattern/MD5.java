package interpreterPattern;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 implements interpreterInterface {
    private String password;

    public MD5 (String password) {
        this.password = password;
    }

    @Override
    public String inter(Interpreter interpreter) throws NoSuchAlgorithmException {
        return interpreter.MD5Hash(this.password);
    }
}
