public class Test {
    public static void main(String[] args) {
        DeskStorage storage = new DeskStorage();

        MyServer server = new MyServer();
        for (int i = 0;i< 100;i++) {
            server.submitSeatTask(new CustomSeat(storage, "A"));
            server.submitSeatTask(new CustomSeat(storage, "A"));
            server.submitSeatTask(new CustomSeat(storage, "A"));

            server.submitSeatTask(new CustomSeat(storage, "B"));
            server.submitSeatTask(new CustomSeat(storage, "C"));

        }
        server.endServer();


//        Thread seat1 = new Thread(new CustomSeat(storage,"A"));
//        seat1.setName("消费者1");
//        Thread seat2 = new Thread(new CustomSeat(storage,"A"));
//        seat2.setName("消费者2");
//        Thread seat3 = new Thread(new CustomSeat(storage,"B"));
//        seat3.setName("消费者3");
//        Thread seat4 = new Thread(new CustomSeat(storage,"A"));
//        seat4.setName("消费者4");
//        Thread seat5 = new Thread(new CustomSeat(storage,"B"));
//        seat5.setName("消费者5");
//        Thread seat6 = new Thread(new CustomSeat(storage,"C"));
//        seat6.setName("消费者6");
//
//        seat1.start();
//        seat2.start();
//        seat3.start();
//        seat4.start();
//        seat5.start();
//        seat6.start();


    }
}
