package observerPattern;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private String pwd;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) throws NoSuchAlgorithmException {
        this.pwd = pwd;
        notifyAllObservers();
    }

    public void add(Observer obs){
        observers.add(obs);
    }

    public void notifyAllObservers() throws NoSuchAlgorithmException {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
