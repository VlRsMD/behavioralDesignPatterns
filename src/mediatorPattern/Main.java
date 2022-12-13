package mediatorPattern;

public class Main {
    public static void main(String[] args)
    {
        IMessageExchange airport = new messageExchange();

        aircraftCEmployee emp1 = new Dispatcher(airport,"1", "John");
        aircraftCEmployee emp2 = new Pilot(airport,"2", "William");

        airport.addEmployee(emp1);
        airport.addEmployee(emp2);

        emp1.send("High turbulence zone expected.", "2");
        emp2.send("Warning taken into account.", "1");
    }
}
