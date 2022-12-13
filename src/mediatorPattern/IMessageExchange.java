package mediatorPattern;

public interface IMessageExchange {
    public void sendMessage(String msg, String empId);

    void addEmployee(aircraftCEmployee aE);
}
