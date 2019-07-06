public class Main {

    public static void main(String[] args) {
        Database database = new Database();

        DBUser dbUser1 = new DBUser(database);
        DBUser dbUser2= new DBUser(database);
        DBUser dbUser3 = new DBUser(database);

        database.editTableRecord("Items", 1, "Delete");

        database.unregisterObserver(dbUser2);

        database.editTableRecord("Items", 2, "Create");
    }
}
