package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.internal.opmode.TelemetryImpl;
@Autonomous(name = "RedLeft", group = "Autonomous")
public class RedLeft extends LinearOpMode {
    public ModernRoboticsI2cGyro Gyro;
    public static DcMotor FL;
    public static DcMotor FR;
    public static DcMotor BL;
    public static DcMotor BR;
    public static DcMotor Base;
    public ColorSensor Color;
    public static ModernRoboticsI2cRangeSensor Range = null;
    public double[] dirs = {0, 0, 0, 0};
    int x;
    public Telemetry telemetry = new TelemetryImpl(this);

    @Override
    public void runOpMode() throws InterruptedException {
        FL = hardwareMap.dcMotor.get("FL");
        BL = hardwareMap.dcMotor.get("BL");
        FR = hardwareMap.dcMotor.get("FR");
        BR = hardwareMap.dcMotor.get("BR");
        Base  = hardwareMap.dcMotor.get("Base");
        Gyro = (ModernRoboticsI2cGyro) hardwareMap.gyroSensor.get("gyro");
        GyroClass gyroObject = new GyroClass(Gyro,FL,FR,BL,BR,0.25,telemetry);
        Color = hardwareMap.colorSensor.get("color");
        Range = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "rangeSensor");

        Range_Sensor range_object = new Range_Sensor(telemetry, Range);

        waitForStart();


        range_object.toRangeDir(10, DistanceUnit.INCH, 1, 0,FL,FR,BL,BR); //drive sideways and stop

        gyroObject.Turn(75, this);


        FL.setPower(-0.40); //drive blind for 1 second
        FR.setPower(-0.40);
        BL.setPower(0.40);
        BR.setPower(0.40);

        GyroClass.sleep(1000);

        FL.setPower(0.0); //stop
        FR.setPower(0.0);
        BL.setPower(0.0);
        BR.setPower(0.0);

        range_object.toRangeDir(13, DistanceUnit.INCH, 1, 0,FL,FR,BL,BR);
        //range_object.PollSensor();
        GyroClass.sleep(1000);
        gyroObject.Turn(84, this);
        GyroClass.sleep(1000);
        FL.setPower(0.30); //drive blind for 1 second
        FR.setPower(0.30);
        BL.setPower(-0.30);
        BR.setPower(-0.30);

        GyroClass.sleep(800);
        FL.setPower(0.0); //stop
        FR.setPower(0.0);
        BL.setPower(0.0);
        BR.setPower(0.0);
        GyroClass.sleep(550);

        EncoderClass.RunToEncoderDegree(Base, EncoderClass.MotorType.NeveRest60, 90, 0.65, true);

        range_object.toRangeDir(6, DistanceUnit.INCH, 1, 0,FL,FR,BL,BR); //drive sideways and stop
        EncoderClass.RunToEncoderDegree(Base, EncoderClass.MotorType.NeveRest60, 90, 0.65, false);
        FL.setPower(.5);
        FR.setPower(-.5);
        BL.setPower(0.5);
        BR.setPower(-0.5);
        GyroClass.sleep(1400);

        FL.setPower(0.5);
        FR.setPower(0.5);
        BL.setPower(-.5);
        BR.setPower(-.5);
        GyroClass.sleep(750);
        FL.setPower(.5);
        FR.setPower(-.5);
        BL.setPower(0.5);
        BR.setPower(-0.5);
        GyroClass.sleep(800);
        FL.setPower(0.0); //stop
        FR.setPower(0.0);
        BL.setPower(0.0);
        BR.setPower(0.0);
        GyroClass.sleep(1000);
        stop();
    }
}

