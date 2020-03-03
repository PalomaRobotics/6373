package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Evan_TeleOp", group = "TeleOp")

public class Evan_TeleOp extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor LFD = null;
    private DcMotor RFD = null;
    private DcMotor LBD = null;
    private DcMotor RBD = null;


    @Override
    public void init() {
        LFD  = hardwareMap.get(DcMotor.class, "FL");
        RFD = hardwareMap.get(DcMotor.class, "FR");
        LBD  = hardwareMap.get(DcMotor.class, "BL");
        RBD = hardwareMap.get(DcMotor.class, "BR");

        LFD.setDirection(DcMotor.Direction.REVERSE);
        RFD.setDirection(DcMotor.Direction.FORWARD);
        LBD.setDirection(DcMotor.Direction.REVERSE);
        RBD.setDirection(DcMotor.Direction.FORWARD);

    }

    @Override
    public void loop() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();


        // Wait for the game to start (driver presses PLAY)

        runtime.reset();

        // run until the end of the match (driver presses STOP)
            double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
            double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
            double rightX = gamepad1.right_stick_x;

            final double v1 = r * Math.cos(robotAngle) + rightX;
            final double v2 = r * Math.sin(robotAngle) - rightX;
            final double v3 = r * Math.sin(robotAngle) + rightX;
            final double v4 = r * Math.cos(robotAngle) - rightX;

            LFD.setPower(v1);
            RFD.setPower(v2);
            LBD.setPower(v3);
            RBD.setPower(v4);

            telemetry.update();

    }
}
