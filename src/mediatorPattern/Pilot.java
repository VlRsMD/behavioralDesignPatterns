package mediatorPattern;

public class Pilot extends aircraftCEmployee {
    public Pilot(IMessageExchange airport, String id, String name) {
        super(airport, id, name);
    }

    @Override
    public void send(String msg, String userId) {
        System.out.println("Pilot " + this.getName() + " :: Sending Message : " + msg);
        getMediator().sendMessage(msg, userId);
    }

    @Override
    public void receive(String msg) {
        System.out.println("Pilot " + this.getName() + " :: Received Message : " + msg);
    }
}
