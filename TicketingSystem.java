/*
 * The program implements ticketing system in the shop
 * Every 3 seconds a new customer arrives and is given a numbered ticket
 * Every 5 seconds a sales is ready to see a customer if there is any
 * Customers are seen in the order of their arrival to the shop
 *
 */



import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;


/**
 *
 * @author David Yao
 */


public class TicketingSystem {


    private static int queueNumber = 1;
    private static Queue<String> customerQueue = new LinkedList<>();


    public static void main(String[] args) {


        Timer timer = new Timer();

        //timed event - first customer in line to be seen, if there are any customers
        timer.schedule(new TicketServingTask(), 0, 5000);

        //timed event - adding new customer on their arrival
        timer.schedule(new AddCustomers(), 0, 3000);


    }

    //inner class to describe the task of serving ticket to the first customer in a queue
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

    //inner class to describe the task of adding customer in a queue
    public static class AddCustomers extends TimerTask {

        public void run() {

            customerQueue.add("ticket " + queueNumber);
            System.out.println("Customer with ticket " + queueNumber + " is added to the queue. \n");
            queueNumber++;

        }
    }


}

