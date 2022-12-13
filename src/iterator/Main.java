package iterator;

public class Main {
    public static void main(String args[]) {
        aircraftCompaniesCollection aCCollection = new aircraftCompaniesCollection();
        System.out.println("Aircraft companies: ");
        for(Iterator iter = aCCollection.getIterator(); iter.nextPres();){
            String aircraftCompanyName = (String)iter.next();
            System.out.println(aircraftCompanyName);
        }
    }
}
