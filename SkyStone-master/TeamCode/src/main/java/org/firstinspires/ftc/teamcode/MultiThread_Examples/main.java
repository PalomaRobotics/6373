package org.firstinspires.ftc.teamcode.MultiThread_Examples;


/*
Summary:
The code you want to run in a seperate thread goes in ThreadableClass.run()
To instantiate a ThreadableClass object, you will need to pass its constructor an object that implements the CallbackInterface
    You can create any class you want and use it as a callback as long as it implements CallbackInterface. In this example, I created a class called EncoderCallback.
    Classes that implement the CallbackInterface are required to have a method named onComplete() which will run when your asychronous thread finishes.
to run ThreadableClass.run() asynchronously, you need to invoke the Thread method and pass it a threadableClass object (which inturn contains a reference to a CallbackInterface object so it knows what to do when the thread completes)
*/

public class main
{


    public static void main(String[] args)
    {
        FinishedRunningCallback encoderWatch1 = new FinishedRunningCallback(); //Create an object which run when the task completes
        FinishedRunningCallback encoderWatch2 = new FinishedRunningCallback();

        new Thread(new ThreadableClass(encoderWatch1)).start(); //create a new thread and call it run() method. Pass it the callback we created above so it knows what to run when the task completes
        new Thread(new ThreadableClass(encoderWatch2)).start(); //create a new thread and call it run() method. Pass it the callback we created above so it knows what to run when the task completes

        System.out.println("starting");

        while(encoderWatch1.complete == false || encoderWatch2.complete == false) //tie up the program until the task completes
        {

        }
        System.out.println("loop finished");

    }



}

