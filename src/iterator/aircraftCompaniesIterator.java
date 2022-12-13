package iterator;

public class aircraftCompaniesIterator implements Iterator {
    int index;

    @Override
    public boolean nextPres() {
        if(index < aircraftCompaniesCollection.aircraftCompanies.length){
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        if(this.nextPres()){
            return aircraftCompaniesCollection.aircraftCompanies[index++];
        }
        return null;
    }
}
