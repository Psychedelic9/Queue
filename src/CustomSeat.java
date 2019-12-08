import java.util.Random;

public class CustomSeat implements Runnable {
    private DeskStorage storage;
    private String type;

    public CustomSeat(DeskStorage storage, String type) {
        this.storage = storage;
        this.type = type;
    }


    @Override
    public void run() {
        Desk desk = storage.customSeated(type);
        if (desk!=null && desk.getDeskType().equals("W")){
            System.out.println("座位已满"+"取号"+type+"W"+desk.getDeskNum());

        }else if (desk!=null && !desk.getDeskType().equals("W")){
            Random random = new Random();
            int s = random.nextInt(9);
            try {
                Thread.sleep(1000 * s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(new CustomLeave(storage, desk)).start();
        }

    }
}
