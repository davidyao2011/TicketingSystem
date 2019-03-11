import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;


public class TicketingSystem {


    private static int queueNumber = 1;
    private static Queue<String> customerQueue = new LinkedList<>();


    public static void main(String[] args) {


        Timer timer = new Timer();

        timer.schedule(new TicketServingTask(), 0, 5000);

        timer.schedule(new AddCustomers(), 0, 3000);


    }


    public static class TicketServingTask extends TimerTask {

        public void run() {

            System.out.println("Sales Assistant is ready to see the next customer. \n");
            if (customerQueue.isEmpty()) {
                System.out.println("There are no customers to see.\n");

            } else {
                System.out.println("The customer with " + customerQueue.poll() + " will be seen.");
                System.out.println("The customer with the following tickets are in the queue: " + customerQueue.toString() + "\n");

            }
        }
    }

    public static class AddCustomers extends TimerTask {

        public void run() {

            customerQueue.add("ticket " + queueNumber);
            System.out.println("Customer with ticket " + queueNumber + " is added to the queue. \n");
            queueNumber++;

        }
    }


}

