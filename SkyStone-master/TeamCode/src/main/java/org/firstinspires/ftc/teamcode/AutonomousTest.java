package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchImpl;
import com.qualcomm.robotcore.hardware.ColorSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "AutonomousTest", group = "Autonomous")
public class AutonomousTest extends LinearOpMode {
    int TURN;
    DcMotor FL;
    DcMotor FR;
    DcMotor BL;
    DcMotor BR;
    public ColorSensor Color;
    public ModernRoboticsI2cRangeSensor Range = null;
    double[] dirs = {0,0,0,0};
    int x;
    int turner;
    @Override
    public void runOpMode() throws InterruptedException {
        FL = hardwareMap.dcMotor.get("FL");
        BL = hardwareMap.dcMotor.get("BL");
        FR = hardwareMap.dcMotor.get("FR");
        BR = hardwareMap.dcMotor.get("BR");
        Color = hardwareMap.colorSensor.get("color");
        Range = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "rangeSensor");
        float hsvValues[] = {0F, 0F, 0F};
        final float values[] = hsvValues;
        TURN = 540;
        Range_Sensor.toRangeDir(10, DistanceUnit.INCH,1,0);
     /*   waitForStart();
        dirs = HolonomicDrive.RoboMoveXY(1,0);
        FL.setPower(dirs[0]);
        FR.setPower(dirs[1]);
        BL.setPower(dirs[2]);
        BR.setPower(dirs[3]);
        while (Range.getDistance(DistanceUnit.INCH)>10) {
            telemetry.addData("Path", "Distance: 10 Inches", Range.getDistance(DistanceUnit.INCH) );
            telemetry.update();
        }


        dirs = HolonomicDrive.RoboMoveXY(0,0);
        FL.setPower(dirs[0]);
        FR.setPower(dirs[1]);
        BL.setPower(dirs[2]);
        BR.setPower(dirs[3]);

      */
        turner = FL.getCurrentPosition();
        EncoderClass.RunToEncoderDegreeAsync(FL, EncoderClass.MotorType.NeveRest40, -TURN, 0.60, false);
        EncoderClass.RunToEncoderDegreeAsync(FR, EncoderClass.MotorType.NeveRest40, -TURN, 0.60, false);
        EncoderClass.RunToEncoderDegreeAsync(BL, EncoderClass.MotorType.NeveRest40, -TURN, 0.60, false);
        EncoderClass.RunToEncoderDegreeAsync(BR, EncoderClass.MotorType.NeveRest40, -TURN, 0.60, false);
        while (turner-539<FL.getCurrentPosition())
        {
           /* dirs = HolonoGmicDrive.RoboMoveXY(0,0);
            FL.setPower(dirs[0]);
            FR.setPower(dirs[1]);
            BL.setPower(dirs[2]);
            BR.setPower(dirs[3]);
            */
        }
        dirs = HolonomicDrive.RoboMoveXY(-1,0);
        FL.setPower(dirs[0]);
        FR.setPower(dirs[1]);
        BL.setPower(dirs[2]);
        BR.setPower(dirs[3]);
        while (Range.getDistance(DistanceUnit.INCH)<64)
        {
            telemetry.addData("Path", "Distance: 64 Inches", Range.getDistance(DistanceUnit.INCH) );
            telemetry.update();
        }
        dirs = HolonomicDrive.RoboMoveXY(0,0);
        FL.setPower(dirs[0]);
        FR.setPower(dirs[1]);
        BL.setPower(dirs[2]);
        BR.setPower(dirs[3]);
        /*
       dirs = HolonomicDrive.RoboRotate(1);
        FL.setPower(.5*(dirs[0]));
        FR.setPower(.5*(dirs[1]));
        BL.setPower(.5*(dirs[2]));
        BR.setPower(.5*(dirs[3]));
        while (turnCorner1 == false || turnStop1 == false)
        {
            turnCorner1Range = Range.getDistance(DistanceUnit.MM);
            if (Range.getDistance(DistanceUnit.MM)<turnCorner1Range)
            {
                turnCorner1 = true;

            }
            if (turnCorner1 == true) {
                turnStop1Range = Range.getDistance(DistanceUnit.MM);
                if (Range.getDistance(DistanceUnit.MM) > turnStop1Range) {
                    turnStop1 = true;
                    dirs = HolonomicDrive.RoboMoveXY(0, 0);
                }
            }
        }


      /*dirs = HolonomicDrive.RoboMoveXY(0,-1);
        FL.setPower(dirs[0]);
        FR.setPower(dirs[1]);
        BL.setPower(dirs[2]);
        BR.setPower(dirs[3]);
        */

    }


}

