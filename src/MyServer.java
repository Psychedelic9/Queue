import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyServer {
    private ThreadPoolExecutor executor;

    public MyServer() {
        this.executor = new ThreadPoolExecutor(
                100,120,100L,
                TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(120));
    }
    public void submitSeatTask(CustomSeat task){
        if (executor.getActiveCount()<120){
            System.out.println("Server : A new Task has arrived");
            executor.submit(task);
            System.out.printf("Server : Pool Size : %d\n",executor.getPoolSize());
            System.out.printf("Server : Active count :%d\n",executor.getActiveCount());
            System.out.printf("Server : Complete Tasks :%d\n ",executor.getCompletedTaskCount());
        }


    }

    public void endServer(){
        executor.shutdown();
    }
}
