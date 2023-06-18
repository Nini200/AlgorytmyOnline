package PageMigration;

public interface IMigration {
    void processRequest(int request);
    int getCost();
}
