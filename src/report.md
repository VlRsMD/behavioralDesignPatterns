**Behavioral design patterns**

**Laboratory work**

**TMPS Course**

**Vladimir Russu, FAF-201**



**Overview**

In this laboratory work are implemented 4 behavioral design patterns: iterator, interpreter, observer and mediator. The implementations of each design pattern are contained in separate packages.



**1.    Interpreter Pattern**

This design pattern provides a way for the evaluation of a language grammar. The interpreter provided by this pattern handles the language grammar. In the following implementation the interpreter handles the task of hashing a given password either according to the MD5 algorithm or to the SHA-256 algorithm. First, there Is an interpreter class which has 2 methods for performing hashing either with MD5 or with SHA-256:

<pre>public class Interpreter {
public String SHA256Hash (String empPassword) throws NoSuchAlgorithmException {
MessageDigest mD = MessageDigest.getInstance("MD5");
byte[] messDig = mD.digest(empPassword.getBytes());
BigInteger signumRepr = new BigInteger(1, messDig);
String hashText = signumRepr.toString(16);
return hashText;
}

public String MD5Hash (String empPassword) throws NoSuchAlgorithmException {
MessageDigest mD = MessageDigest.getInstance("SHA-256");
byte[] messDig = mD.digest(empPassword.getBytes());
BigInteger signumRepr = new BigInteger(1, messDig);
String hashText = signumRepr.toString(16);
return hashText;
}
}
</pre>


Then there is an interface “interpreterInterface” which has a method with a parameter of the Interpreter class type:

<pre>public interface interpreterInterface {

String inter(Interpreter interpreter) throws NoSuchAlgorithmException;

}
</pre>


Further there are 2 classes which implement the above interface: one class is used for hashing with MD5 and another for hashing with SHA-256. These classes call the correspondent methods of the Interpreter class in order to perform hashing:

<pre>public class MD5 implements interpreterInterface {

private String password;



public MD5 (String password) {

this.password = password;

}



@Override

public String inter(Interpreter interpreter) throws NoSuchAlgorithmException {

return interpreter.MD5Hash(this.password);

}

}
</pre>

<pre>
public class SHA256 implements interpreterInterface {

private String password;



public SHA256 (String password) {

this.password = password;

}


@Override

public String inter(Interpreter interpreter) throws NoSuchAlgorithmException {

return interpreter.SHA256Hash(this.password);

}

}
</pre>


Finally, there is the main class to test the performance of the implementation of this design pattern. The test acts in the following way: a user inputs command of the type “\[password\] with MD5/SHA-156”, and gets the output which is hashtext of the password either for MD5 or SHA-256 algorithm:

<pre>public class Main {

public static Interpreter interpreter;



public Main (Interpreter i){

this.interpreter=i;

}



public static String inter(String s) throws NoSuchAlgorithmException {

interpreterInterface interpr = null;

if(s.contains("SHA256")){

interpr = new SHA256(s.substring(0,s.indexOf(" ")));

}else if(s.contains("MD5")){

interpr = new MD5(s.substring(0,s.indexOf(" ")));

}else return s;

return interpr.inter(interpreter);

}



public static void main(String args[]) throws NoSuchAlgorithmException {

Scanner input = new Scanner(System.in);

String comm = input.nextLine();

Main main = new Main(new Interpreter());

System.out.println(comm+": = "+main.inter(comm));

}

}
</pre>


The output is the following:
<pre>
pass123987 with SHA256
pass123987 with SHA256: = 6520d344b4fcb331dd2a60ea84efc192
</pre>


**2.    Iterator Pattern**

The iterator design pattern offers access to the elements of a composite object without exposing its underlying representation. In the following implementation the iterator pattern is used to traverse an array containing the names of aircraft companies. First, there is an iterator interface which has 2 methods: one is of the Boolean type and it checks whether the collection (array) of objects is empty or not, and another is a method to traverse the collection:
<pre>
public interface Iterator {

public boolean nextPres();

public Object next();

}
</pre>


Then there is a container interface which has a method of the Iterator interface type:
<pre>
public interface Container {

public Iterator getIterator();

}
</pre>


This container interface is the implemented by a class which initializes the array with the names of the aircraft companies:
<pre>
public class aircraftCompaniesCollection implements Container {

public static String aircraftCompanies[] = {"Boeing" , "Airbus" ,"Embraer" , "Bombardier", "Comac"};

@Override

public Iterator getIterator() {

return new aircraftCompaniesIterator();

}

}
</pre>


Then there is a class which implements the Iterator interface and uses the array of aircraft company names in order to traverse that array:
<pre>
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

return aircraftCompaniesCollection.aircraftCompanies\[index++\];

}

return null;

}

}
</pre>


Then there is a test class in order to print out all the aircraft company names using a for loop:
<pre>
public class Main {

public static void main(String args\[\]) {

aircraftCompaniesCollection aCCollection = new aircraftCompaniesCollection();

System.out.println("Aircraft companies: ");

for(Iterator iter = aCCollection.getIterator(); iter.nextPres();){

String aircraftCompanyName = (String)iter.next();

System.out.println(aircraftCompanyName);

}

}

}
</pre>


The output is the following:
<pre>
Aircraft companies:
Boeing
Airbus
Embraer
Bombardier
Comac
</pre>


**3.    Mediator Pattern**

The mediator pattern is used when it is necessary to provide louse coupling or for reducing the complexity of interaction between objects. In the following implementations mediator is used to provide a communication environment for the aircraft employees (dispatcher and pilot) for them to be able to send and receive messages. First, there is an interface which has methods for sending messages and creating new employees:
<pre>
public interface IMessageExchange {

public void sendMessage(String msg, String empId);



void addEmployee(aircraftCEmployee aE);

}
</pre>


Then there is a class for creating an employee of an aircraft company. This class has as well methods for sending and receiving messages:
<pre>
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
</pre>


Then there is a class for the message exchange between employees, which implements the “IMessageExchange” interface:
<pre>
public class messageExchange implements IMessageExchange {

private Map String, aircraftCEmployee> empMap = new HashMap<>();


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
</pre>


Then there are 2 classes which extend the employee class: it is the Dispatcher class and the Pilot class. They both override the send and receive methods in order to perform message exchange:
<pre>
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
</pre>

<pre>
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
</pre>


Finally, there is a test class in which new employees are created and they initiate communication between them:
<pre>
public class Main {

public static void main(String\[\] args)

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
</pre>


The output is the following:
<pre>
Dispatcher John :: Sending Message : High turbulence zone expected.
Pilot William :: Received Message : High turbulence zone expected.
Pilot William :: Sending Message : Warning taken into account.
Dispatcher John :: Received Message : Warning taken into account.
</pre>


**4.    Observer pattern**

The observer design pattern is used in order to create one-to-many dependency between objects. Therefore, when one object changes its state, all the object which depend on that object get automatically updated. In the following example the observer pattern is used to change the password which is then being hashed with MD5 and SHA-256 algorithms. First there is an observer abstract class. It has a method to update the state of an object:
<pre>
public abstract class Observer {

protected Subject subject;

public abstract void update() throws NoSuchAlgorithmException;

}
</pre>


Then there is a subject class, which has a list of observers, a method to add a new observer, a method to notify all the observers about an update, and getters and setters for password:
<pre>
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
</pre>


Then there is a class which extends the observer class overriding its update method and is used to hash the password using the MD5 algorithm:
<pre>
public class MD5Observer extends Observer {

public MD5Observer(Subject subj){

this.subject = subj;

this.subject.add(this);

}



@Override

public void update() throws NoSuchAlgorithmException {

MessageDigest mD = MessageDigest.getInstance("MD5");

byte[] messDig = mD.digest(this.subject.getPwd().getBytes());

BigInteger signumRepr = new BigInteger(1, messDig);

String hashText = signumRepr.toString(16);

System.out.println("MD5 hashtext value: " + hashText);

}

}
</pre>


Then there is a class which extends the observer class overriding its update method and is used to hash the password using the SHA-256 algorithm:
<pre>
public class SHA256Observer extends Observer {

public SHA256Observer(Subject subj){

this.subject = subj;

this.subject.add(this);

}



@Override

public void update() throws NoSuchAlgorithmException {

MessageDigest mD = MessageDigest.getInstance("SHA-256");

byte[] messDig = mD.digest(this.subject.getPwd().getBytes());

BigInteger signumRepr = new BigInteger(1, messDig);

String hashText = signumRepr.toString(16);

System.out.println("SHA-256 hashtext value: " + hashText);

}

}
</pre>


Finally, there is a test class which demonstrates how all the hashtexts are updated when the password is changed:
<pre>
public class Main {

public static void main(String args[]) throws NoSuchAlgorithmException {

Subject subject = new Subject();



new SHA256Observer(subject);

new MD5Observer(subject);



System.out.println("Password change: pass127P");

subject.setPwd("pass127P");

System.out.println("State change: P235pwdpass");

subject.setPwd("P235pwdpass");

}

}
</pre>


The output is the following:
<pre>
Password change: pass127P
SHA-256 hashtext value: 722673960b75a7cee35588bbbe287213b9c6f0e135833cc1a975d60574321740
MD5 hashtext value: 19f386ef1002217b6d236012291a6386
State change: P235pwdpass
SHA-256 hashtext value: 52bba801065be45b42a1fec415b29f55d2362985c1fb268e835e04bc064a4da7
MD5 hashtext value: 153ac7491cce5dc98290640bef766e9e
</pre>