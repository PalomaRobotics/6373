package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name = "TestServo",group = "TeleOp")

public class TestServo extends OpMode{
    private Servo servo;
    public void init()
    {
        servo = hardwareMap.servo.get("servo");
        servo.setPosition(0);
    }
    public void  loop()
    {
        if(servo.getPosition()>0.1&&gamepad1.right_stick_x>0.6)
        {
            servo.setPosition((servo.getPosition()-0.01));
        }
        if(servo.getPosition()<0.9&&gamepad1.right_stick_x<-0.6)
        {
            servo.setPosition((servo.getPosition()+0.01));
        }
        telemetry.addData("X",gamepad1.right_stick_x);
        telemetry.addData("servo",servo.getPosition());
    }

}
