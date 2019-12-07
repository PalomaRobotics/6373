package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Evan_ServoClawTest", group = "TeleOp")

public class Evan_ServoClawTest extends OpMode
{
    private ElapsedTime runtime = new ElapsedTime();
    boolean isPressed = false;
    static final double INCREMENT   = 0.01;     // amount to slew servo each CYCLE_MS cycle
    static final int    CYCLE_MS    =   50;     // period of each cycle
    static final double MAX_POS     =  1.0;     // Maximum rotational position
    static final double MIN_POS     =  0.0;     // Minimum rotational position
    double  startPosition = (MAX_POS - MIN_POS) / 2; //star halfway
    Servo servo;
    double  position;

    @Override
    public void init()
    {

        servo = hardwareMap.servo.get("CLAWSERVO");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        position = (MAX_POS - MIN_POS) / 2; // Start at halfway position
        servo.setPosition(position);

    }

    @Override
    public void loop()
    {
        runtime.reset();
        if (gamepad1.x)
        {
            isPressed=true;
            while (isPressed==true)
            {
                if(position >= MAX_POS)
                {
                    position = MAX_POS;
                    servo.setPosition(1);
                    isPressed=false;
                }
                else
                {
                    position += INCREMENT;
                    servo.setPosition(1);
                    isPressed=false;
                }
            }
            servo.setPosition(.5);

        }
        else if (gamepad1.a)
        {
            isPressed=true;
            while (isPressed==true)
            {
                if(position <= MIN_POS)
                {
                    position = MIN_POS;
                    servo.setPosition(0);
                    isPressed=false;
                }
                else
                {
                    position -= INCREMENT;
                    servo.setPosition(0);
                    isPressed=false;
                }
            }
            servo.setPosition(.5);
        }


        telemetry.addData("servo", servo.getPosition());
        telemetry.update();

    }

    @Override
    public void stop()
    {

    }


}
