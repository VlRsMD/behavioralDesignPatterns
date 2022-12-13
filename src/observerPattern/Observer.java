package observerPattern;

import java.security.NoSuchAlgorithmException;

public abstract class Observer {
    protected Subject subject;
    public abstract void update() throws NoSuchAlgorithmException;
}
