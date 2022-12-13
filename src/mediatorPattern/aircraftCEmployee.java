package mediatorPattern;

public abstract class aircraftCEmployee {
    private IMessageExchange mediator;

    private String id;
    private String name;

    public aircraftCEmployee(IMessageExchange airport, String id, String name){
        this.mediator = airport;
        this.name = name;
        this.id = id;
    }

    public abstract void send(String msg, String empId);
    public abstract void receive(String msg);

    public IMessageExchange getMediator() {
        return mediator;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
