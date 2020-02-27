package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
@Autonomous(name = "RedRight", group = "Autonomous")
public class RedRight extends LinearOpMode {
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
    @Override
    public void runOpMode() throws InterruptedException {
        FL = hardwareMap.dcMotor.get("FL");
        BL = hardwareMap.dcMotor.get("BL");
        FR = hardwareMap.dcMotor.get("FR");
        BR = hardwareMap.dcMotor.get("BR");
        Base = hardwareMap.dcMotor.get("Base");
        Gyro = (ModernRoboticsI2cGyro) hardwareMap.gyroSensor.get("gyro");
        GyroClass gyroObject = new GyroClass(Gyro, FL, FR, BL, BR, 0.25, telemetry);
        Color = hardwareMap.colorSensor.get("color");
        Range = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "rangeSensor");

        Range_Sensor range_object = new Range_Sensor(telemetry, Range);

        waitForStart();

        HolonomicAutonomous.ForwardTime(FL,FR,BL,BR,600, .7);

        HolonomicAutonomous.LeftTime(FL,FR,BL,BR,1300, .5);

        // range_object.fromRangeDir(50, DistanceUnit.INCH, -1, 0,FL,FR,BL,BR); //drive sideways and stop by the base

        EncoderClass.RunToEncoderDegree(Base, EncoderClass.MotorType.NeveRest60, 90, 0.65, false);

        range_object.toRangeDir(6, DistanceUnit.INCH, 1, 0,FL,FR,BL,BR); //drive sideways and stop at the building zone

        EncoderClass.RunToEncoderDegree(Base, EncoderClass.MotorType.NeveRest60, 90, 0.65, false);

        HolonomicAutonomous.BackwardTime(FL,FR,BL,BR,1400, .5);

        HolonomicAutonomous.LeftTime(FL,FR,BL,BR,1100, .5);

        HolonomicAutonomous.BackwardTime(FL,FR,BL,BR,550, .5);
    }
}
