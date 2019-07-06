import java.util.ArrayList;

public class Database implements Subject {

    private ArrayList<Observer> observers;
    private String table;
    private int recordID;
    private String operation;

    public Database(){
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregisterObserver(Observer deleteObserver) {
        int observerIndex = this.observers.indexOf(deleteObserver);
        System.out.println("\nObserver " + (observerIndex + 1) + " unregistered.");
        this.observers.remove(deleteObserver);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : this.observers){
            observer.update(table, recordID, operation);
        }
    }

    public void editTableRecord(String table, int recordID, String operation){
        this.table = table;
        this.recordID = recordID;
        this.operation = operation;
        notifyObserver();
    }
}
