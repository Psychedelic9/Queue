import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class DeskStorage {
    private Desk[] deskAs = new Desk[20];
    private Desk[] deskBs = new Desk[10];
    private Desk[] deskCs = new Desk[5];
    private int availableDeskA = 20;//4人桌总数
    private int availableDeskB = 10;//6人桌总数
    private int availableDeskC = 5;//8人桌总数
    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    private static int waitingNum = 0;

    public synchronized static int getWaitingNum(){
        waitingNum++;
        return waitingNum;
    }

    public synchronized Desk customSeated(String type) {
        switch (type) {
            case "A":
                while (availableDeskA == 0) {
                    try {
                        System.out.println("4人桌满");
                        int no = getWaitingNum();
                        queue.add(type+"w"+no);
                        wait();
                        return new Desk(no,"W");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Desk deskA = new Desk(availableDeskA, type);
                deskAs[availableDeskA - 1] = deskA;
                System.out.println("第A" + availableDeskA-- + "桌客人入座");
                return deskA;

            case "B":
                while (availableDeskB == 0) {
                    try {
                        System.out.println("6人桌满");
                        wait();
                        return null;

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Desk deskB = new Desk(availableDeskB, type);
                deskBs[availableDeskB - 1] = deskB;
                System.out.println("第B" + availableDeskB-- + "桌客人入座");
                return deskB;
            case "C":
                while (availableDeskC == 0) {
                    try {
                        System.out.println("8人桌满");
                        wait();
                        return null;

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Desk deskC = new Desk(availableDeskC, type);
                deskCs[availableDeskC - 1] = deskC;
                System.out.println("第C" + availableDeskC-- + "桌客人入座");
                return deskC;

            default:
                return null;
        }
    }


    public synchronized Desk customLeave(Desk desk) {
        switch (desk.getDeskType()) {
            case "A":
                while (availableDeskA == deskAs.length) {
                    try {
                        System.out.println("4人桌无人用餐");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                deskAs[availableDeskA++] = null;
                System.out.println("A" + desk.getDeskNum() + "桌客人离开");
                if (!queue.isEmpty()){
                    try {
                        String take = queue.take();
                        queue.remove(take);
                        System.out.println(take+"用餐了！");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                notifyAll();
                return desk;
            case "B":
                while (availableDeskB == deskBs.length) {
                    try {
                        System.out.println("6人桌无人用餐");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                deskBs[availableDeskB++] = desk;
                System.out.println("B" + desk.getDeskNum() + "桌客人离开");
                notifyAll();
                return desk;
            case "C":
                while (availableDeskC == deskCs.length) {
                    try {
                        System.out.println("8人桌无人用餐");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                deskCs[availableDeskC++] = desk;
                System.out.println("C" + desk.getDeskNum() + "桌客人离开");
                notifyAll();
                return desk;
            default:
                return null;
        }
    }


}
