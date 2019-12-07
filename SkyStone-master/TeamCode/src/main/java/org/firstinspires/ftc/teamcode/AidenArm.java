package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsAnalogOpticalDistanceSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cIrSeekerSensorV3;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorMROpticalDistance;
@TeleOp(name = "AidenArm", group = "TeleOp")
//@Disabled
public class AidenArm extends OpMode {

    //sensor Variables
   // TouchSensor touchSensor;

    int degreeSlide = 0;
    int degreePinion = 0;
    DcMotor drawerSlide;//This is the Dc motor that is controlling the gear to extend/retract the
    // drawer slide.
    DcMotor pinion;//This is the DcMotor that controls the gear on the rack and pinion
    // for the lift.
    public void init(){


      //  touchSensor = hardwareMap.touchSensor.get("touch1");
        drawerSlide = hardwareMap.get(DcMotor.class,"drawerSlide");
        pinion = hardwareMap.get(DcMotor.class, "Pinion" );
    }
    public void loop(){

     /*   if(touchSensor.isPressed()){
            telemetry.addData("Touch", "Is Pressed");
        } else {
            telemetry.addData("Touch", "If not pressed");
        }
      */
        if(gamepad1.right_bumper) //if you press right bumper...

        {
            degreePinion +=40;
            pinion.setDirection(DcMotor.Direction.FORWARD);
            //this runs the motor 30 degrees. Code continues to run while this is happening.
            EncoderClass.RunToEncoderDegreeAsync(pinion, EncoderClass.MotorType.NeveRest60, 40, 0.40, false);
        }
        if(gamepad1.right_trigger>0.2) //if you press right trigger...

        {
            degreePinion -=40;
            pinion.setDirection(DcMotor.Direction.REVERSE);
            //this runs the motor 30 degrees. Code continues to run while this is happening.
            EncoderClass.RunToEncoderDegreeAsync(pinion, EncoderClass.MotorType.NeveRest60, 40, 0.40, false);
        }
        if(gamepad1.left_bumper) //if you press left bumper...

        {
            degreeSlide +=90;
            drawerSlide.setDirection(DcMotor.Direction.FORWARD);
            //this runs the motor 30 degrees. Code continues to run while this is happening.
            EncoderClass.RunToEncoderDegreeAsync(drawerSlide, EncoderClass.MotorType.NeveRest40, 90, 0.25, false);
        }
        if(gamepad1.left_trigger>0.2) //if you press left trigger...

        {
            degreeSlide -=90;
            drawerSlide.setDirection(DcMotor.Direction.REVERSE);
            //this runs the motor 30 degrees. Code continues to run while this is happening.
            EncoderClass.RunToEncoderDegreeAsync(drawerSlide, EncoderClass.MotorType.NeveRest40, 90, 0.25, false);
        }
        if (gamepad1.dpad_down)
        {
            drawerSlide.setDirection(DcMotor.Direction.REVERSE);
            EncoderClass.RunToEncoderDegreeAsync(drawerSlide, EncoderClass.MotorType.NeveRest40, degreeSlide, 0.25, false);

        }
    }
}
