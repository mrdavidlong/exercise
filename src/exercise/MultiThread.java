package exercise;

import java.util.ArrayList;
import java.util.List;

// Java code for thread creation by implementing
// the Runnable Interface
class MultithreadingDemo implements Runnable
{
    public void run()
    {
        try
        {
            // Displaying the thread that is running
            System.out.println ("Start Thread " + Thread.currentThread().getId() + " is running");
            Thread.sleep(100);
            System.out.println ("End Thread " + Thread.currentThread().getId() + " is running");

        }
        catch (Exception e)
        {
            // Throwing an exception
            System.out.println ("Exception is caught");
        }
    }
}

// Main Class
public class MultiThread
{
    public static void main(String[] args) throws InterruptedException
    {
        int n = 8; // Number of thread
        List<Thread> threads = new ArrayList<>();
        for (int i=0; i<8; i++) {
            Thread thread = new Thread(new MultithreadingDemo());
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println ("End of loop");
    }
}