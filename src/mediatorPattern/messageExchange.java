package mediatorPattern;

import java.util.HashMap;
import java.util.Map;

public class messageExchange implements IMessageExchange {

    private Map<String, aircraftCEmployee> empMap = new HashMap<>();

    @Override
    public void sendMessage(String msg, String empId) {
        aircraftCEmployee aE = empMap.get(empId);
        aE.receive(msg);
    }

    @Override
    public void addEmployee(aircraftCEmployee aEmp) {
        this.empMap.put(aEmp.getId(), aEmp);
    }
}
