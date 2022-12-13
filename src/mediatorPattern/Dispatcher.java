package mediatorPattern;

public class Dispatcher extends aircraftCEmployee {
    public Dispatcher(IMessageExchange airport, String id, String name) {
        super(airport, id, name);
    }

    @Override
    public void send(String msg, String userId) {
        System.out.println("Dispatcher " + this.getName() + " :: Sending Message : " + msg);
        getMediator().sendMessage(msg, userId);
    }

    @Override
    public void receive(String msg) {
        System.out.println("Dispatcher " + this.getName() + " :: Received Message : " + msg);
    }
}
