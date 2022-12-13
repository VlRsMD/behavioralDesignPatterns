package iterator;

public class aircraftCompaniesCollection implements Container {
    public static String aircraftCompanies[] = {"Boeing" , "Airbus" ,"Embraer" , "Bombardier", "Comac"};
    @Override
    public Iterator getIterator() {
        return new aircraftCompaniesIterator();
    }
}
