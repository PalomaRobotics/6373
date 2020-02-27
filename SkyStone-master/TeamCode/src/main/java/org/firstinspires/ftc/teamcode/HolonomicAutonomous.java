package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.internal.opmode.TelemetryImpl;
public class HolonomicAutonomous {
    public static void ForwardTime (DcMotor frontLeftMotor, DcMotor frontRightMotor, DcMotor backLeftMotor, DcMotor backRightMotor, long Milliseconds, double power)
    {
        frontLeftMotor.setPower(-(Math.abs(power)));
        frontRightMotor.setPower((Math.abs(power)));
        backLeftMotor.setPower(-(Math.abs(power)));
        backRightMotor.setPower((Math.abs(power)));
        GyroClass.sleep(Milliseconds);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        GyroClass.sleep(750);
    }
    public static void BackwardTime (DcMotor frontLeftMotor, DcMotor frontRightMotor, DcMotor backLeftMotor, DcMotor backRightMotor, long Milliseconds, double power)
    {
        frontLeftMotor.setPower((Math.abs(power)));
        frontRightMotor.setPower(-(Math.abs(power)));
        backLeftMotor.setPower((Math.abs(power)));
        backRightMotor.setPower(-(Math.abs(power)));
        GyroClass.sleep(Milliseconds);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        GyroClass.sleep(750);
    }
    public static void RightTime (DcMotor frontLeftMotor, DcMotor frontRightMotor, DcMotor backLeftMotor, DcMotor backRightMotor, long Milliseconds, double power)
    {
        frontLeftMotor.setPower(-(Math.abs(power)));
        frontRightMotor.setPower(-(Math.abs(power)));
        backLeftMotor.setPower((Math.abs(power)));
        backRightMotor.setPower((Math.abs(power)));
        GyroClass.sleep(Milliseconds);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        GyroClass.sleep(750);
    }
    public static void LeftTime (DcMotor frontLeftMotor, DcMotor frontRightMotor, DcMotor backLeftMotor, DcMotor backRightMotor, long Milliseconds, double power)
    {
        frontLeftMotor.setPower((Math.abs(power)));
        frontRightMotor.setPower((Math.abs(power)));
        backLeftMotor.setPower(-(Math.abs(power)));
        backRightMotor.setPower(-(Math.abs(power)));
        GyroClass.sleep(Milliseconds);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        GyroClass.sleep(750);
    }
}
