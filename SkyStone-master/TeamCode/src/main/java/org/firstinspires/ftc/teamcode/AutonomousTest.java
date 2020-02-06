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

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.internal.opmode.TelemetryImpl;

import com.qualcomm.robotcore.hardware.GyroSensor;
@Autonomous(name = "AutonomousTest", group = "Autonomous")
public class AutonomousTest extends LinearOpMode {
    int TURN;
    public ModernRoboticsI2cGyro Gyro;
    public static DcMotor FL;
    public static DcMotor FR;
    public static DcMotor BL;
    public static DcMotor BR;
    public ColorSensor Color;
    public static ModernRoboticsI2cRangeSensor Range = null;
    public I2cDevice RANGE1 = hardwareMap.i2cDevice.get("rangeSensor");
    public double[] dirs = {0, 0, 0, 0};
    int x;
    int turner;
    public Telemetry telemetry = new TelemetryImpl(this);

    @Override
    public void runOpMode() throws InterruptedException {
        FL = hardwareMap.dcMotor.get("FL");
        BL = hardwareMap.dcMotor.get("BL");
        FR = hardwareMap.dcMotor.get("FR");
        BR = hardwareMap.dcMotor.get("BR");
        Gyro = (ModernRoboticsI2cGyro) hardwareMap.gyroSensor.get("gyro");
        GyroClass gyroObject = new GyroClass(Gyro,FL,FR,BL,BR,0.25,telemetry);
        Color = hardwareMap.colorSensor.get("color");
        //Range = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "rangeSensor");

      //  float hsvValues[] = {0F, 0F, 0F};
     //   final float values[] = hsvValues;

        Range_Sensor range_object = new Range_Sensor(telemetry, RANGE1);

        waitForStart();


        range_object.toRangeDir(10, DistanceUnit.INCH, 1, 0); //drive sideways and stop

        gyroObject.Turn(-90);


        //FL.setPower(-0.40); //turn right
        //FR.setPower(0.40);
        //BL.setPower(-0.40);
        //BR.setPower(0.40);

        GyroClass.sleep(1000);

        range_object.toRangeDir(20, DistanceUnit.INCH, 1, 0);



    }
}

