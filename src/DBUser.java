public class DBUser implements Observer{

    private static int observerIDCounter = 0;
    private int observerID;
    private Subject database;
    private String notificationMessage;

    public DBUser(Subject database){
        this.database = database;
        this.observerID = ++observerIDCounter;
        System.out.println("New Observer (DBUser) created with ID: " + this.observerID);
        database.registerObserver(this);
    }

    @Override
    public void update(String table, int recordID, String operation) {
        notificationMessage = "\nMessage for observer with ID: " + observerID + "\n" +
                                "Changes to " + "Table: " + table + ", RecordID: " +
                                    recordID + ", Operation: " + operation;
        alertNotification();
    }

    private void alertNotification(){
        System.out.println(notificationMessage);
    }
}
