package interpreterPattern;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 implements interpreterInterface {
    private String password;

    public SHA256 (String password) {
        this.password = password;
    }

    @Override
    public String inter(Interpreter interpreter) throws NoSuchAlgorithmException {
        return interpreter.SHA256Hash(this.password);
    }
}

