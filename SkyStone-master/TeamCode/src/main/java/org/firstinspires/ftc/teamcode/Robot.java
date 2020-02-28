package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.hardware.motors.NeveRest60Gearmotor;
public class Robot {
    public static void MecanumMove (double CircumferenceMM, int x, int y, double speed, int CmDistance, DcMotor FrontLeft, DcMotor FrontRight, DcMotor BackLeft, DcMotor BackRight)
    {
        
    }
    public static void MecanumMoveForwardTele(DcMotor FrontLeft, DcMotor FrontRight, DcMotor BackLeft, DcMotor BackRight, double speed)
    {
        FrontLeft.setPower(-speed);
        FrontRight.setPower(speed);
        BackLeft.setPower(-speed);
        BackRight.setPower(speed);
    }
    public static void MecanumMoveBackWardTele(DcMotor FrontLeft, DcMotor FrontRight, DcMotor BackLeft, DcMotor BackRight, double speed)
    {
        FrontLeft.setPower(speed);
        FrontRight.setPower(-speed);
        BackLeft.setPower(speed);
        BackRight.setPower(-speed);
    }
    public static void MecanumMoveRightTele(DcMotor FrontLeft, DcMotor FrontRight, DcMotor BackLeft, DcMotor BackRight, double speed)
    {
        FrontLeft.setPower(-speed);
        FrontRight.setPower(-speed);
        BackLeft.setPower(speed);
        BackRight.setPower(speed);
    }
    public static void MecanumMoveLeftTele(DcMotor FrontLeft, DcMotor FrontRight, DcMotor BackLeft, DcMotor BackRight, double speed)
    {
        FrontLeft.setPower(speed);
        FrontRight.setPower(speed);
        BackLeft.setPower(-speed);
        BackRight.setPower(-speed);
    }
    public static void DriveStop(DcMotor FrontLeft, DcMotor FrontRight, DcMotor BackLeft, DcMotor BackRight)
    {
        FrontLeft.setPower(0);
        FrontRight.setPower(0);
        BackLeft.setPower(0);
        BackRight.setPower(0);
    }
    public static void MecanumRotateCentralRightTele(DcMotor FrontLeft, DcMotor FrontRight, DcMotor BackLeft, DcMotor BackRight, double speed)
    {
        FrontLeft.setPower(-speed);
        FrontRight.setPower(speed);
        BackLeft.setPower(-speed);
        BackRight.setPower(speed);
    }
}