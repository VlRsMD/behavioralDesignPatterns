package observerPattern;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Observer extends Observer {
    public SHA256Observer(Subject subj){
        this.subject = subj;
        this.subject.add(this);
    }

    @Override
    public void update() throws NoSuchAlgorithmException {
        MessageDigest mD = MessageDigest.getInstance("SHA-256");
        byte[] messDig = mD.digest(this.subject.getPwd().getBytes());
        BigInteger signumRepr = new BigInteger(1, messDig);
        String hashText = signumRepr.toString(16);
        System.out.println("SHA-256 hashtext value: " + hashText);
    }
}
