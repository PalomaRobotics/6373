package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "SuperBotsTest", group = "TeleOp")
public class TestCode extends OpMode {
    private DcMotor LFD = null;
    private DcMotor RFD = null;
    private DcMotor LBD = null;
    private DcMotor RBD = null;
    public void init() {
        LFD = hardwareMap.get(DcMotor.class, "FL");
        RFD = hardwareMap.get(DcMotor.class, "FR");
        LBD = hardwareMap.get(DcMotor.class, "BL");
        RBD = hardwareMap.get(DcMotor.class, "BR");
    }
    public void loop() {
        if (gamepad1.a)
        {
            Robot.MecanumMoveForwardTele(LFD,RFD,LBD,RBD,.5);
        }
        if ((!gamepad1.a && !gamepad1.b && !gamepad1.y && !gamepad1.x))
        {
            Robot.DriveStop(LFD,RFD,LBD,RBD);
        }
    }
}
