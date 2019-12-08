import java.util.Random;

public class CustomLeave implements Runnable {
    private DeskStorage storage;
    private Desk desk;

    public CustomLeave(DeskStorage storage, Desk desk) {
        this.storage = storage;
        this.desk = desk;
    }

    @Override
    public void run() {
        storage.customLeave(desk);
    }
}
