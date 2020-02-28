package org.firstinspires.ftc.teamcode.MultiThread_Examples;


public class ThreadableClass implements Runnable
{
    CallbackInterface c;

    public ThreadableClass(CallbackInterface c)
    {
        //Constructor
        //To create a threadable object, you myst pass this constructor a reference to a callback object so I know what to run when the task completes
        this.c = c;
    }

    public void run()
    {
        //this is the code that will run in a new thread
        System.out.println("MyThread running");
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
        }
        System.out.println("Thread complete. Calling callback");
        this.c.onComplete();
    }


}