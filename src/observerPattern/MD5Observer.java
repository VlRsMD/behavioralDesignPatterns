package observerPattern;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Observer extends Observer {
    public MD5Observer(Subject subj){
        this.subject = subj;
        this.subject.add(this);
    }

    @Override
    public void update() throws NoSuchAlgorithmException {
        MessageDigest mD = MessageDigest.getInstance("MD5");
        byte[] messDig = mD.digest(this.subject.getPwd().getBytes());
        BigInteger signumRepr = new BigInteger(1, messDig);
        String hashText = signumRepr.toString(16);
        System.out.println("MD5 hashtext value: " + hashText);
    }
}
